package com.poo.lista1;

import java.util.Scanner;

public class Exercicio8 {
    public static void resolucao(){

        // 8) Suponha que voce trabalhe em um laboratório e seu
        // colega mediu a temperatura de um objeto em Fahrenheit.
        // Escreva um programa capaz de converter em Celsius.

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Temperatura em Fahrenheit: ");
        double Fahrenheit = sc.nextDouble();

        double Celsius = (Fahrenheit - 32) * 5/9;

        System.out.println("A temperatura em Celsius é " + String.format("%.2f", Celsius) + "° graus");
        
        sc.close();
    }

}
