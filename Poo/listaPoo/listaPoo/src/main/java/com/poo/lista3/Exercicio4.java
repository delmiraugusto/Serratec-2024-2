package com.poo.lista3;

import java.util.Scanner;

public class Exercicio4 {

    public static void resolucao(){

        // 4) Jogo da adivinhação. Peça para alguém escolher um número. Depois peça
        // para outra pessoa tentar adivinhar. O programa deverá retornar dicas como:
        // "Muito baixo, muito alto ou quase lá" ou "tá quente, tá frio".

        Scanner sc = new Scanner(System.in);

        double divisao;

        System.out.print("Escolha um número: ");
        int escolhido = sc.nextInt();

        do{
            System.out.println("Tente adivinhar o número: ");
            int adivinha = sc.nextInt(); 
            divisao = (double) escolhido / adivinha;
            
            if(divisao == 1){
                System.out.println("VOCE ACERTOU!");
            }
            else if (divisao >= 1.3){
                System.out.println("Muito baixo");
            }
            else if (divisao <= 0.7){
                System.out.println("Muito alto");
            }
            else{
                System.out.println("Quase lá");
            }

        }while(divisao != 1);

        sc.close();    
    }
}
