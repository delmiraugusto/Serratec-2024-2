package br.com.serratec.DTO;

import br.com.serratec.entity.Cliente;
import br.com.serratec.entity.Produto;

public class AvaliacaoResponseDTO {
	
	private int avaliacao;
    private String comentario;
    private String nomeProduto;
    private String nomeCliente;

    public AvaliacaoResponseDTO(int avaliacao, String comentario, Produto produto, Cliente cliente) {
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.nomeProduto = produto.getNome();
        this.nomeCliente = produto.getNome();
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
    
}
