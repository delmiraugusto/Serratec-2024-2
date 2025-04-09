package com.poo.lista4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio5 {

    public static void resolucao(){

        // 5) Escreva um programa que sirva como uma lista de compras de
        // mercado. Você irá criar um menu que pergunte se o usuário quer inserir
        // um item ou ver a lista.

        Scanner sc = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int codigo;

        do{
            System.out.println("Inserir um item - 1, Ver a lista - 2, Finalizar Programa - 4");
            codigo = sc.nextInt();
            sc.nextLine();

            switch (codigo) {
                case 1:
                    System.out.print("Digite o item: ");
                    String item = sc.nextLine();
                    lista.add(item);
                    break;
                case 2:
                    if(lista.isEmpty()){
                    System.out.println("Lista está vazia");
                    }
                    else{
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }
                    } 
                    break;
                case 4:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    System.out.println("Numero Invalido!");
                    break;
            }

        }while (codigo != 4);


    }
}

