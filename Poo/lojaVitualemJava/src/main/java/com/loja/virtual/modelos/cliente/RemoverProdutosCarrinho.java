package com.loja.virtual.modelos.cliente;

import com.loja.virtual.modelos.produto.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoverProdutosCarrinho {
    public static void removerProdutoCarrinho(String user) {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        System.out.printf("""
            ====================================
            |          SERRATEC GAMES          |
            ====================================
            | USUÁRIO: %s                      |
            | %n                               
            """, user);                    
        Produto.listarProdutos();
        System.out.println("""

            |            *REMOVER JOGO*
            Escolha o código do jogo que deseja remover:
            Digite o número referente ao código do jogo:
                """);
        try {
            opt = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
            removerProdutoCarrinho(user);
            scanner.next();
        }
        
        removerProduto(opt);
    }
    
    private static void removerProduto(int codProduto) {
        Produto produtoRemover = null;
        
        for (Produto produto : Produto.produtos) {
            if (produto.getCodProduto() == codProduto) {
                produtoRemover = produto;
                break;
            }
        }
        
        if (produtoRemover != null) {
            Produto.produtos.remove(produtoRemover);
            System.out.println("Produto removido: " + produtoRemover.getNomeProduto());
        } else {
            System.out.println("Produto não encontrado com o código fornecido.");
        }
    }
}
