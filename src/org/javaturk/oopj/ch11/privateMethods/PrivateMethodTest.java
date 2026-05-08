package org.javaturk.oopj.ch11.privateMethods;

public class PrivateMethodTest {

	public static void main(String[] args) {
		Printable printable = new Document();
		printable.print();
		printable.view();
		printable.format();
		
		Printable.startPrinting();
//		Printable.pleaseStartPrinting();
//		Document.startPrinting();

		Document document = new Document();
		document.format();
	}
}
