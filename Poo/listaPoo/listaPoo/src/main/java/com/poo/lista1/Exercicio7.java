package com.poo.lista1;

import java.util.Scanner;

public class Exercicio7 {
    public static void resolucao(){

        // 7) Escreva um programa que receba quatro notas de um
        // aluno e calcule a média aritmética dessas notas.

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite as 4 notas do aluno: ");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();
        double n4 = sc.nextDouble();

        double nota = (n1 + n2 + n3 + n4) / 4;

        System.out.println("Média = " + String.format("%.2f", nota));

        sc.close();
    }

}
