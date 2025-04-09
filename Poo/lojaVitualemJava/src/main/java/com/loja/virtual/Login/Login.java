package com.loja.virtual.Login;

import com.loja.virtual.enumeradores.Role;

public interface Login {
    boolean acessoPermitido(String login, String senha);
    Role getRole();
}
