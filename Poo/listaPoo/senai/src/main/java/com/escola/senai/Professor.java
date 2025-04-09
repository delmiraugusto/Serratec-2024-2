package com.escola.senai;

public class Professor extends Pessoa{

    public static int contadorMatricula = 1;
    private String matricula;
    private double salario;

    public Professor(){
        this.matricula = (contadorMatricula + ".24-2");
        contadorMatricula++;
    }

    public Professor(String nome, String cpf, double salario, Endereco endereco) {
        super(nome, cpf, endereco);
        this.salario = salario;
        this.matricula = (contadorMatricula + ".24-2");
        contadorMatricula++;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static int getContadorMatricula() {
        return contadorMatricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public static void setContadorMatricula(int contadorMatricula) {
        Professor.contadorMatricula = contadorMatricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
