package com.loja.virtual.modelos.cliente;

import java.util.Objects;
import static com.loja.virtual.modelos.pedido.Pedido.pedidosFinalizados;
import com.loja.virtual.modelos.produto.ProdutoPedido;

public class ConsultaPedidos {
    public static void consultarPedidos(String user) {

        double total = 0;
        boolean hasPedido = false;

        System.out.println("Listando todos os pedidos:");
        for (ProdutoPedido produtoPedidoC : pedidosFinalizados) {
            if (Objects.equals(user, produtoPedidoC.getPedido().getCliente().getLogin())) {
                if (!hasPedido) {
                    hasPedido = true;

                    System.out.printf("""
                                    Nome : %s
                                    Data do Pedido: %s
                                    """,
                            produtoPedidoC.getPedido().getCliente().getNome(),
                            produtoPedidoC.getPedido().getDataPedido()
                    );
                }
                System.out.printf("""
                                %s - %s -> %.2f
                                """,
                        produtoPedidoC.getProduto().getCodProduto(),
                        produtoPedidoC.getProduto().getNomeProduto(),
                        produtoPedidoC.getProduto().getValorUnitario());

                total += produtoPedidoC.getProduto().getValorUnitario();
            }
        }
        if (hasPedido) {
            System.out.println("Total: " + total);
        } else {
            System.out.println("Nenhum Pedido encontrado para o cliente.");
        }
    }
}
