package entities;

public class Bank {
	private static int account = 1;
	private int accountNumber;
	private String name;
	private Double deposit;
	
	public Bank(String name, Double deposit) {
		accountNumber += account;
		account++;
		this.name = name;
		this.deposit = deposit;
	}
	
	public Bank(String name) {
		accountNumber += account;
		account++;
		this.name = name;
		deposit = 0.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getaccountNumber() {
		return accountNumber;
	}

	public Double getDeposit() {
		return deposit;
	}
	
	public void Deposit(Double amount) {
		deposit += amount; 
	}
	
	public void withdrawal(Double amount) {
		deposit -= amount + 5.00;
	}
	
	public String toString() {
		return "Account " 
				+ accountNumber 
				+ ", Holder: " 
				+ name
				+ ", Balance: $ "
				+ String.format("%.2f", deposit);
	}
	
	

}
