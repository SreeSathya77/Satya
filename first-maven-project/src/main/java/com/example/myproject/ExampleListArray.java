package com.example.myproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExampleListArray {

	public static void main(String[] args) {
		try(Scanner scanner =new Scanner(System.in))
		{
			List<Clerk> clerks= new ArrayList<>();
			System.out.println("enter number of clerks");
			int n= scanner.nextInt();
			for (int i=0;i<n;i++)
			{
				System.out.println("enter details of clerk:" + (i+1) + ":");
				
				System.out.println("enter id:");
				int id = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("enter name:");
				String name=scanner.nextLine();
				
				System.out.println("enter salary");
				double salary = scanner.nextDouble();
				scanner.nextLine();
				
				clerks.add(new Clerk(id, name, salary));
			}
			
			Clerk HSClerk = findHSClerk(clerks);
			System.out.println("Highest salary" + HSClerk.getsalary());
		}
	}
			private static Clerk findHSClerk(List<Clerk> clerks)
			{
				if (clerks.isEmpty())
				throw new IllegalArgumentException("list is empty");
				
				Clerk HSClerk=clerks.get(0);
				for (Clerk clk: clerks)
				{
					if (clk.getsalary()>HSClerk.getsalary())
					{
						HSClerk=clk;
					}
				}
				return HSClerk;
					}
				}
	class Clerk
	{
		private int id;
		private String name;
		private double salary;
		
		public Clerk(int id, String name, double salary)
		{
			this.id = id;
			this.name=name;
			this.salary=salary; 
		}
		
		public int getid()
		{return id;}
		public String getname()
		{return name;}
		public double getsalary()
		{return salary;}
		@Override
		public String toString()
		{
			return("Clerk {" + "Id" + id + "name" + name + "slary" + salary + "}");
		}	
	}
	
