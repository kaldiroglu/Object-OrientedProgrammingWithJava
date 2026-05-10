
package org.javaturk.oopj.ch14;

import org.javaturk.oopj.ch14.domain.Employee;
import org.javaturk.oopj.ch14.domain.EmployeeNameComparator;
import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {
//		compareExample();
		collectionExample();
	}

	public static void compareExample() {
		Employee e1 = new Employee(111, "Mihrimah", "Kaldiroglu", 1);
		Employee e2 = new Employee(222, "Ali", "Can", 3);

		Comparator<Employee> ec = new EmployeeNameComparator();

		System.out.println("Compare e1 to e2: " + ec.compare(e1, e2));
		System.out.println("Compare e2 to e1: " + ec.compare(e2, e1));
		System.out.println("Compare e1 to e1: " + ec.compare(e1, e1));

		System.out.println("\nAfter reversed.");

		Comparator<Employee> ecReversed = ec.reversed();
		System.out.println("Compare e1 to e2: " + ecReversed.compare(e1, e2));
		System.out.println("Compare e2 to e1: " + ecReversed.compare(e2, e1));
		System.out.println("Compare e1 to e1: " + ecReversed.compare(e1, e1));
	}
	
	public static void collectionExample() {
		List<Employee> employees = CollectionUtil.getEmployeeList();
		
		System.out.println("Before sorting alphabetically.");
		printEmployees(employees);
		
		System.out.println("\nAfter sorting.");
		Comparator<Employee> comparator = new EmployeeNameComparator();
		Collections.sort(employees, comparator);
		printEmployees(employees);
		
		System.out.println("\nAfter sorting in reverse.");
		Comparator<Employee> reverseComparator = comparator.reversed();
		Collections.sort(employees, reverseComparator);
		printEmployees(employees);

		System.out.println("\nAfter sorting by ids.");
		Collections.sort(employees);
		printEmployees(employees);
	}
	
	private static void printEmployees(List<Employee> employees) {
		System.out.println("\nEmployees");
		employees.forEach(System.out::println);
	}
}
