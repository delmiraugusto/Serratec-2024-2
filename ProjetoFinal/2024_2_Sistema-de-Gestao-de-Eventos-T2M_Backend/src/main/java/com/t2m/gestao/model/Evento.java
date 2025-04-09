package com.t2m.gestao.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.t2m.gestao.util.TratamentoDeErro;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank(message = TratamentoDeErro.NotBlankMessage7)
	private String nomeEvento;
	@NotNull
	private LocalDateTime dataHora;
	@Pattern(regexp = "^PT([0-9]+H)?([0-9]+M)?([0-9]+S)?$", message = "Duração inválida. O formato deve ser PTnHnMnS.")
	@NotNull
	@NotBlank(message = TratamentoDeErro.NotBlankMessage10)
	private String duracaoEvento;

	//TEM QUE SER NULO
	private String descricao;

	//TEM QUE SER NULO
	private String topicos;
	@Lob
	@Column(name = "capa_evento")
	private byte[] foto;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Inscricao> inscricoes = new ArrayList<>();
	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTopicos() {
		return topicos;
	}

	public void setTopicos(String topicos) {
		this.topicos = topicos;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Evento() {
	}

	public Evento(Long id, String nomeEvento, LocalDateTime dataHora, String duracaoEvento) {
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.dataHora = dataHora;
		this.duracaoEvento = duracaoEvento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getDataHoraFormatada() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return dataHora.format(formatter);
	}

	public String getDuracaoEvento() {
		return duracaoEvento;
	}

	public void setDuracaoEvento(String duracaoEvento) {
		this.duracaoEvento = duracaoEvento;
	}

	public void adicionarInscricao(Inscricao inscricao) {
		this.inscricoes.add(inscricao);
		inscricao.setEvento(this);
	}

	public void removerInscricao(Inscricao inscricao) {
		this.inscricoes.remove(inscricao);
		inscricao.setEvento(null);
	}
}
