package com.universidad.antipatrones.spaghetti_lab;

public class SelectorEstrategia {
 private final java.util.Map<String, EstrategiaDescuento> estrategias = java.util.Map.of(
 "VIP", new DescuentoVIP(),
 "PREMIUM", new DescuentoPremium(),
 "ESTANDAR", new DescuentoEstandar()
 );
 public EstrategiaDescuento seleccionar(String tipoCliente) {
 return estrategias.getOrDefault(tipoCliente,
estrategias.get("ESTANDAR"));
 }
}
