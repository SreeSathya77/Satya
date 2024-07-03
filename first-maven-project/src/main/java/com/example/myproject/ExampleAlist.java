package com.example.myproject;
import java.util.*;
public class ExampleAlist {
public static void main(String[] args) {
try(Scanner scanner = new Scanner(System.in))
{
	List<Opportunity> opportunities= new ArrayList<>();
	System.out.println("Enter number of opportunities:");
	int n = scanner.nextInt();
	for (int i=0;i<n;i++)
	{	
	System.out.println("Enter opportunity:" + (i+1) + ": ");
	System.out.println("Enter Opt Id:");
	int id = scanner.nextInt();
	scanner.nextLine();
	
	System.out.println("Enter Opportunity owner name:");
	String name=scanner.nextLine();
	
	System.out.println("Enter Opportunity amount:");
	double amount = scanner.nextDouble();
	scanner.nextLine();
	
	opportunities.add(new Opportunity(id, name, amount));
}
	
Opportunity HSOptAmount = findHSOptAmount(opportunities);
System.out.println("HIGHEST Opportunity Amount: " + HSOptAmount.getamount());

	}
}
private static Opportunity findHSOptAmount(List<Opportunity> opportunities)
{
	if (opportunities.isEmpty())
	{System.out.println("list is empty....");}
	Opportunity HSOptAmount = opportunities.get(0);
	for (Opportunity opt : opportunities)
	{
		if (opt.getamount()> HSOptAmount.getamount())
			HSOptAmount = opt;	
	}
	return HSOptAmount;
}
}
class Opportunity
{
	private int id;
	private String name;
	private double amount;
	
	public Opportunity(int id,	String name, double amount) 
	{
		this.id=id;
		this.name=name;
		this.amount=amount;
	}
	
	public int getid()
	{ return id;}
	
	public String getname()
	{ return name;}
	
	public double getamount()
	{ return amount;}
	
	@Override
	public String toString()
	{
		return("Opportunity {" + "Id" + id + "name" + name + "amount" + amount + "}");
	}	
}