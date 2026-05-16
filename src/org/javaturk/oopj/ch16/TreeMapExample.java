package org.javaturk.oopj.ch16;

import org.javaturk.oopj.ch14.domain.Student;

import java.util.*;


public class TreeMapExample {
	static Map studentsWithID = new TreeMap();
	static Map studentsWithName = new TreeMap();

	public static void main(String[] args) {
//		for (int i = 10; i > 0; i--) {
//			Student s = new Student(i, "Ogrenci" + i);
//			studentsWithID.put(s.getId(), s);
//		}
//
//		System.out.println("Student with ID");
//		Set ids = studentsWithID.keySet();
//		Iterator iterator = ids.iterator();
//		while (iterator.hasNext()) {
////			Student s = (Student) iterator.next();
////			int i = (Integer) studentsWithID.get(s);
//			int id = (Integer) iterator.next();
//			Student s = (Student) studentsWithID.get(id);
//			System.out.println(s);
//		}
//
//		System.out.println("\nStudent with names");
//		for (int i = 10; i > 0; i--) {
//			Student s = new Student(i, "Ogrenci" + i);
//			studentsWithName.put(s.getIsim(), s);
//		}
//
//		Set names = studentsWithName.keySet();
//		Iterator iterator2 = names.iterator();
//		while (iterator2.hasNext()) {
//			String name = (String) iterator2.next();
//			Student s = (Student) studentsWithName.get(name);
//			System.out.println(s);
//		}
		
		System.out.println("\n*** Giving a comparator ***");
		Comparator<String> nameLengthComparator = (s1, s2) -> s1.length() - s2.length();
		Map studentsWithNameByLength = new TreeMap(nameLengthComparator);
//		Map<String, Student> studentsWithNameByLength = new TreeMap<>(new NameLengthComparator());
		for (int i = 100; i > 0; i--) {
			Student s = new Student(i, "Ogrenci" + i);
//			System.out.println(i + " öğrenci: " + s);
			studentsWithNameByLength.put(s.getIsim(), s);
		}

		studentsWithNameByLength.put("54534534", new Student(54534534, "Ali"));
		studentsWithNameByLength.put("54534535", new Student(54534534, "MehmetAliKemal"));
		studentsWithNameByLength.put("545343", new Student(54534534, "X"));
		studentsWithNameByLength.put("545343", new Student(54534534, "XY"));
		
//		System.out.println("\nObjects in the Map");
//		studentsWithNameByLength.forEach((k, v) -> System.out.println(k + " -> " + v)); // Why there are only two elements in the map?
//
		System.out.println("\nEntries in the Map");
		var entrySet = studentsWithNameByLength.entrySet();
		entrySet.forEach(System.out::println);
	}
}
