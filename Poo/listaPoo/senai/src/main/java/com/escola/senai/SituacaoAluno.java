package com.escola.senai;

public enum SituacaoAluno {
    APROVADO("APROVADO"),
    REPROVADO("REPROVADO"),
    RECUPERACAO("DE RECUPERAÇÃO");

    private final String descricao;

    SituacaoAluno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
