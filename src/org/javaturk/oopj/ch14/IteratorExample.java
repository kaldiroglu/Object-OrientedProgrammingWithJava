
package org.javaturk.oopj.ch14;

import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.Collection;
import java.util.Iterator;

import static org.javaturk.oopj.ch14.util.CollectionUtil.listElements;


public class IteratorExample {

    public static void main(String[] args) {
        iteratorExample1();
//		iteratorExample2();
    }

    public static void iteratorExample1() {
        Collection<String> coll = CollectionUtil.getCollection();
        System.out.println("Collection: " + coll);
        listElements(coll);

        coll.add("twenty"); // No problem with that!

        System.out.println("Include \"twenty\": " + coll.contains("twenty"));

        Iterator<String> it = coll.iterator();

//		Don't do this!'
//		coll.add("twenty five");
//		coll.remove("twenty");

        System.out.println("\nIterating");

        while (it.hasNext()) {
            String s = it.next();
            System.out.println("Element: " + s);
            if (s.startsWith("o"))
                it.remove();
        }

        System.out.println("\nCollection after iteration");
        listElements(coll);

        coll.add("twenty six");

        System.out.println("\nIterating one more time");
        it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        coll.add("x");
        coll.add("y");

        System.out.println("\nAfter iteration.");
        listElements(coll);

        coll.remove("y");

        it = coll.iterator();
        while (it.hasNext()) {
            System.out.println("Removing: " + it.next());
            it.remove();
        }

        System.out.println("\nAfter removal in iteration.");
        listElements(coll);

        // Throws java.util.NoSuchElementException
//		if(it.hasNext())
//            it.next();
    }

    public static void iteratorExample2() {
        Collection<String> coll = CollectionUtil.getCollection();
        listElements(coll);

        System.out.println("\nIterator in for each:");
        for (Iterator<String> it = coll.iterator(); it.hasNext(); ) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
