package com.poo.lista1;

import java.util.Scanner;

public class Exercicio5 {
    public static void resolucao() {

        // 5) Construa um algoritmo que calcule o valor de um terreno
        // baseado na sua área e valor por m2.
    
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o comprimento do terreno: ");
        double comprimento =sc.nextInt();
        System.out.print("Digite a largura do terreno: ");
        double largura =sc.nextInt();

        System.out.print("Digite o valor do m²: ");
        double valor = sc.nextInt();

        double area = comprimento * largura;
        double total = area * valor;

        System.out.println("O valor do terrono é de R$" + String.format("%.2f", total));

        sc.close();
        
    }
}
