package com.loja.virtual.Login;

import java.util.List;
import java.util.Scanner;

import com.loja.virtual.enumeradores.Role;

public class LoginController {
    static Scanner sc = new Scanner(System.in);
    public Role login(String usuario, String senha, List<Login> usuarios) {
        for (Login user : usuarios) {
            if(user.acessoPermitido(usuario, senha)) {
                return user.getRole();
            }
        }
        return null;
    }
}
