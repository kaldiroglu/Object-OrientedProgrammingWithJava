package org.javaturk.oopj.ch09.flyer;

import java.util.*;

import org.javaturk.oopj.ch09.flyer.driver.*;
import org.javaturk.oopj.ch09.flyer.vehicle.*;

public class FlyerTest {

	public static void main(String[] args) {
		SeaPlane seaPlane = new SeaPlane("Akin's SeaPlane");
		seaPlane.fly();
		seaPlane.floatNow();
		System.out.println(seaPlane.toString());
		
		Floatable floatable = seaPlane;
		floatable.park();

		Airplane airplane = seaPlane;
		airplane.fly();
		airplane.land();

		AbstractVehicle abstractVehicle = seaPlane;
		abstractVehicle.go();
		
		Vehicle vehicle = seaPlane;
		vehicle.turnOn();
		vehicle.toString();
//		vehicle.fly();
		
		Flyer flyer = seaPlane;
		flyer.fly();
		flyer.toString();
		
		Object object = seaPlane;
		object.toString();

////////////////////////////////////////////////////////////////

		Pilot pilot = new Pilot("Akin");
		pilot.drive(seaPlane);   // Vehicle

		Hangar hangar = new Hangar("Macaron's Hangar");
		hangar.store(seaPlane);  // Airplane

		Harbour harbour = new Harbour("Ayvalik Harbour");
		harbour.enter(seaPlane); // Floatable
		
		List list = new ArrayList();
		list.add(seaPlane);	// Object
//
//		UniversalDriver universalDriver = new UniversalDriver("Selim");
//		universalDriver.drive(seaPlane);  // Vehicle
	}
}
