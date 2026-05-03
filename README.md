# Refactoring Lab — Eliminación de Spaghetti Code

## 📌 Descripción del proyecto

Este proyecto corresponde al laboratorio de la Unidad 6 de Antipatrones de Diseño.  
El objetivo es identificar y refactorizar un sistema con **Spaghetti Code**, aplicando los patrones:

- **Strategy**
- **Command**

Con el fin de reducir la complejidad ciclomatica, mejorar la mantenibilidad y aumentar la testabilidad del sistema.

---

## ⚠️ Antipatrón identificado: Spaghetti Code

El sistema original presenta el antipatrón **Spaghetti Code**, caracterizado por:

- Múltiples niveles de condicionales anidados (hasta 6 niveles)
- Alta complejidad ciclomatica
- Lógica de negocio mezclada (descuentos + notificaciones)
- Difícil mantenimiento y extensión

---

## 🔍 Análisis del código inicial

La clase `ProcesadorPedidos` contiene toda la lógica en un único método:

- Cálculo de descuentos
- Validaciones por tipo de cliente
- Aplicación de promociones
- Impresión de resultados
- Notificaciones

### Problemas detectados:

- Violación del principio **Open/Closed (OCP)**
- Violación de **Single Responsibility**
- Difícil de testear
- Código rígido ante cambios

---

## 🧠 Solución aplicada

Se aplicaron dos patrones de diseño:

---

### 🧩 Patrón Strategy

Se encapsula la lógica de descuentos en estrategias independientes:

#### Interfaz:
- `EstrategiaDescuento`

#### Implementaciones:
- `DescuentoVIP`
- `DescuentoPremium`
- `DescuentoEstandar`

Cada clase contiene únicamente la lógica correspondiente a su tipo de cliente.

---

### ⚙️ Patrón Command

Se encapsula la operación de procesar pedidos en un comando:

#### Interfaz:
- `ComandoPedido`

#### Implementación:
- `ComandoProcesarPedido`

Esto permite desacoplar la ejecución de la lógica del cliente.

---

### 🎯 Selector de estrategia

Se implementa una clase:

- `SelectorEstrategia`

Encargada de elegir la estrategia correcta según el tipo de cliente.

Esto centraliza la decisión y elimina condicionales dispersos.

---

## 🏗️ Arquitectura del sistema

### Clases principales:

- `Pedido` → Modelo de datos
- `ProcesadorPedidos` → (versión inicial con Spaghetti Code)
- `EstrategiaDescuento` → Interfaz Strategy
- `DescuentoVIP`, `DescuentoPremium`, `DescuentoEstandar` → Estrategias concretas
- `ComandoPedido` → Interfaz Command
- `ComandoProcesarPedido` → Implementación Command
- `SelectorEstrategia` → Selección de estrategia
- `Main` → Ejecución del sistema

---

## 🔄 Comparación antes vs después

| Característica | Antes (Spaghetti Code) | Después (Refactorizado) |
|------|----------------------|------------------------|
| Complejidad | Muy alta (6 niveles de anidamiento) | Baja |
| Extensibilidad | Difícil | Fácil (nuevas estrategias) |
| Mantenibilidad | Baja | Alta |
| Testabilidad | Baja | Alta |
| Principios SOLID | Violados | Aplicados |

---

## 📉 Reducción de complejidad

Antes:
- Método con múltiples `if-else` anidados

Después:
- Lógica distribuida en clases
- Uso de polimorfismo
- Eliminación de anidamiento complejo

---
## 📸 Evidencia de ejecución

A continuación se muestran las capturas de la ejecución del sistema antes y después de la refactorización.

---

### 🔴 Antes — Spaghetti Code

Ejecución del sistema utilizando la clase `ProcesadorPedidos` con múltiples condicionales anidados.

<img width="969" height="980" alt="image" src="https://github.com/user-attachments/assets/a22e0b7f-e60c-4f90-977a-2f4192a49b1f" />


---

### 🟢 Después — Strategy + Command

Ejecución del sistema refactorizado aplicando los patrones **Strategy** y **Command**, eliminando el anidamiento y mejorando la estructura.

<img width="895" height="928" alt="image" src="https://github.com/user-attachments/assets/6d26a7ce-267f-4028-8631-a1fa971c3829" />





---

## ▶️ Ejecución del proyecto

### Requisitos:
- Java 17+
- Maven 3.8+

### Comandos:

```bash
mvn compile
mvn exec:java
