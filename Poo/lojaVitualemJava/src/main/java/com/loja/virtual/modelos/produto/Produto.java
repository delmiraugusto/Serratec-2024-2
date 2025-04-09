package com.loja.virtual.modelos.produto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Produto {
    public static int contadorProduto = 1;
    private int codProduto;
    private String nomeProduto;
    private String descricao;
    private int quantidadeEstoque;
    private String dataFabricacao;
    private double valorUnitario;
    public static List<Produto> produtos = new ArrayList<>();

    public Produto(){
        this.codProduto = contadorProduto;
        contadorProduto++;
    }

    public static void listarProdutos() {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.printf("%d - %s -> %.2f quantidade estoque - %d %n",
                    produtos.get(i).getCodProduto(),
                    produtos.get(i).getNomeProduto(),
                    produtos.get(i).getValorUnitario(),
                    produtos.get(i).getQuantidadeEstoque());
        }
    }
}
