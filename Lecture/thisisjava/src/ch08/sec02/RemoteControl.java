package ch08.sec02;

public interface RemoteControl {
	
	int VALUE = 0; // static final, 상수 필드
	
	void turnOn(); // public abstract
	
	default void defaultFunc() {
		System.out.println("Default Method");
	}
	
	
	
}
