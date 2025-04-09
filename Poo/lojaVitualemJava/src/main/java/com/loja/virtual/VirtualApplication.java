package com.loja.virtual;

import com.loja.virtual.modelos.cliente.ClienteInstance;
import com.loja.virtual.modelos.pedido.PedidosInstance;
import com.loja.virtual.modelos.produto.ProdutoInstance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.loja.virtual.modelos.menu.LoginVerification.loginVerification;


@SpringBootApplication
public class VirtualApplication {
	public static void main(String[] args) {
		SpringApplication.run(VirtualApplication.class, args);
		ProdutoInstance.produtoInstance();
		ClienteInstance.clienteInstance();
		PedidosInstance.pedidosInstance();
		loginVerification();
	}
}