package java8stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MatchExample {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John", 100000, 1));
		employees.add(new Employee("Emily", 200000, 2));
		employees.add(new Employee("Russell", 90000, 3));
		employees.add(new Employee("Beth", 100000, 4));

		// allMatch ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#allMatch-java.util.function.Predicate-
		System.out.println("---- allMatch ----");
		Predicate<Employee> allMatch = emp -> emp.getName().equals("Beth");
		System.out.println("**must print false** - List contains all employees with name Beth = "
				+ employees.stream().allMatch(allMatch));

		System.out.println("");

		// anyMatch ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#anyMatch-java.util.function.Predicate-
		System.out.println("---- anyMatch ----");
		Predicate<Employee> anyMatch = emp -> emp.getName().equals("Beth");
		System.out.println("**must print true** - List contains any employee(s) with name Beth = "
				+ employees.stream().anyMatch(anyMatch));

		anyMatch = emp -> emp.getName().equals("Pete") || emp.getSalary() > 300000;
		System.out.println("**must print false** - List contains any employee(s) with name Pete or salary > 300000 = "
				+ employees.stream().anyMatch(anyMatch));
		
		System.out.println("");

		// noneMatch ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#noneMatch-java.util.function.Predicate-
		System.out.println("---- noneMatch ----");
		Predicate<Employee> noneMatch = emp -> emp.getName().equals("Beth");
		System.out.println("**must print false** - List contains no employee(s) with name Beth = "
				+ employees.stream().noneMatch(noneMatch));

		noneMatch = emp -> emp.getName().equals("Pete") || emp.getSalary() > 300000;
		System.out.println("**must print true** - List contains no employee(s) with name Pete or salary > 300000 = "
				+ employees.stream().noneMatch(noneMatch));
	}

}

class Employee {
	private String name;
	private int salary;
	private int empId;

	public Employee(String name, int salary, int empId) {
		this.name = name;
		this.salary = salary;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
