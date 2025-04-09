package entities;

public class Employee {
	private String name;
	private Double grossSalary;
	private Double tax;
	
	public Employee() {}
	
	public Employee(String name, Double grossSalary, Double tax) {
		this.name = name;
		this.grossSalary = grossSalary;
		this.tax = tax;
	}

	public Double NetSalary() {
		return grossSalary - tax;
	}
	
	public void IncreaseSalary(Double percentage) {
		grossSalary += grossSalary * (percentage/100);
	}
	
	@Override
	public String toString() {
		return "Employee: "+ name + " , $ " + NetSalary();
	}
	
	
}
