package com.poo.lista4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio6 {

    public static void resolucao(){

        // 6) Aproveite a questão anterior e adiciona a opção do usuário remover
        // um item.
        Scanner sc = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int codigo;

        do{
            System.out.println("Inserir um item - 1, Ver a lista - 2, Remover item - 3, Finalizar Programa - 4");
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
                case 3:
                    System.out.print("Digite o nome do item para remover: ");
                    String itemRemover = sc.nextLine();
                    if (lista.remove(itemRemover)) {
                        System.out.println("Item removido com sucesso.");
                    } else {
                        System.out.println("Item não encontrado na lista.");
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
