package com.loja.virtual.modelos.pedido;

import com.loja.virtual.modelos.cliente.Cliente;
import com.loja.virtual.modelos.produto.Produto;
import com.loja.virtual.modelos.produto.ProdutoPedido;
import java.time.LocalDate;
import static com.loja.virtual.modelos.pedido.Pedido.carrinho;
import static com.loja.virtual.modelos.produto.Produto.produtos;

public class PedidosInstance {
    public static void pedidosInstance() {

        Produto produto1 = new Produto();
        for (int i = 0; i < produtos.size(); i++) {
            produto1 = produtos.get(1);
        }
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rafael");
        Pedido pedido = new Pedido();
        ProdutoPedido pp = new ProdutoPedido();
        pedido.setCliente(cliente1);
        pedido.setDataPedido(LocalDate.now());
        pp.setProduto(produto1);
        pp.setQuantidade(1);
        pp.setPedido(pedido);
        carrinho.add(pp);
        Pedido.todosPedidos.add(pedido);
        Pedido.finalizarCompra();


        Produto produto3 = new Produto();
        for (int i = 0; i < produtos.size(); i++) {
            produto3 = produtos.get(2);
        }
        Cliente cliente3 = new Cliente();
        cliente3.setNome("Delmir");
        Pedido pedido3 = new Pedido();
        ProdutoPedido pp3 = new ProdutoPedido();
        pedido3.setCliente(cliente3);
        pedido3.setDataPedido(LocalDate.now());
        pp3.setProduto(produto3);
        pp3.setQuantidade(1);
        pp3.setPedido(pedido3);
        carrinho.add(pp3);
        Pedido.todosPedidos.add(pedido3);
        Pedido.finalizarCompra();




        Produto produto2 = new Produto();
        for (int i = 0; i < produtos.size(); i++) {

            produto2 = produtos.get(3);
        }
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Gabi");
        Pedido pedido2 = new Pedido();
        ProdutoPedido pp2 = new ProdutoPedido();
        pedido2.setCliente(cliente2);
        pedido2.setDataPedido(LocalDate.now());
        pp2.setProduto(produto2);
        pp2.setQuantidade(1);
        pp2.setPedido(pedido2);
        carrinho.add(pp2);
        Pedido.todosPedidos.add(pedido2);
        Pedido.finalizarCompra();
    }
}
