package com.universidad.antipatrones.spaghetti_lab;

public class Main {

    public static void main(String[] args) {

        ProcesadorPedidos procesador = new ProcesadorPedidos();

        // 🧪 Pedido 1: VIP con total alto + promo especial
        Pedido pedido1 = new Pedido("P001", "VIP", 1200, "VIPEXTRA");

        // 🧪 Pedido 2: VIP con total medio + promo VIP
        Pedido pedido2 = new Pedido("P002", "VIP", 700, "VIP2026");

        // 🧪 Pedido 3: PREMIUM con promo
        Pedido pedido3 = new Pedido("P003", "PREMIUM", 300, "PREM10");

        // 🧪 Pedido 4: ESTANDAR con promo FIRST
        Pedido pedido4 = new Pedido("P004", "ESTANDAR", 200, "FIRSTBUY");

        // 🧪 Pedido 5 (extra recomendado): ESTANDAR sin promo
        Pedido pedido5 = new Pedido("P005", "ESTANDAR", 150, null);

        // 🔥 Procesar pedidos
        procesador.procesarPedido(pedido1);
        System.out.println("--------------------------------");

        procesador.procesarPedido(pedido2);
        System.out.println("--------------------------------");

        procesador.procesarPedido(pedido3);
        System.out.println("--------------------------------");

        procesador.procesarPedido(pedido4);
        System.out.println("--------------------------------");

        procesador.procesarPedido(pedido5);
    }
}