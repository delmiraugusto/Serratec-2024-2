package com.poo.lista2;

import java.util.Scanner;

public class Exercicio2 {

    public static void resolucao(){

        // 2) Desenvolva um algoritmo que seja capaz de receber dois números digitados
        // pelo usuário e diga qual deles é maior.

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite 2 números:");
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        if(x > y){
            System.out.println(x + " é o maior");
        }
        else{
            System.out.println(y + " é o maior"); 
        }

        sc.close();
    }
}
