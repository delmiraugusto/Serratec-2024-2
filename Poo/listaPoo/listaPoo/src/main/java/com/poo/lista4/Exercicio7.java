package com.poo.lista4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio7 {

    public static void resolucao(){

        // 7) Aproveite o código que estamos utilizando e implemente um preço
        // para cada item (Dica. Utilizem outra lista e use os mesmos índices para
        // o item e para o preço).

        Scanner sc = new Scanner(System.in);

        List<String> lista = new ArrayList<>();
        List<Double> valor = new ArrayList<>();

        int codigo;
        String item;
        double preco;
    

        do{
            System.out.println("Inserir um item e o Preco - 1, Ver a lista - 2, Remover item - 3, Finalizar Programa - 4");
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
                default:
                    System.out.println("Numero Invalido!");
                    break;
            }

        }while (codigo != 4);


    }
}
