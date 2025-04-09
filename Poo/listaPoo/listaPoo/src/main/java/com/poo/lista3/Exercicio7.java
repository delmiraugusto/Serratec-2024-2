package com.poo.lista3;

import java.util.Scanner;

public class Exercicio7 {

    public static void resolucao(){

        // 7) Aproveitando o exercício anterior, escreva um programa que consiga
        // construir um retângulo. O usuário deve informar a largura e a altura em
        // asteriscos

        Scanner sc = new Scanner(System.in);

        int largura;
        int altura;
        
        System.out.println("Altura: ");
        altura = sc.nextInt();

        System.out.println("Largura: ");
        largura = sc.nextInt();
        
        System.out.println();
        for (int j = 0; j < altura; j++) {
            for (int i = 0; i < largura; i++) {
                System.out.print("*");
            }  
            System.out.println();
        }
        
        sc.close();    
    }
}


