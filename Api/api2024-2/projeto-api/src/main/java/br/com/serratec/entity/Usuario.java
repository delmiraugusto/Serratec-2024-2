package br.com.serratec.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Identificador único do usuário")
	private Long id;
	@Schema(description = "Nome do usuário")
	private String nome;
	@Schema(description = "Email do usuário")
	private String email;
	@Schema(description = "Senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	@OneToMany(mappedBy = "id.usuario")
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

	@Override
	public String toString() {
		return "Id:" + id + "\n" + "Nome:" + nome + "\n" + "Email:" + email;
	}

	
	
	public Set<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	
}
