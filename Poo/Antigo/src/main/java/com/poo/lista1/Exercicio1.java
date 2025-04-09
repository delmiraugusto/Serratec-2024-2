package com.poo.lista1;

import java.util.Scanner;

public class Exercicio1 {

    public static void resolucao(){
		
		// 1) Escreva um programa que faça a soma entre 2 números.
		 
        Scanner sc = new Scanner(System.in);
		System.out.println("Digite 2 numeros: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int soma = x + y;

		System.out.println("A soma é: "+ soma);
		
    	sc.close();
	}
}