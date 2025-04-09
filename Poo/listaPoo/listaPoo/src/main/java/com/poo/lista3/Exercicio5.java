package com.poo.lista3;

import java.util.Scanner;

public class Exercicio5 {

    public static void resolucao(){

        // 5) Crie um algoritmo que receba login e senha e verifique as credenciais. Caso
        // algum deles estiver errado o programa deve retornar ao usuário quais das
        // opções está errada, se é o login ou a senha. O programa deve bloquear o
        // acesso após 3 tentativas erradas. Quando for a última tentativa ele deve emitir
        // um alerta: "Última tentativa, mais um erro seu acesso será bloqueado!"

        Scanner sc = new Scanner(System.in); 
        int contador = 0;

        String login_final = "Delmir";
        String senha_final = "12345";

    do{
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (login.equals(login_final) && senha.equals(senha_final)){
            System.out.println("CREDENCIAIS CORRETAS");
            contador = 3;
        }
        else{
            contador++;
            if (!login.equals(login_final) && !senha.equals(senha_final)){
                System.out.print("LOGIN E SENHA INCORRETO");
            }
            else if (!senha.equals(senha_final)){
                System.out.println("SENHA INCORRETA");
            }
            else{
                System.out.println("LOGIN INCORRETO");
            }
        }
       
        if(contador == 2){
            System.out.println("Última tentativa, mais um erro seu acesso será bloqueado!");
        }

    }while(contador < 3);

        sc.close();
    }

}
