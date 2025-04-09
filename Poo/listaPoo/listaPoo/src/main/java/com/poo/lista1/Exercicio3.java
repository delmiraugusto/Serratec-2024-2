package com.poo.lista1;

import java.util.Scanner;

public class Exercicio3 {

    public static void resolucao(){

        // 3) Escreva uma calculadora que receba um valor em reais e
        // converta para dólar. Considere o valor do dólar a R$5,25.

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor em reais: ");
        double reais = sc.nextDouble();


        double dolar = reais / 5.25;

        System.out.println("O valor em dolar é $" + String.format("%.2f", dolar));
        
        sc.close();
    }
}
