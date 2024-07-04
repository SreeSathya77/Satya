package com.example.myproject;
import java.util.*;

		class Employee {
		    private String name;
		    private double salary;

		    public Employee(String name, double salary) {
		        this.name = name;
		        this.salary = salary;
		    }

		    public String getName() {
		        return name;
		    }

		    public double getSalary() {
		        return salary;
		    }
		}

		public class SetExample {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
		        Scanner scanner = new Scanner(System.in);
		        Set<Employee> employees = new HashSet<>();

		        // Input loop to take employee records
		        System.out.println("Enter employee records (name salary), type 'done' to finish:");
		        while (true) {
		            System.out.print("Enter name and salary: ");
		            String input = scanner.nextLine().trim();
		            if (input.equalsIgnoreCase("done")) {
		                break;
		            }
		            String[] parts = input.split(" ");
		            if (parts.length != 2) {
		                System.out.println("Invalid input format. Please enter name and salary separated by space.");
		                continue;
		            }
		            String name = parts[0];
		            double salary;
		            try {
		                salary = Double.parseDouble(parts[1]);
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid salary format. Please enter a valid number.");
		                continue;
		            }
		            employees.add(new Employee(name, salary));
		        }
		        scanner.close();

		        // Finding the employee with the highest salary
		        Employee highestSalaryEmployee = null;
		        double maxSalary = Double.MIN_VALUE;
		        for (Employee emp : employees) {
		            if (emp.getSalary() > maxSalary) {
		                maxSalary = emp.getSalary();
		                highestSalaryEmployee = emp;
		            }
		        }

		        // Displaying the employee with the highest salary
		        if (highestSalaryEmployee != null) {
		            System.out.println("Employee with the highest salary:");
		            System.out.println("Name: " + highestSalaryEmployee.getName());
		            System.out.println("Salary: " + highestSalaryEmployee.getSalary());
		        } else {
		            System.out.println("No employees entered.");
		        }
		    }
		}
