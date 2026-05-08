package org.javaturk.oopj.ch17.algorithms;

import java.util.Collections;
import java.util.Set;

import org.javaturk.oopj.ch14.util.CollectionUtil;

public class SetAlgorithmsExample {
	public static void main(String[] args) {
		singleton();
	}
	
	private static void singleton() {
		System.out.println("Singleton and immutable set.");
		Set singletonImmutableSet = Collections.singleton("Java");
		CollectionUtil.listElements(singletonImmutableSet);
//		singletonImmutableSet.add("C++");
	}
}
