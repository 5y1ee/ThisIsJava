package ch16.sec05.exam01;

import java.util.Arrays;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		
		person.action(Computer::staticMethod);
		
		Computer com = new Computer();
		person.action(com::instanceMethod);
		
		int[] arr = {1,2,3};
		Integer[] arr4 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		
		
	}

}
