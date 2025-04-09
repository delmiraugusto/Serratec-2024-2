package com.poo.lista2;

import java.util.Scanner;

public class Exercicio7 {

       public static void resolucao(){

        // 7) Escreva um programa Identificador de Divisibilidade, isto é, que identifique se
        // um determinado número informado pelo usuário é divisível por X (Que também
        // deve ser informado pelo usuário)

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o numero a ser dividido: ");
        int dividido = sc.nextInt();
        System.out.print("Digite o divisor: ");
        int x = sc.nextInt();

        if (dividido % x == 0){
            System.out.println("É divisível");
        } 
        else{
            System.out.println("Não é divisível");
        } 

        sc.close();
    
    }
}
