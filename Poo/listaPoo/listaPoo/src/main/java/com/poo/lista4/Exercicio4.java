package com.poo.lista4;

import java.util.Scanner;

public class Exercicio4 {

    public static void resolucao(){

        // 4) Escreva um código que irá percorrer uma lista de números inteiros
        // lista[ ] = { 3, 5, 6, 7, 8, 10, 22, 55, 110 } e irá contar a quantidade de
        // números pares presente nela.

        Scanner sc = new Scanner(System.in);

        int[] lista = {3, 5, 6, 7, 8, 10, 22, 55, 110};
        int par = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] % 2 == 0) {
                par++;
            }
        }

        System.out.println("Quantidade de Par = " + par);

        sc.close();
    }
}

