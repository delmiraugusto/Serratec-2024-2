package com.poo.lista1;

import java.util.Scanner;

public class Exercicio2 {

    public static void resolucao(){

        // 2) Escreva um programa que pergunte o nome e o
        // sobrenome do usuário e escreva na tela: "Olá, -usuário-".


        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva seu nome: ");
        String n1 = sc.nextLine();

        System.out.print("Escreva seu sobrenome: ");
        String n2 = sc.nextLine();

        System.out.println("Olá, "+ n1  + " "+ n2);

        sc.close();

    }   
}