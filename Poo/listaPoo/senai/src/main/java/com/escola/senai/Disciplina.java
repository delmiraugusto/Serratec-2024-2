package com.escola.senai;

public class Disciplina {
    
    // fazer enum turno
    private String nome;
    private Turno turno; 
    private Professor professor;

    public Disciplina(String nome, Turno turno, Professor professor) {
        this.nome = nome;
        this.turno = turno;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + ", é do turno da " + turno + ", ministrada pelo professor " + professor.getNome();
    }
    
}
