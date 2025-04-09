package com.loja.virtual.modelos.menu;

import com.loja.virtual.modelos.pedido.Pedido;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.loja.virtual.modelos.gestor.CadastrarProdutos.cadastrarProdutos;
import static com.loja.virtual.modelos.gestor.ClienteQueMaisComprou.clienteQueMaisComprou;
import static com.loja.virtual.modelos.gestor.TotalPedidos.totalPedidos;
import static com.loja.virtual.modelos.menu.LoginVerification.loginVerification;
import static com.loja.virtual.modelos.produto.Produto.listarProdutos;

public class MenuGestor {
    public static void menuGestor(String user) {
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        do {
            try {
                System.out.printf("""
                    
        =========================================
        |          MENU ADMINISTRATIVO          |
        =========================================
                    Gestor: %s
        | 1 - Cadastrar Produto                 |            
        | 2 - Cliente Que Mais Comprou          |
        | 3 - Total de Pedidos                  |
        | 4 - Listar Produtos                   |
        | 0 - Voltar                            |
        =========================================
        Escolha uma opção:
        %n""",user);
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> cadastrarProdutos();
                case 2 -> clienteQueMaisComprou();
                case 3 -> totalPedidos(user);
                case 4 -> listarProdutos();
                case 0 -> loginVerification();
                default -> System.out.println("Número inválido! Digite uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");

                sc.next();
            }
        } while (opcao != 0);
    }
}