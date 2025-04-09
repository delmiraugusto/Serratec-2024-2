package com.poo.lista2;

import java.util.Scanner;

public class Exercicio3 {

    public static void resolucao(){

        // 3) Um banco contratou você para que escreva um programa que será utilizado
        // pelo usuário em um tablet. O programa irá fazer 3 perguntas e encaminhar o
        // cliente para 2 filas. A fila comum e a fila preferencial. Se o cliente atender a uma
        // das condições a seguir ele deve ser encaminhado para a fila preferencial. As
        // condições são: Ter mais de 65 anos, se deficiente ou gestante.

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Mais de 65 anos? (Sim ou Nao)");
        String idade = sc.nextLine();
        System.out.println("Deficiente? (Sim ou Nao)");
        String deficiente = sc.nextLine();
        System.out.println("Gestante? (Sim ou Nao)");
        String gestante = sc.nextLine();

        if ("Sim".equals(idade) || "Sim".equals(deficiente) || "Sim".equals(gestante)){
            System.out.println("Vá para a fila preferencial");
        }
        else{
            System.out.println("Vá para a fila comum");
        }

        sc.close();
    }
}
