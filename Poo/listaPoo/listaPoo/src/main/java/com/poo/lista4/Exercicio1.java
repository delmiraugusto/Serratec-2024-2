package com.poo.lista4;

import java.util.Scanner;

public class Exercicio1 {

    public static void resolucao(){

        // 1) Voce é gerente de um supermercado e sabe que os valores das
        // vendas do dia são gravados em um vetor. Digite um código que faça o
        // fechamento (soma) de vendas do dia de maneira automatizada.

        Scanner sc = new Scanner(System.in);

        double[] vendasDia = {60.5, 52, 63, 207, 83.3, 100.99, 22.98, 55, 110};
        double total = 0;

        System.out.print("Digite 1 para realizar o fechamento das vendas do dia: ");
        int codigo = sc.nextInt();

        while(codigo != 1){
            System.out.print("Número Inválido! Digite novamente: ");
            codigo = sc.nextInt();
        }

        for (int i = 0; i < vendasDia.length; i++) {
            total += vendasDia[i];
        }

        System.out.println("Fechamento = " + String.format("%.2f", total));

        sc.close();
    }
}
