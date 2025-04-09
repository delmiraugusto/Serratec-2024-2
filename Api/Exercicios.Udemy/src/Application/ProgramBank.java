package Application;

import java.util.Scanner;

import entities.Bank;

public class ProgramBank{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Bank bank;
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Do you want to deposit? ");
		String logic = sc.nextLine();
		if(logic.equals("yes")) {
			System.out.print("Deposit? ");
			double deposit = sc.nextDouble();
			bank = new Bank (name, deposit);
		}else {
			bank = new Bank (name);
		}
		
		System.out.println("\nAccount data:");
		System.out.println(bank);
		
		System.out.print("\nEnter a deposit value: ");
		Double enter = sc.nextDouble();
		bank.Deposit(enter);
		System.out.println("Updated account data:");
		System.out.println(bank);
		
		System.out.print("\nEnter a withdraw value: ");
		Double withdraw = sc.nextDouble();
		bank.withdrawal(withdraw);
		System.out.println("Updated account data:");
		System.out.println(bank);	
		
		
		sc.close();
	}

}
