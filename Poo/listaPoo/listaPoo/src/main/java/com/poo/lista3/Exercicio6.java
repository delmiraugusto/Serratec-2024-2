package com.poo.lista3;

import java.util.Scanner;

public class Exercicio6 {

    public static void resolucao(){

        // 6) Escreva um programa que seja capaz de desenhar uma pirâmide de
        // asteriscos. O usuário deverá informar quantos andares ele deseja que a
        // pirâmide tenha.

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos andares a pirâmide terá? ");
        int andar = sc.nextInt();

        for (int i = 1; i <= andar; i++){
            for (int j = 1; j <= andar-i ; j++){
                System.out.print(" ");
            }
            
            for (int k = 1; k <= 2*i-1; k++) {
                    System.out.print("*"); 
            }
            
            System.out.println("");
        }

        sc.close();    
    }
}
