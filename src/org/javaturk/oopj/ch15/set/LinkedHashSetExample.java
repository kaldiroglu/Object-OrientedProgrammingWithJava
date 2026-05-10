package org.javaturk.oopj.ch15.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        run1();
//        run2();
//        run3();
    }

    static void run1() {
        System.out.println("run1()");

        System.out.println("\n*** HashSet ***");
        HashSet<String> hSet = new HashSet<>(20);
        hSet.add("Mohammed Salah");
        hSet.add("Markus Rashford");
        hSet.add("Kevin DeBruyne");
        hSet.add("Kevin Trippier");
        hSet.add("Bernardo Silva");
        hSet.add("Erling Haaland");
        hSet.add("Bukayo Saka");

        for (String s : hSet)
            System.out.println(s);

        System.out.println("\n*** LinkedHashSet ***");

        LinkedHashSet<String> lhSet = new LinkedHashSet<>(20);
        lhSet.add("Mohammed Salah");
        lhSet.add("Markus Rashford");
        lhSet.add("Kevin DeBruyne");
        lhSet.add("Kevin Trippier");
        lhSet.add("Bernardo Silva");
        lhSet.add("Erling Haaland");
        lhSet.add("Bukayo Saka");

        for (String s : lhSet)
            System.out.println(s);

        System.out.println("\n*** After reinserting ***");

        System.out.println("Reinsert: " + lhSet.add("Mohammed Salah") + " \n");
        for (String s : lhSet)
            System.out.println(s);
    }

    static void run2() {
        System.out.println("run2()");

        System.out.println("\n*** HashSet ***");
        HashSet<String> hSet = new HashSet<>(20);
        hSet.add("Mohammed Salah");
        hSet.add("Markus Rashford");
        hSet.add("Kevin DeBruyne");
        hSet.add("Kevin Trippier");
        hSet.add("Bernardo Silva");
        hSet.add("Erling Haaland");
        hSet.add("Bukayo Saka");

        for (String s : hSet)
            System.out.println(s);

        System.out.println("\n*** LinkedHashSet ***");
        LinkedHashSet<String> lhSet = new LinkedHashSet<>(hSet);

        for (String s : lhSet)
            System.out.println(s);

        System.out.println("\n*** After inserting ***");

        System.out.println(lhSet.add("Declan Rice"));
        System.out.println(lhSet.add("Tosin Adarabioyo"));
        System.out.println(lhSet.add("Kai Havertz"));

        for (String s : lhSet)
            System.out.println(s);
    }

    /**
     * SequencedCollection methods
     */
    static void run3() {
        System.out.println("run3()");

        LinkedHashSet<String> lhSet = new LinkedHashSet<>(20);
        lhSet.add("Mohammed Salah");
        lhSet.add("Markus Rashford");
        lhSet.add("Kevin DeBruyne");
        lhSet.add("Kevin Trippier");
        lhSet.add("Bernardo Silva");
        lhSet.add("Erling Haaland");
        lhSet.add("Bukayo Saka");

        System.out.println("\n *** Before ***");

        for (String s : lhSet)
            System.out.println(s);

        lhSet.addFirst("Phil Foden");
        lhSet.addLast("Virgil van Dijk");

        System.out.println("\nFirst: " + lhSet.getFirst());
        System.out.println("Last: " + lhSet.getLast());

        System.out.println("First removed: " + lhSet.removeFirst());
        System.out.println("Last removed: " + lhSet.removeLast());

        System.out.println("\n *** After ***");

        for (String s : lhSet)
            System.out.println(s);

        SequencedCollection<String> sc = lhSet.reversed();

        System.out.println("\n *** Reversed ***");

        for (String s : sc)
            System.out.println(s);
    }
}
