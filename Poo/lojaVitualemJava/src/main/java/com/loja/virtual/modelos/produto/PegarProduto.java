package com.loja.virtual.modelos.produto;

import com.loja.virtual.modelos.cliente.Cliente;
import com.loja.virtual.modelos.pedido.Pedido;
import java.time.LocalDate;
import java.util.Objects;
import static com.loja.virtual.modelos.cliente.Cliente.clientes;
import static com.loja.virtual.modelos.pedido.Pedido.carrinho;
import static com.loja.virtual.modelos.produto.Produto.produtos;

public class PegarProduto {
    public static void pegarProduto(String user, int opt, double total) {
        Pedido pedido = new Pedido();
        ProdutoPedido pp = new ProdutoPedido();
        for (Produto produto : produtos) {
            if (produto.getCodProduto() == opt) {
                for (Cliente c : clientes) {
                    if (Objects.equals(c.getLogin(), user)) {
                        pedido.setCliente(c);
                        pedido.setDataPedido(LocalDate.now());
                        pp.setProduto(produto);
                        pp.setQuantidade(1);
                        pp.setPedido(pedido);
                        carrinho.add(pp);
                        System.out.println("Carrinho:");
                    }
                }
            }
        }
        for (ProdutoPedido produtoPedido : carrinho) {
            System.out.printf("""
                            %d - %s -> %.2f quant.: %d
                            """,
                    produtoPedido
                            .getProduto()
                            .getCodProduto()
                    ,
                    produtoPedido
                            .getProduto()
                            .getNomeProduto()
                    ,
                    produtoPedido.
                            getProduto().
                            getValorUnitario()
                    ,
                    produtoPedido
                            .getQuantidade()
            );
            total += produtoPedido.
                    getProduto().
                    getValorUnitario();
        }
        System.out.println("\nTotal: \n"+total);
    }
}
