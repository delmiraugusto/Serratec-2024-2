package com.loja.virtual.modelos.cliente;

import java.util.Scanner;

public class CadastrarCliente {
    public static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        Cliente cli = new Cliente();
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        cli.setLogin(nome);
        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Crie uma senha: ");
        String senha = scanner.nextLine();
        cli.setSenha(senha);

        System.out.println("Cliente Cadastrado");


    }
}
