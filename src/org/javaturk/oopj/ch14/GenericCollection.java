package org.javaturk.oopj.ch14;

import org.javaturk.oopj.ch14.domain.Employee;
import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.Collection;
import java.util.Iterator;

public class GenericCollection {

    public static void main(String[] args) {
        Collection<Integer> coll = CollectionUtil.getIntCollection();
        System.out.println("Collection: " + coll);

        coll.add(10_000);
//        coll.add(5.0); // Can't do that!
//        coll.add(true); // Can't do that!
//        coll.add("five"); // Can't do that!
//        Employee e = new Employee(999, "Salih", "Guzel", 3);
//        coll.add(e); // Can't do that!

        System.out.println("\nElements in collection by iterator.");
        Iterator<Integer> it = coll.iterator();
        while(it.hasNext()) {
             int i = it.next();
            System.out.println(i);
        }

        System.out.println("\nElements in collection by for each.");
        for(int i : coll)
            System.out.println(i);
    }
}
