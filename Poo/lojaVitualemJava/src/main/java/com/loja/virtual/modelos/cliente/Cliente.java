package com.loja.virtual.modelos.cliente;

import java.util.ArrayList;
import java.util.List;

import com.loja.virtual.Login.Login;
import com.loja.virtual.enumeradores.Role;
import com.loja.virtual.modelos.usuario.Usuario;

import lombok.Data;


@Data
public class Cliente extends Usuario implements Login {
    private Role role = Role.CLIENTE;
    private String login;
    private String senha;
    public static List<Cliente> clientes = new ArrayList<>();

    @Override
    public boolean acessoPermitido(String login, String senha) {
        return login.equals(this.getLogin()) && senha.equals(this.getSenha());
    }

    @Override
    public Role getRole() {
        return role;
    }

}


