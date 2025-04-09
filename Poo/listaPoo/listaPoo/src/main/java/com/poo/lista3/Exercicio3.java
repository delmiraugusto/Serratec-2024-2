package com.poo.lista3;

import java.util.Scanner;

public class Exercicio3 {

    public static void resolucao(){

        // 3) Escreva um código que receba dois números inteiros e escreva todos os
        // números pares entre eles.

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num1 = sc.nextInt();
        System.out.println("Digite um número: ");
        int num2 = sc.nextInt();

       if (num1 > num2){
           for(int i = num2+1; i < num1; i++){
               if(i % 2 == 0){
                   System.out.print(i + ", ");
               }
           }
       }
        else{
           for(int i = num1+1; i < num2; i++){
               if(i % 2 == 0){
                   System.out.print(i + ", ");
               }
           }
       }

        sc.close();
    }
}
