package entities;

import java.util.Scanner;

public class Dolar {
	public Double dolar;
	public Double quant;
	
	public Dolar() {}
	
	public void Leitura() {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("What is the dollar price? ");
		dolar = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		quant = sc.nextDouble();
		
		sc.close();
	}
	
	public Double Real() {
		return quant * 1.06 * dolar;
	}
	
	public void Amount() {
		System.out.printf("Amount to be paid in reais = %.2f", Real());
	}
	
	
}
