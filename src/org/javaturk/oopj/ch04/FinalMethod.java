package org.javaturk.oopj.ch04;

/**
 * @author <a href="mailto:akin@javaturk.org">Akin Kaldiroglu</a>
 *         <p>
 *         For more info please
 * @see <a href="http://www.javaturk.org">http://www.javaturk.org</a>
 * @see <a href="http://www.selsoft.com.tr">http://www.selsoft.com.tr</a>
 *      </p>
 */
public class FinalMethod{

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.f();
		parent.g();

		Child child = new Child();
		child.f();
		child.g();
	}
}

class Parent{
	
	public final void f() {
		System.out.println("f() in Parent");
	}
	
	public static final void sf() {
		System.out.println("sf() in Parent");
	}

	public void g() {
		System.out.println("g() in Parent");
	}
}

class Child extends Parent {

//	Can't override a final method!
//	 public void f() {
//		 System.out.println("f() in Child");
//	 }

//		Can't hide a final method!
//	public static final void sf() {
//		System.out.println("sf() in Parent");
//	}

	@Override
	final public void g() {
		String s;
		System.out.println("g() in Child");
	}
}

class ChildOfChild extends Child {
	
//	@Override
//	public final void g() {
//		String s;
//		System.out.println("g() in ChildOfChild");
//	}
}

class ChildOfChildOfChild extends ChildOfChild {

//	Can't override a final method!
//	@Override
//	public final void g() {
//		String s;
//		System.out.println("g() in ChildOfChildOfChild");
//	}
}
