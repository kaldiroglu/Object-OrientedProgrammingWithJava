package org.javaturk.oopj.ch06.factory;

import org.javaturk.oopj.ch06.factory.domain.*;

public class PolymorphismTest {

	public static void main(String[] args) {
		//These are normal assignments
		System.out.println("Regular assignments\n");
		Employee e = new Employee(1, "Ali", 8, "Production");
		e.work();

		System.out.println();
		
		Manager m = new Manager(2, "Fatma", 3, "Production", "Production");
		m.work();

		System.out.println();

		Director d = new Director(4, "Mehmet", 20, "Management", "Management", 3000);
		d.work();

		System.out.println("\n************\n");

//		These are upcasting assignments
		System.out.println("\nUpcasting assignments - 1");
		e = m;
		e.work();

		System.out.println();

		e = d;
		e.work();

		System.out.println("\n************\n");
		
		//These are also upcasting assignments
		System.out.println("\nUpcasting assignments - 2");
		Employee e1 = new Employee(1, "Ali", 8, "Production");
		e1.work();
		System.out.println();
		
		e1 = new Manager(2, "Fatma", 3, "Production", "Production");
		e1.work();
		System.out.println();
		
		e1 = new Director(4, "Mehmet", 20, "Management", "Management", 3000);
		e1.work();

		System.out.println("\n************\n");
		Boss b = new Boss();
		b.youWorkToo();
//		b.work();
	}
}
