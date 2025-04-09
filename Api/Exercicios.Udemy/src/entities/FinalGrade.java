package entities;

import java.util.Scanner;

public class FinalGrade {
	
	private String name;
	private Double nota1, nota2, nota3;
	
	public FinalGrade() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public Double getNota3() {
		return nota3;
	}
	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
	
	public void Leitura() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String name = sc.nextLine();
		setName(name);
		System.out.println("Nota 1: ");
		Double n1 = sc.nextDouble();
		setNota1(n1);
		System.out.println("Nota 2: ");
		Double n2 = sc.nextDouble();
		setNota2(n2);
		System.out.println("Nota 3: ");
		Double n3 = sc.nextDouble();
		setNota3(n3);
		
		sc.close();
	}
	
	public Double Media() {
		return (nota1 + nota2 + nota3);
	}
	
	public String Situacion() {
		if(Media() >= 60.0) {
			return "Pass";
		}
		return "Failed\nMissing " + (60.0 - Media()) + " Points";
	}

	@Override
	public String toString(){
		return "Final Grande = " + String.format("%.2f", Media()) + "\n" + Situacion();
	}
}
