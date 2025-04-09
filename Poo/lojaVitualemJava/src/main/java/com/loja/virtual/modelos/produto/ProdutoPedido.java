package com.loja.virtual.modelos.produto;

import com.loja.virtual.modelos.pedido.Pedido;
import lombok.*;
import java.util.Random;

@Data
public class ProdutoPedido {
    private long cod;
    private int quantidade;
    private Produto produto;
    private Pedido pedido;

    long numeroAleatorio = new Random().nextLong(1000000000);
    public void setCodPedido() {
        this.cod = numeroAleatorio;
    }
    
}
