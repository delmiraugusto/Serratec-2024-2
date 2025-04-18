package br.com.serratec.DTO;

import br.com.serratec.entity.Cliente;

public class ClienteResponseDTO {
	
	private String nome;
	private String email;
	//TRAZER O CEP <-------------------------------------------------------------------->

	public ClienteResponseDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
