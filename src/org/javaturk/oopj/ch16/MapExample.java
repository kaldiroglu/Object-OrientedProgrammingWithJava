package org.javaturk.oopj.ch16;

import org.javaturk.oopj.ch14.util.CollectionUtil;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapExample {

	public static void main(String[] args) {
//		processMap();
//		replaceAndRemove();
//		computeFunctions();
		processUnmodifiableMap();
	}

	public static void processMap() {
		Map map = CollectionUtil.getMap();

		System.out.println("\n*** Keys ***");
		Set keySet = map.keySet();
		keySet.forEach(System.out::println);

		System.out.println("\n*** Values ***");
		Collection coll = map.values();
		coll.forEach(System.out::println);

		map.put("twenty", 20);
		System.out.println("\nPutting a new value for five: " + map.put("five", 50));
		System.out.println("Value of five: " + map.get("five"));
		System.out.println("Value of yirmi: " + map.get("yirmi"));
		
		System.out.println("\nPutting a new value for million: " + map.put("million", 1_000_000));

		System.out.println("\nReplacing a new value for one: " + map.replace("one", 10));

		System.out.println("\nPutting a new value for thirty using putIfAbsent : " + map.putIfAbsent("thirty", 30)); // The entry "thirty" - 30 is inserted!
		System.out.println("\nPutting a new value for thirty using putIfAbsent : " + map.putIfAbsent("thirty", 300)); // 30 is not replaced by 3000
//		coll.forEach(System.out::println);

		System.out.println("\nContains key one? " + map.containsKey("one"));
		System.out.println("Contains value one? " + map.containsValue("one"));

		BiFunction<Integer, Integer, Integer> biFunction = (vOld, vNew) -> vOld + vNew;
		System.out.println("New value for eighty: " + map.merge("eighty", 80, biFunction));

		System.out.println("New value for eighty: " + map.merge("eighty", 80, biFunction));

		System.out.println("\nKeys and Values");
		Set keys = map.keySet();
		for (Object key : keys) {
			Object value = map.get(key);
			System.out.println(key + " -> " + value);
		}

		System.out.println("\nKeys and Values");
		keys = map.keySet();
		Iterator it = keySet.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = map.get(key);
			System.out.println(key + " -> " + value);
		}

		System.out.println("\nKeys and Values with BiConsumer");
		BiConsumer biConsumer = (k, v) -> System.out.println(k + " -> " + v);
		map.forEach(biConsumer);
	}

	public static void replaceAndRemove() {
		Map map = CollectionUtil.getMap();
		Set entrySet = map.entrySet();

		System.out.println("Map entries");
		entrySet.forEach(System.out::println);

		System.out.println();

		System.out.println(map.replace("one", 111));
		System.out.println(map.replace("five", 5, 55));
		System.out.println(map.replace("eleven", 120, 121));

		System.out.println("\nMap entries");
		entrySet.forEach(System.out::println);

		BiFunction<String, Integer, Integer> replacemenFunction = (k, v) -> k.length() + v;
		map.replaceAll(replacemenFunction);

		System.out.println("\nMap entries");
		entrySet.forEach(System.out::println);

		System.out.println("\nRemoving key one: " + map.remove("one"));
		System.out.println("Removing key five and 59: " + map.remove("five", 59));
		System.out.println("Removing key eleven and 100: " + map.remove("eleven", 100));
		
		System.out.println("\nMap entries");
		entrySet.forEach(System.out::println);
	}

	public static void computeFunctions() {
		Map map = CollectionUtil.getMap();

		System.out.println("*** Entry set *** ");
		Set entrySet = map.entrySet();
		entrySet.forEach(System.out::println);

		System.out.println("\nAfter compute");
		BiFunction<String, Integer, Integer> remappingFunction1 = (k, v) -> (k.length() + v) * 10;
		map.compute("one", remappingFunction1); // NullPointerException if key is not present
		entrySet.forEach(System.out::println);

		System.out.println("\nAfter computeIfAbsent");
		Function<String, Integer> mappingFunction = (s) -> s.length();
		map.computeIfAbsent("one", mappingFunction);
		map.computeIfAbsent("hundred", mappingFunction);
		entrySet.forEach(System.out::println);
		
		System.out.println("\nAfter computeIfPresent");
		BiFunction<String, Integer, Integer> remappingFunction2 = (k, v) -> (k.length() + 10) * v;
		map.computeIfPresent("eleven", remappingFunction2);
		entrySet.forEach(System.out::println);
		map.computeIfPresent("elevenx", remappingFunction2);
		entrySet.forEach(System.out::println);
	}

	public static void processUnmodifiableMap() {
		Map map = Map.of(1, "Ali", 2, "Veli", 3, "Selcan", 4, "Yesim"); // add 5, null and see what happens!
		System.out.println("\nKeys and Values");
		Set keys = map.keySet();
		for (Object key : keys) {
			Object value = map.get(key);
			System.out.println(key + " - " + value);
		}

		System.out.println();

		map.forEach((k, v) -> System.out.println(k + " --> " + v));

//		map.put(5, "Sibel");
	}
}
