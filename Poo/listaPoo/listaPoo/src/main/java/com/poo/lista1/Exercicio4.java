package com.poo.lista1;

import java.util.Scanner;

public class Exercicio4 {

    public static void resolucao(){
        
        // 4) Construa um algoritmo que leia um número inteiro na tela e
        // responda o número antecessor e o sucessor.
        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva um numero: ");
        int x = sc.nextInt();

        System.out.println("O antecessor é " + (x-1)+" e o sucessor é "+ (x+1));

        sc.close();
    }
    
}
