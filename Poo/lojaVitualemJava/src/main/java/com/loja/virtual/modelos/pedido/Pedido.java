package com.loja.virtual.modelos.pedido;

import com.loja.virtual.modelos.cliente.Cliente;
import com.loja.virtual.modelos.produto.ProdutoPedido;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Data
public class Pedido {
    private Cliente cliente;
    private long codPedido;
    private LocalDate dataPedido;
    
    public static List<ProdutoPedido> carrinho = new ArrayList<>();

    public static List<Pedido> todosPedidos = new ArrayList<>();
    public static List<ProdutoPedido> pedidosFinalizados = new ArrayList<>();

    public void setCodPedido() {
        this.codPedido = new Random().nextLong(1000000000);
    }
    public static void finalizarCompra() {
        pedidosFinalizados.addAll(carrinho);
        
        carrinho.clear();
    }
}
