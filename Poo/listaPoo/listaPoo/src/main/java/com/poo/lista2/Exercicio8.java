package com.poo.lista2;

import java.util.Scanner;

public class Exercicio8 {

      public static void resolucao(){

        // 8) Crie um joguinho de perguntas e respostas múltipla escolha. O programa
        // deverá fazer 5 perguntas (Uma por vez). Se ele errar 3 vezes ele perde o jogo. Se
        // o usuário chegar até o final o programa deve exibir o número de acertos.

        Scanner sc = new Scanner(System.in);

        int cont = 0;

        System.out.println("Qual o time Campeão da última libertadores? ");
        System.out.println("1- Boca Juniors");
        System.out.println("2- Fluminense");
        System.out.println("3- Internacional");
        System.out.println("4- Racing");
        int liberta = sc.nextInt();
        System.out.println();

        if(liberta != 2){
            cont++;
        }


        // teste
        
        System.out.println("Qual maior jogador da história do futebol? ");
        System.out.println("1- Maradona");
        System.out.println("2- Pelé");
        System.out.println("3- C.Ronaldo");
        System.out.println("4- Messi");
        int jogador = sc.nextInt();
        System.out.println();

        if(jogador != 3){
            cont++;
        }

        System.out.println("Qual o país com mais Copas do Mundo? ");
        System.out.println("1- Alemanha");
        System.out.println("2- Itália");
        System.out.println("3- Brasil");
        System.out.println("4- Argentina");
        int pais = sc.nextInt();
        System.out.println();

        if(pais != 3){
            cont++;
        }


        if(cont == 3){
            System.out.println("VOCE PERDEU :(");
        }
        else{
            System.out.println("Qual o time mais vezes campeão do Brasileirão? ");
            System.out.println("1- Palmeiras");
            System.out.println("2- Fluminense");
            System.out.println("3- Flamengo");
            System.out.println("4- São Paulo");
            int time = sc.nextInt();
            System.out.println();

            if(time != 1){
                cont++;
            }
    
        }

        if(cont == 3){
            System.out.println("VOCE PERDEU :(");
        }
        else{       
            System.out.println("Qual o maior artilheiro do Brasileirão na era dos pontos corridos? ");
            System.out.println("1- Diego Souza");
            System.out.println("2- Paulo Baier");
            System.out.println("3- Borges");
            System.out.println("4- Fred");

            int artilheiro = sc.nextInt();
            System.out.println();

            if(artilheiro != 4){
                cont++;
            }

            if (cont == 3){
                System.out.println("VOCE PERDEU :(");
            }
            else{
                int acerto = 5 - cont;
                System.out.println("ACERTOS = " + acerto);
            }
        }

        sc.close();
    
    }

}
