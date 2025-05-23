package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		
		var s23 = new SmartPhone("Galaxy", "Black");
		
		s23.bell();
		s23.sendVoice();
		s23.receiveVoice();
		s23.hangUp();
		
		s23.setWifi(true);
		s23.internet();
		
		
		// 자동형변환
		Phone p1 = new SmartPhone("d", "f");
		
		// 강제형변환 (부모->자식)
		SmartPhone p2 = (SmartPhone)p1;
		p2.internet(); // 사용가능
		
		// 
//		Phone p3 = new Phone();
//		SmartPhone p4 = (SmartPhone)p3;
//		p4.internet(); // 런타임에러
		
		// 나중가면 spring이 객체를 만들어서 이런 런타임 에러가 나는 경우를 조심해야.
		
		
		Object o1 = new String("d456465 _ ");
		String s1 = (String)o1;
//		s1.replace(0, 0);
		System.out.println(o1 + s1);

		Object o2 = new Object();
		String s2 = (String)o2;
		// 둘 다 런타임에러
//		System.out.println(s2);
//		System.out.println(o2);
		
	}

}


abstract class Temp {
	
	public abstract void func();
	
}


