package ch06.sec13.exam01.package2;

import ch06.sec13.exam01.package1.B;

public class C extends Base {
	B b;
//	A a;
	
//	protected C() {
//		
//	}
	
	public static void main(String[] args) {
		
		System.out.println("asdf");
		
		C c = new C();
		
	}

}

class Base {

	protected Base() {
		System.out.println("Base Constructor");
	}
	
}