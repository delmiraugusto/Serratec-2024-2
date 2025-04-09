package com.t2m.gestao.model;

import com.t2m.gestao.util.TratamentoDeErro;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = TratamentoDeErro.NotBlankMessage)
    @Size(min = 8, max = 8, message = "CEP deve conter apenas 8 digitos")
    @Column
    private String cep;
    @NotBlank(message = TratamentoDeErro.NotBlankMessage6)
    @Size(min = 3, max = 100, message = TratamentoDeErro.SizeMessage)
    @Column
    private String rua;
    @NotBlank(message = TratamentoDeErro.NotBlankMessage6)
    @Size(min = 3, max = 100, message = TratamentoDeErro.SizeMessage)
    @Column
    private String bairro;
    @NotBlank(message = TratamentoDeErro.NotBlankMessage6)
    @Size(min = 1, max = 100, message = TratamentoDeErro.SizeMessage)
    @Column
    private String cidade;
    @NotBlank(message = TratamentoDeErro.NotBlankMessage)
    @Size(min = 1, max = 1000, message = TratamentoDeErro.SizeMessage)
    @Column
    private String numero;

    @Size(max = 100, message = TratamentoDeErro.SizeMessage)
    @Column
    private String complemento;
    @NotBlank(message = TratamentoDeErro.NotBlankMessage13)
    @Size(min = 2, max = 2, message = TratamentoDeErro.SizeMessage)
    @Column
    private String uf;


	public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco id=" + id + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade
                + ", numero=" + numero + ", complemento=" + complemento + ", uf=" + uf;
    }
}
