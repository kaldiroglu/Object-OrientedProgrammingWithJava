
package org.javaturk.oopj.ch16;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapPerformance {
	private static int n = 100_000_000;
	private static Random random = new Random();

	public static void main(String[] args) {
		hashMapInsertion();
		treeMapInsertion();
	}

	public static void hashMapInsertion() {
		Map<Integer, Integer> map = new HashMap<>();
		Instant start = Instant.now();
		for (int i = 0; i < n; i++) {
			int j = random.nextInt();
			map.put(i, j);
		}
		Instant end = Instant.now();
		long elapsedMillis = Duration.between(start, end).toMillis();
		double elapsedSeconds = elapsedMillis / 1000.0;
		System.out.println("Time to insert into HashMap is " + elapsedMillis);
	}
	
	public static void treeMapInsertion() {
		Map<Integer, Integer> map = new TreeMap<>();
		Instant start = Instant.now();
		for (int i = 0; i < n; i++) {
			int j = random.nextInt();
			map.put(i, j);
		}
		Instant end = Instant.now();
		long elapsedMillis = Duration.between(start, end).toMillis();
		double elapsedSeconds = elapsedMillis / 1000.0;
		System.out.println("Time to insert into TreeMap " + elapsedMillis);
	}
}
