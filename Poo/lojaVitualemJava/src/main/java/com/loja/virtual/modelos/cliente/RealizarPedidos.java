package com.loja.virtual.modelos.cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.loja.virtual.modelos.produto.PegarProduto.pegarProduto;
import com.loja.virtual.modelos.produto.Produto;

public class RealizarPedidos {
    public static void realizarPedidos(String user) {
        Scanner scRP = new Scanner(System.in);
            int opt = 0;
            double total = 0;
                System.out.printf("""
            ====================================
            |          SERRATEC GAMES          |
            ====================================
            | USUÁRIO: %s                      
            | %n                               
            """, user);
                Produto.listarProdutos();
                System.out.println("""
                    
                            *INSERIR JOGO*
                    Escolha o jogo:
                    Digite o número referente ao jogo.
                    """);
            try{
            opt = scRP.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                realizarPedidos(user);
                scRP.next();
            }
            pegarProduto(user,opt, total);
    }
}