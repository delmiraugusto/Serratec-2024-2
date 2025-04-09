package com.escola.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu{

   public static List<Aluno> listaAluno  = new ArrayList<>();
   public static List<Professor> listaProfessor  = new ArrayList<>();
   static Scanner sc = new Scanner(System.in);


    public static void menu(){
    int opcao;

        do{
            System.out.println("\n----- MENU -----");
            System.out.println("1- MENU ALUNO");
            System.out.println("2- MENU PROFESSOR");
            System.out.println("0- SAIR\n");
            System.out.print("Digite uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Menu.menuAluno();
                    break;
                case 2:
                    Menu.menuProfessor();
                    break;
                case 0:
                    System.out.println("Programa Finalizado\n");
                    break;
                default:
                System.out.println("Número Inválido\n");
                    break;
            }
        }while(opcao != 0);
    }

    public static void menuAluno(){

        int opcao;
    
        do {
                System.out.println("\n----- MENU ALUNO-----");
                System.out.println("O que deseja fazer?");
                System.out.println("1- Cadastrar novo aluno");
                System.out.println("2- Atualizar aluno");
                System.out.println("3- Deletar aluno");
                System.out.println("4- Listar alunos");
                System.out.println("5- Ver boletim");
                System.out.println("0- Sair\n");
                System.out.print("Digite uma opção: ");
                opcao = sc.nextInt();
    
                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        atualizarAluno();
                        break;
                    case 3:
                        removerAluno();
                        break;
                    case 4:
                        listarAlunos();
                        break;
                    case 5:
                        verBoletim();
                        break;    
                    case 0:
                        System.out.println("Programa Finalizado\n");
                        break;
                    default:
                        System.out.println("Número Inválido\n");
                        break;
                }
            }while(opcao != 0);
        }
    
        public static void cadastrarAluno(){
            System.out.println("	Cadastre o Novo Aluno	");
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            listaAluno.add(aluno);
            System.out.println("ALUNO CADASTRADO");
        }
    
        public static void atualizarAluno(){
            if(listaAluno.isEmpty()){
                System.out.println("A lista está vazia");
            }else{
                System.out.print("Nome do Aluno que deseja atualizar: ");
                sc.nextLine();
                String nomeAtualizar = sc.nextLine();
                int contador = 0;
                for (Aluno aluno : listaAluno) {
                    if(aluno.getNome().equals(nomeAtualizar)){
                        System.out.print("Qual o novo nome do Aluno: ");
                        String nome = sc.nextLine();
                        aluno.setNome(nome);
                        System.out.println("Aluno modificado com sucesso");
                        contador = 0;
                    }else{
                        contador++;
                    }
                }
                if(contador == listaAluno.size()){
                    System.out.println("Aluno nao encontrado");
                }
            }      
        }
    
        public static void removerAluno(){
            if(listaAluno.isEmpty()){
                System.out.println("Não há aluno para remover");
            }else{
                System.out.print("Nome do Aluno que deseja remover: ");
                sc.nextLine();
                String remover = sc.nextLine();
                int contador = 0;
                for (int i = 0; i < listaAluno.size(); i++) {
                    if (listaAluno.get(i).getNome().equals(remover)) {
                        listaAluno.remove(i);
                        System.out.println("Aluno removido com sucesso");
                        contador = -10;
                    }else{
                        contador++;
                    }
                }
                if(contador == listaAluno.size()){
                    System.out.println("Aluno nao encontrado");
                }
            }
        }
    
        public static void listarAlunos(){
            if(listaAluno.isEmpty()){
                System.out.println("  A Lista está Vazia   ");
            }else{
                System.out.println("   Lista dos Alunos   ");
                for (int i = 0; i < listaAluno.size(); i++) {
                    Aluno aluno = listaAluno.get(i);
                    System.out.println((i + 1) + "- " + aluno.getNome()+ " "+ aluno.getMatricula());
                }
            }
        }

        public static void verBoletim(){
            if(listaAluno.isEmpty()){
                System.out.println("  A Lista está Vazia   ");
            }else{
                sc.nextLine();
                    System.out.println("Digite o seu nome para visualizar o boletim");
                    String alunoNome = sc.nextLine();
                    double mediaNota;
                    for (Aluno aluno : listaAluno) {
                        if(aluno.getNome().equals(alunoNome)){
                            mediaNota = (aluno.getNota1() + aluno.getNota2()) / 2;
                            System.out.println("\n--- Boletim ---");
                            System.out.println("Nome: " + aluno.getNome());
                            System.out.println("Matrícula: " + aluno.getMatricula());
                            System.out.println("Nota 1: " + aluno.getNota1());
                            System.out.println("Nota 2: " + aluno.getNota2());
                            System.out.println("Média: " + mediaNota);
                        }else{
                            System.out.println("Nome não encontrado");
                    }
                }

            }


        }

        public static void menuProfessor(){
            int opcao;
        
            do {
        
                    System.out.println("\n----- MENU PROFESSOR-----");
                    System.out.println("O que deseja fazer?");
                    System.out.println("1- Cadastrar novo Professor");
                    System.out.println("2- Atualizar Professor");
                    System.out.println("3- Deletar Professor");
                    System.out.println("4- Listar Professor");
                    System.out.println("5- Lançar Notas");
                    System.out.println("6- Mostrar Boletim do Aluno");
                    System.out.println("0- Sair\n");
                    System.out.print("Digite uma opção: ");
                    opcao = sc.nextInt();
        
                    switch (opcao) {
                        case 1:
                            cadastrarProfessor();
                            break;
                        case 2:
                            atualizarProfessor();
                            break;
                        case 3:
                            removerProfessor();
                            break;
                        case 4:
                            listarProfessores();
                            break;
                        case 5 : 
                            lancarNota();
                            break;
                        case 6 : 
                            mostrarboletim();
                            break;
                        case 0:
                            System.out.println("Programa Finalizado\n");
                            break;
                        default:
                            System.out.println("Número Inválido\n");
                            break;
                    }
                }while(opcao != 0);
            }
        
            public static void cadastrarProfessor(){
                System.out.println("	Cadastre o Novo Professor	");
                System.out.print("Nome: ");
                sc.nextLine();
                String nome = sc.nextLine();
                Professor professor = new Professor();
                professor.setNome(nome);
                listaProfessor.add(professor);
                System.out.println("PROFESSOR CADASTRADO");
            }
        
            public static void atualizarProfessor(){
                if(listaProfessor.isEmpty()){
                    System.out.println("A lista está vazia");
                }else{
                    System.out.println("	Atualizar o Professor   ");
                    System.out.print("Nome do Professor que deseja atualizar: ");
                    sc.nextLine();
                    String nomeAtualizar = sc.nextLine();
                    int contador = 0;
                    for (Professor professor : listaProfessor) {
                        if(professor.getNome().equals(nomeAtualizar)){
                            System.out.print("Qual o novo nome do Professor: ");
                            String nome = sc.nextLine();
                            professor.setNome(nome);
                            System.out.println("Professor modificado com sucesso");
                            contador = -10;
                        }else{
                            contador++;
                        }
                    }
                    if(contador == listaProfessor.size()){
                        System.out.println("Professor nao encontrado");
                    } 
                }     
            }
        
            public static void removerProfessor(){
                if(listaProfessor.isEmpty()){
                    System.out.println("Não há professor para remover");
                }else{
                    System.out.print("Nome do Professor que deseja remover: ");
                    sc.nextLine();
                    String remover = sc.nextLine();
                    int contador = 0;
                    for (int i = 0; i < listaProfessor.size(); i++) {
                        if (listaProfessor.get(i).getNome().equals(remover)) {
                            listaProfessor.remove(i);
                            System.out.println("Professor removido com sucesso");
                            contador = -10;
                        }else{
                            contador++;
                        }
                    }
                    if(contador == listaProfessor.size()){
                        System.out.println("Professor nao encontrado");
                    }
                }
            }
        
            public static void listarProfessores(){
                if(listaProfessor.isEmpty()){
                    System.out.println("   A Lista está Vazia   ");
                }else{
                    System.out.println("   Lista dos Professores   ");
                    for (int i = 0; i < listaProfessor.size(); i++) {
                        Professor professor = listaProfessor.get(i);
                        System.out.println((i + 1) + "- " + professor.getNome()+ " "+ professor.getMatricula());
                    }
                }
            }

            public static void lancarNota(){
                if(listaAluno.isEmpty()){
                    System.out.println("Não há nenhuma Aluno na lista");
                }else{
                    sc.nextLine();
                    System.out.println("Digite o Nome do Aluno a ter a nota inserida");
                    String alunoNome = sc.nextLine();
                    for (Aluno aluno : listaAluno) {
                        if(aluno.getNome().equals(alunoNome)){
                            System.out.println("Nota 1:");
                            double nota1 = sc.nextDouble();
                            aluno.setNota1(nota1);
                            System.out.println("Nota 2:");
                            double nota2 = sc.nextDouble();
                            aluno.setNota2(nota2);
                        }else{
                            System.out.println("Aluno não encontrado");
                        }
                    }
                }
            }

            public static void mostrarboletim(){
                if(listaAluno.isEmpty()){
                    System.out.println("Não há nenhuma Aluno na lista");
                }else{
                    sc.nextLine();
                    System.out.println("Digite o Nome do Aluno a ter o boletim mostrado");
                    String alunoNome = sc.nextLine();
                    double mediaNota;
                    for (Aluno aluno : listaAluno) {
                        if(aluno.getNome().equals(alunoNome)){
                            mediaNota = (aluno.getNota1() + aluno.getNota2()) / 2;
                            System.out.println("\n--- Boletim ---");
                            System.out.println("Nome: " + aluno.getNome());
                            System.out.println("Matrícula: " + aluno.getMatricula());
                            System.out.println("Nota 1: " + aluno.getNota1());
                            System.out.println("Nota 2: " + aluno.getNota2());
                            System.out.println("Média: " + mediaNota);
                        }else{
                            System.out.println("Aluno não encontrado");
                    }
                }
            }
        }
}