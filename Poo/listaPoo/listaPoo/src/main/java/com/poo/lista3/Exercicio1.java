package com.poo.lista3;

import java.util.Scanner;

public class Exercicio1 {

    public static void resolucao(){

        //1) Escreva um programa que sirva como um cronômetro. O usuário deve
        // digitar um numero em segundos e o programa deve contabilizar os segundos
        // digitados. O programa deve receber somente números entre 1 e 59, do
        // contrário ele retornar um erro e solicitar que o usuário digite um número válido.

        Scanner sc = new Scanner(System.in);
        int tempo;

        do {
            System.out.print("Digite o tempo em segundos (entre 1 e 59): ");
            tempo = sc.nextInt();

            if (tempo < 1 || tempo > 59) {
                System.out.println("Número inválido!");
            }

        } while (tempo < 1 || tempo > 59);

        int segundos = tempo * 1000; // Converter segundos para milissegundos

        try {
            Thread.sleep(segundos); // Pausa a execução por 'segundos' milissegundos
        } catch (InterruptedException e) {
            System.out.println("A execução foi interrompida!");
        }

        System.out.println("Tempo esgotado!");

        sc.close();
    }
}
