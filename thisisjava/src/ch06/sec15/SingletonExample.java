package ch06.sec15;

public class SingletonExample {

	public static void main(String[] args) {
		
		System.out.println("main func");
		
		var obj1 = Singleton.getInstance();
		var obj2 = Singleton.getInstance();
		
		System.out.println((obj1 == obj2) + " <- result");
	}

}
