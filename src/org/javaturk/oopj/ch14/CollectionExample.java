package org.javaturk.oopj.ch14;

import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.Collection;
import java.util.Iterator;

import static org.javaturk.oopj.ch14.util.CollectionUtil.listElements;


public class CollectionExample {

	public static void main(String[] args) {
		Collection coll1 = CollectionUtil.getCollection();
		System.out.println("Collection: " + coll1);

		System.out.println("\nSize of collection: " + coll1.size());

		System.out.println("\nElements in collection by for each.");
		for(Object o : coll1)
			System.out.println(o);

		boolean b = coll1.add("six");
		System.out.println("\nIs adding 'six' successful? " + b);

		listElements(coll1);

		Collection coll2 = CollectionUtil.getAnotherCollection();
		listElements(coll2);

		b = coll1.add(coll2);
		System.out.println("\nIs adding another collection successful? " + b);

		listElements(coll1);

		System.out.println("\nElements in collection by iterator.");
		Iterator it = coll1.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}

		b = coll1.remove("one");
		System.out.println("\nIs removing one successful? " + b);

		b = coll1.contains("one");
		System.out.println("\nIs one contained? " + b);

		listElements(coll1);
		
		System.out.println("\nDoes the collection contain one? " + coll1.contains("one"));
		System.out.println("Does the collection contain four? " + coll1.contains("four"));

		System.out.println("\nElements in array.");
		Object[] array1 = coll1.toArray();
		for(Object o : array1)
			System.out.println(o);

		System.out.println("\nElements in array.");
		Object[] array2 = coll2.toArray();
		for(Object o : array2)
			System.out.println(o);
	
		coll1.clear();
		System.out.println("Size of coll1: " + coll1.size());
		coll1.add("three");
		coll1.add("four");
		listElements(coll1);
		coll1.clear();
		listElements(coll1);

		System.out.println("\nElements in array.");
		for(Object o : array1)
			System.out.println(o);

		System.out.println("\nElements in collection after clearing.");
		listElements(coll1);
	}
}
