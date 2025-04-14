package ch06.sec15;

public class Singleton {
	
	{
		System.out.println("Instance Block of Singleton");
	}
	
	// static은 미리 메모리에 올라감..
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("Singleton constructor");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}

}
