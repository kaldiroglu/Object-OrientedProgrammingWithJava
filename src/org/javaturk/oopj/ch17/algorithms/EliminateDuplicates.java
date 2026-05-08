package org.javaturk.oopj.ch17.algorithms;

import java.util.*;

public class EliminateDuplicates {

	public static void main(String[] args) {
		List list = List.of("Ali", "Ayşe", "Zeynep", "Selman", "Ali", "Nil", "Kemal", "Nil", "Zeynep");
		Set set = new HashSet(list);
		set.forEach(System.out::println);
	}
}
