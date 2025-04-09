package com.poo.lista4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercicio8 {

    public static void resolucao(){

        // 8) Aproveite os códigos anteriores e implemente a função de impressão
        // por ordem de preço (crescente)  

        Scanner sc = new Scanner(System.in);

        List<String> lista = new ArrayList<>();
        List<Double> valor = new ArrayList<>();

        int codigo;
        String item;
        double preco;
    

        do{
            System.out.println("Inserir um item e o Preco - 1, Ver a lista - 2, Remover item - 3, Finalizar Programa - 4, Imprimir por Preco - 5");

            codigo = sc.nextInt();
            sc.nextLine();

            switch (codigo) {
                case 1:
                    System.out.print("Digite o Item: ");
                    item = sc.nextLine();
                    System.out.print("Digite o Preço: ");
                    preco = sc.nextDouble();
                    valor.add(preco);
                    lista.add(item);
                    break;
                case 2:
                    if(lista.isEmpty()){
                        System.out.println("Lista está vazia");
                    }
                    else{
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i) + " - " + valor.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do item para remover: ");
                    String itemRemover = sc.nextLine();
                    System.out.print("Digite o preco do item para remover: ");
                    Double precoRemover = sc.nextDouble();

                    if (lista.remove(itemRemover) && valor.remove(precoRemover)) {
                        System.out.println("Item removido com sucesso.");
                    } else {
                        System.out.println("Item não encontrado na lista.");
                    }
                    break;
                case 4:
                    System.out.println("Programa Finalizado");
                    break;
                    case 5:
                    if (lista.isEmpty()) {
                        System.out.println("Lista está vazia");
                    } else {
                        List<Integer> indices = new ArrayList<>();
                        for (int i = 0; i < valor.size(); i++) {
                            indices.add(i);
                        }
                        indices.sort(new Comparator<Integer>() {
                            public int compare(Integer i1, Integer i2) {
                                return valor.get(i1).compareTo(valor.get(i2));
                            }
                        });
                        System.out.println("Lista ordenada por preço:");
                        for (Integer i : indices) {
                            System.out.println(lista.get(i) + " - " + valor.get(i));
                        }
                    }
                    break;
                
                default:
                    System.out.println("Numero Invalido!");
                    break;
            }

        }while (codigo != 4);


    }
}
