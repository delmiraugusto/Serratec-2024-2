package com.poo.lista1;

import java.util.Scanner;

public class Exercicio6 {

    public static void resolucao() {

        // 6) Construa um algoritmo que leia 1- a distância percorrida
        // por um veículo em km 2- o total gasto em combustível em
        // litros. No final deverá ser respondido o consumo médio deste
        // veículo em km/l.

        
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a distância percorrida pelo veículo em km: ");
        double distancia = sc.nextDouble();
        System.out.print("Digite o total gasto em combustível em litros: ");
        double combustivel = sc.nextDouble();

        double media = distancia/combustivel;

        System.out.println("O consumo médio deste veículo é de " + String.format("%.2f", media) + " km/l ");

        sc.close();        
    }

}
