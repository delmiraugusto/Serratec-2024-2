package com.poo.lista2;

import java.util.Scanner;

public class Exercicio6 {

    public static void resolucao(){

    /*  6) Crie um programa que receba as notas de um aluno e informe se ele foi
        aprovado ou reprovado. Se o aluno ficar com média acima de 6 nas 2 primeiras
        provas ele passou. Senão o programa deverá perguntar a nota de recuperação
        que irá substituir a menor nota. A pergunta de recuperação deverá aparecer
        somente para os alunos que precisarem.*/

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite as duas notas do aluno:");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();

        double media = (n1 + n2)/ 2;

        if(media > 6){
            System.out.println("ALUNO APROVADO!!!");
        }
        else{
            System.out.println("ALUNO EM RECUPERAÇÃO");
            System.out.println("Digite a nota da recuperação:");
            double recuperação = sc.nextDouble();

                if (n1 < n2) {
                    media = (n2 + recuperação)/2;
                    System.out.println("Media final = " + String.format("%.2f", media));            
                }
                else{
                    media = (n1 + recuperação)/2;
                    System.out.println("Media final = " + String.format("%.2f", media)); 
                }
        }

        sc.close();
    }
}
