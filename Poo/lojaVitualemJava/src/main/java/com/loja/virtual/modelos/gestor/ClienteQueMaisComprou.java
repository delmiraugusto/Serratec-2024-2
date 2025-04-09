package com.loja.virtual.modelos.gestor;

import java.util.HashMap;
import java.util.Map;
import com.loja.virtual.modelos.pedido.Pedido;
import com.loja.virtual.modelos.produto.ProdutoPedido;
import static com.loja.virtual.modelos.pedido.Pedido.pedidosFinalizados;
import static com.loja.virtual.modelos.pedido.Pedido.todosPedidos;

public class ClienteQueMaisComprou {
    public static void clienteQueMaisComprou() {
        Map<String, Integer> contadorClientes = new HashMap<>();

        for (ProdutoPedido produtoPedido : pedidosFinalizados) {
            String nomeCliente = produtoPedido.getPedido().getCliente().getNome();
            contadorClientes.put(nomeCliente, contadorClientes.getOrDefault(nomeCliente, 0) + 1);
        }

        String clienteMaisComprou = null;
        int maxCompras = 0;

        for (Map.Entry<String, Integer> entry : contadorClientes.entrySet()) {
            if (entry.getValue() > maxCompras) {
                maxCompras = entry.getValue();
                clienteMaisComprou = entry.getKey();
            }
        }

        System.out.println("Cliente que mais comprou: " + clienteMaisComprou);
        System.out.println("Número de compras: " + maxCompras);
    }
}