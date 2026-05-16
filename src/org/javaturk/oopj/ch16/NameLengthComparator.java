package org.javaturk.oopj.ch16;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        String name1 = (String) o1;
//        String name2 = (String) o2;
//
//        return name1.compareTo(name2);
//    }
}
