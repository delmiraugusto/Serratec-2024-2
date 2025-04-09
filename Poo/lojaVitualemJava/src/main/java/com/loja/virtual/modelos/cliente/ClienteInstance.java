package com.loja.virtual.modelos.cliente;

import static com.loja.virtual.modelos.cliente.Cliente.clientes;

public class ClienteInstance {
    public static void clienteInstance() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rafael");
        cliente1.setLogin("rafa");
        cliente1.setSenha("123");
        clientes.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Gabriela");
        cliente2.setLogin("gabi");
        cliente2.setSenha("456");
        clientes.add(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Ricardo");
        cliente3.setLogin("ric");
        cliente3.setSenha("789");
        clientes.add(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNome("Marcos");
        cliente4.setLogin("marc");
        cliente4.setSenha("321");
        clientes.add(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setNome("Delmir");
        cliente5.setLogin("del");
        cliente5.setSenha("654");
        clientes.add(cliente5);

        Cliente cliente6 = new Cliente();
        cliente6.setNome("Ana Carolina");
        cliente6.setLogin("ana");
        cliente6.setSenha("987");
        clientes.add(cliente6);
    }
}
