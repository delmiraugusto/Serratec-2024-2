package com.poo.lista3;

import java.util.Scanner;

public class Exercicio2 {

    public static void resolucao(){

        // 2) Desenvolva um programa que receba um número do usuário e escreva a
        // tabuada dele.

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = sc.nextInt(); 
 
         for (int i = 1; i <= 10; i++){
             System.out.println(i + " x " + num + " = " + (i*num)); 
         }
             
             
         sc.close();    
    }
 }