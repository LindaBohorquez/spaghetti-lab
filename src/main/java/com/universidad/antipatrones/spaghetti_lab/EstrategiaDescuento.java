package com.universidad.antipatrones.spaghetti_lab;

public interface EstrategiaDescuento {
 double calcular(Pedido pedido);
 String getNombre(); // Para logging y trazabilidad
}
