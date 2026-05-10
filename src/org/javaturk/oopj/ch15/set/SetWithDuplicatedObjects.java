
package org.javaturk.oopj.ch15.set;

import org.javaturk.oopj.ch14.domain.Employee;
import org.javaturk.oopj.ch14.domain.EmployeeNameComparator;
import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetWithDuplicatedObjects {

	public static void main(String[] args) {
		EmployeeNameComparator ec = new EmployeeNameComparator();
		Set set = new TreeSet(ec);

		Employee e1 = new Employee(888, "Mihrimah", "Kaldiroglu");
		System.out.println(set.add(e1) + "\n");
		
		Employee e2 = new Employee(222, "Ali", "Canan");
		System.out.println(set.add(e2) + "\n");
		
		Employee e3 = new Employee(111, "Ayse", "Unlu");
		System.out.println(set.add(e3) + "\n");
		
		Employee e4 = new Employee(223, "Sami", "Mutlu");
		System.out.println(set.add(e4) + "\n");
		
		Employee e5 = new Employee(222, "Ali", "Canan");
		System.out.println(set.add(e5) + "\n");  // Do you think e5 would be added?

		CollectionUtil.listElements(set);
	}
}
