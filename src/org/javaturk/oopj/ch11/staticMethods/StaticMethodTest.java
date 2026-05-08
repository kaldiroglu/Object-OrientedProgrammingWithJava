package org.javaturk.oopj.ch11.staticMethods;

public class StaticMethodTest {

	public static void main(String[] args) {
		Printable printable = new Document();
		printable.print();
		printable.format();
		
		Printable.startPrinting();
		
//		Document.startPrinting();  		// Can't do this!
		SubPrintable.startPrinting();
	}
}
