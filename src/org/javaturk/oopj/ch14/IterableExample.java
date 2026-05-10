
package org.javaturk.oopj.ch14;

import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.Collection;
import java.util.Iterator;


public class IterableExample {

	public static void main(String[] args) {
		Collection<String> coll = CollectionUtil.getCollection();
		
		System.out.println("Elements in collection.");
		for (Object o : coll)
			System.out.println(o);

		iterate(coll);
		forEach(coll);
		
		// System.out.println("\nIterating an array.");
		// int[] array = { 4, 1, 5, 2, 8, 9, 6 };
		// for (int i : array) {
		// System.out.println(i);
		// }

		// iterate(array); // Arrays are not iterable objects!

	}

	public static void iterate(Iterable iterable) {
		System.out.println("\n***   iterate()   ***");
		Iterator<String> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s + " has " + s.length() + " characters.");
		}
	}

	public static void forEach(Iterable iterable) {
		System.out.println("\n***   forEach()   ***");
		iterable.forEach(s -> {
			System.out.println(s + " has " + ((String)s).length() + " characters.");
		});
	}
}
