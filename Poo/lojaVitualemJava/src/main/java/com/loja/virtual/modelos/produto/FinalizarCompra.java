package com.loja.virtual.modelos.produto;

import com.loja.virtual.modelos.pedido.Pedido;

import java.util.Objects;

import static com.loja.virtual.modelos.pedido.Pedido.carrinho;
import static com.loja.virtual.modelos.produto.Produto.produtos;

public class FinalizarCompra {
    public static void finalizarCompra() {
        double total = 0;
        if (carrinho.isEmpty()) {
            System.out.println("carrinho vazio! Compra não realizada");
        }else {
            Pedido.finalizarCompra();
            System.out.println("Compra finalizada com sucesso!");
        }
    }
}



