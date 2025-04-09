package com.loja.virtual.modelos.gestor;


import com.loja.virtual.modelos.produto.ProdutoPedido;
import static com.loja.virtual.modelos.pedido.Pedido.*;

public class TotalPedidos {
    public static void totalPedidos(String user) {
        int contador = 0;
        double total = 0.0;
        double totalTotal = 0.0;
        for (ProdutoPedido produtoPedidoC : pedidosFinalizados) {
            contador++;
            System.out.printf("""
                    Nome : %s
                    Data do Pedido: %s
                    """,produtoPedidoC.getPedido().getCliente().getNome(),
                    produtoPedidoC.getPedido().getDataPedido()
            );
            for (ProdutoPedido produtoPedidoP : pedidosFinalizados){

                System.out.printf("""
                        %s - %s -> %.2f
                        
                        """,
                        produtoPedidoP.getProduto().getCodProduto(),
                        produtoPedidoP.getProduto().getNomeProduto(),
                        produtoPedidoP.getProduto().getValorUnitario());
                totalTotal += produtoPedidoP.getProduto().getValorUnitario();
            }
            total += produtoPedidoC.getProduto().getValorUnitario();
            System.out.println("Total: " + total + "\n");
        }
        System.out.println("Total de pedidos: " + contador);
        System.out.println("Total de vendas: " +String.format("%.2f", totalTotal));
    }
}
