package org.javaturk.oopj.ch01.composition;

public class Test {
	
	public static void main(String[] args) {
		Car car = new Car("Mercedes Benz", "CLK 200", "2013", 2);
		car.start();
		car.go(1000);
		car.accelerate(100);
		car.stop();
		car.turnOff();
	}
}
