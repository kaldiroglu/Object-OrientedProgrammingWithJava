package org.javaturk.oopj.ch06.factory.hr;

import org.javaturk.oopj.ch06.factory.domain.Employee;
import org.javaturk.oopj.ch06.factory.domain.Manager;
import org.javaturk.oopj.ch06.factory.hr.HR;
import org.javaturk.oopj.ch06.factory.hr.HRForManagers;

public class HRForManagersTest {

	public static void main(String[] args) {
		HR hr = new HRForManagers();
		Employee e = hr.getAnEmployee();
		System.out.println(e);
		
		HRForManagers hrfm = new HRForManagers();
		Manager m = hrfm.getAnEmployee();
		System.out.println(m);
		
		
		
//		HR hr1 = new HRForManagers();
//		Manager m1 = hr1.getAnEmployee();
//		System.out.println(m1);
	}

}
