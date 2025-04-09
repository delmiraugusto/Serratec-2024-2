package com.poo.lista2;

import java.util.Scanner;

public class Exercicio5 {

    public static void resolucao(){

        // 5) Crie um algoritmo que receba login e senha e verifique as credenciais. Caso
        // algum deles estiver errado o programa deve retornar ao usuário quais das opções
        // está errada, se é o login ou a senha.

        Scanner sc = new Scanner(System.in); 

        String login_final = "Delmir";
        String senha_final = "12345";
        
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (login.equals(login_final) && senha.equals(senha_final)){
            System.out.println("CREDENCIAIS CORRETAS");
            
        }
        else if (!login.equals(login_final) && !senha.equals(senha_final)){
            System.out.print("LOGIN E SENHA INCORRETO");
        }
        else if (!senha.equals(senha_final)){
            System.out.println("SENHA INCORRETA");
        }
        else{
            System.out.println("LOGIN INCORRETO");
        }

        sc.close();
    }

}
