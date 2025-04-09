package com.escola.senai;


public class Aluno extends Pessoa{

    public static int contadorMatricula = 1;
    private String matricula;
    private double nota1;
    private double nota2;

    public Aluno(){
        this.matricula = (contadorMatricula + ".24/2");
        contadorMatricula++;
    }

    public Aluno(String nome, String cpf, Endereco endereco) {
        super(nome, cpf, endereco);
        this.matricula = (contadorMatricula + ".24/2");
        contadorMatricula++;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }


    

 
    

}
