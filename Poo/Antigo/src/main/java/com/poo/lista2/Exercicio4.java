package com.poo.lista2;

import java.util.Scanner;

public class Exercicio4 {

    public static void resolucao(){
        // 4) Um cliente que promove eventos e solicitou um programa que seja capaz de
        // identificar se uma pessoa é maior de idade. Pessoas com menos de 16 anos não
        // podem entrar nos eventos. Entre 16 e 18 anos somente acompanhado pelos
        // responsáveis. Maiores de 18 podem entrar normalmente.

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int x = sc.nextInt();

        if(x < 16){
            System.out.println("NAO PODE ENTRAR");
        }
        else if (x >= 16 && x < 18){
            System.out.println("SOMENTE ACOMPANHADO PELOS RESPOSÁVEIS");
        }
        else{
            System.out.println("ENTRADA LIBERADA");
        }

        sc.close();
    }

}
