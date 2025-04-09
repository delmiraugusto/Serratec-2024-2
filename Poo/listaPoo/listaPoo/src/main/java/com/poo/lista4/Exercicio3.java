package com.poo.lista4;

import java.util.Scanner;

public class Exercicio3 {

    public static void resolucao(){

        // 3) Ainda utilizando o exercício do mercado, calcule o ticket médio de
        // vendas do dia

        Scanner sc = new Scanner(System.in);

        double[] vendasDia = {60.5, 52, 63, 207, 83.3, 100.99, 22.98, 55, 110};
        double total = 0, menor = 1000000, maior = 0, media;

        System.out.print("Digite 1 para realizar o fechamento das vendas do dia: ");
        int codigo = sc.nextInt();

        while(codigo != 1){
            System.out.print("Número Inválido! Digite novamente: ");
            codigo = sc.nextInt();
        }

        for (int i = 0; i < vendasDia.length; i++) {
            total += vendasDia[i];
        }
        
        for (int i = 0; i < vendasDia.length; i++) {
          if (menor > vendasDia[i]){
            menor = vendasDia[i];
          } 
          if (maior < vendasDia[i]){
            maior = vendasDia[i];
          }
        }

        media = total / vendasDia.length;

        System.out.println("Fechamento = " + String.format("%.2f", total));
        System.out.println("Compra de Menor Valor = " + menor);
        System.out.println("Compra de maior Valor = " + maior);
        System.out.println("Ticket médio de vendas do dia = " + String.format("%.2f", media));

        sc.close();
    }
}
