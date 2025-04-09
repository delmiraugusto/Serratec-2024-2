package com.loja.virtual.modelos.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.loja.virtual.Login.Login;
import com.loja.virtual.Login.LoginController;
import com.loja.virtual.enumeradores.Role;
import static com.loja.virtual.modelos.cliente.CadastrarCliente.cadastrarCliente;
import com.loja.virtual.modelos.cliente.Cliente;
import static com.loja.virtual.modelos.cliente.Cliente.clientes;
import com.loja.virtual.modelos.gestor.Gestor;
import static com.loja.virtual.modelos.gestor.Gestor.gestores;
import static com.loja.virtual.modelos.menu.MenuCliente.menuCliente;
import static com.loja.virtual.modelos.menu.MenuGestor.menuGestor;

public class LoginVerification {
    static Scanner scEntrada = new Scanner(System.in);
    static List<Login> usuarios = new ArrayList<>();



    public static void loginVerification() {
        Gestor gestor = new Gestor();
        gestor.setLogin("admin");
        gestor.setSenha("123");
        gestores.add(gestor);
        usuarios.addAll(Cliente.clientes);
        usuarios.addAll(Gestor.gestores);

        int option = 1;
        do{
            try {
                System.out.println("""
                        
                        ====================================
                        |         MENU PRINCIPAL           |
                        ====================================
                        | 1 - Login                        |
                        |(Caso já possua conta)            |
                        | 2 - Cadastrar                    |
                        | (Cadastrar uma nova conta)       |
                        | 0 - Sair                         |
                        ====================================
                        Escolha uma opção:""");
                option = scEntrada.nextInt();
                scEntrada.nextLine();
                switch (option) {
                    case 1 -> {
                        String user = "";
                        String pass = "";

                        tipoLogin(user, pass);

                    }
                    case 2 -> cadastrarCliente();
                }
            }catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                    scEntrada.next();
            }
        }while(option != 0);
    }

    public static void tipoLogin(String user, String pass){
        int numero = 1;
        do{
            try {
                System.out.println("""

                        ======================
                        |1 - Cliente         |
                        |2 - Gestor          |
                        |0 - Sair            |
                        ======================
                        Escolha uma opção:
                        """);
                numero = scEntrada.nextInt();
                switch (numero) {
                    case 1:
                        verificacaoCliente(user, pass);
                        break;
                    case 2:
                        verificacaoGestor(user, pass);
                        break;
                    case 0:
                        System.out.println("Programa Saindo");
                        break;
                    default:
                        System.out.println("Número Inválido");
                }
            }catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scEntrada.next();
            }
        }while(numero != 0);
    }

    public static boolean verificacaoCliente(String user, String pass){
        int contador = 4;
        int contadorLista = 0;
        boolean encontrado = false;
        Scanner scCliente = new Scanner(System.in);
            do{

                System.out.println("Digite seu login:");
                user = scCliente.nextLine();
                System.out.println("Digite sua senha:");
                pass = scCliente.nextLine();
                
                if(clientes.isEmpty()){
                    System.out.println("Nenhum Cliente Listado");
                }else{
                    for (int i = 0; i < clientes.size() && encontrado == false; i++) {
                        if(!clientes.get(i).getLogin().equals(user) && !clientes.get(i).getSenha().equals(pass)){
                            contadorLista++;
                        }else if(!clientes.get(i).getLogin().equals(user)){
                            contadorLista++;
                        }else if (!clientes.get(i).getSenha().equals(pass)){
                            contadorLista++;
                        }else{
                            encontrado = true;
                            LoginController loginController = new LoginController();
                            Role role = loginController.login(user, pass, usuarios);
                            if(role == Role.CLIENTE){
                                menuCliente(user);
                            }
                            return true;
                        }
                    }
                    if(contadorLista == clientes.size()){
                        System.out.println("Usuário Não Encontrado! Tente novamente.");
                        contador--;
                        System.out.println("Tentativas restantes: " + contador);
                        contadorLista = 0;
                    }  
                }
                
            }while(contador > 0);

            System.out.println("Você esgotou suas tentativas.");
            return false;
        }

        public static boolean verificacaoGestor(String user, String pass){
        int contador = 4;
        int contadorLista = 0;
        boolean encontrado = false;
        Scanner scGestor = new Scanner(System.in);
            do{
                System.out.println("Digite seu login:");
                user = scGestor.nextLine();
                System.out.println("Digite sua senha:");
                pass = scGestor.nextLine();
                
                if(gestores.isEmpty()){
                    System.out.println("Nenhum Gestor Listado");
                }else{
                    for (int i = 0; i < gestores.size() && encontrado == false; i++) {
                        if(!gestores.get(i).getLogin().equals(user) && !gestores.get(i).getSenha().equals(pass)){
                            contadorLista++;
                        }else if(!gestores.get(i).getLogin().equals(user)){
                            contadorLista++;
                        }else if (!gestores.get(i).getSenha().equals(pass)){
                            contadorLista++;
                        }else{
                            System.out.println("Acesso Liberado!");
                            encontrado = true;
                            LoginController loginController = new LoginController();
                            Role role = loginController.login(user, pass, usuarios);
                            if(role == Role.GESTOR){
                                menuGestor(user);
                            }
                            return true;
                        }
                    }

                    if(contadorLista == gestores.size()){
                        System.out.println("Usuário Não Encontrado! Tente novamente.");
                        contador--;
                        System.out.println("Tentativas restantes: " + contador);
                        contadorLista = 0;
                    }    
                }
                
            }while(contador > 0);
            
            System.out.println("Você esgotou suas tentativas.");
            return false;
        }

}
