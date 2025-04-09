package br.com.serratec.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Preencha o campo corretamente")
	@Column(nullable = false, length = 200)
	private String nome;

	@NotBlank(message = "Preencha o campo corretamente")
	@Email(message = "Preencha o e-mail corretamente - usuario@example.com")
	private String email;

	@NotBlank(message = "Preencha o campo corretamente")
	@Size(min = 1412)
	private Double salario;

	@JsonManagedReference
	@OneToMany(mappedBy = "vendedor")
	List<LancamentoVendas> vendas = new ArrayList<>();

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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<LancamentoVendas> getVendas() {
		return vendas;
	}

	public void setVendas(List<LancamentoVendas> vendas) {
		this.vendas = vendas;
	}

}
