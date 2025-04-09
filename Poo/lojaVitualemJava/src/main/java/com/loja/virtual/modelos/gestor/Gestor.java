package com.loja.virtual.modelos.gestor;

import com.loja.virtual.Login.Login;
import com.loja.virtual.enumeradores.Role;
import com.loja.virtual.modelos.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Gestor extends Usuario implements Login {
    private int codFuncionario;
    private String setor;
    private Role role = Role.GESTOR;
    public static List<Gestor> gestores = new ArrayList<>();
    private String login;
    private String senha;

    @Override
    public boolean acessoPermitido(String login, String senha) {
        return login.equals(this.getLogin()) && senha.equals(this.getSenha());
    }

    @Override
    public Role getRole() {
        return role;
    }
}
