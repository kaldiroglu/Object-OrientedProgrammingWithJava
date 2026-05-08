package org.javaturk.oopj.ch11.compatibility;

public class CompatibilityTest {

	public static void main(String[] args) {
		System.out.println();
		FootballPlayer player = new AverageFootballPlayer();
		player.play();
//		player.behaveEthically();
	}
}
