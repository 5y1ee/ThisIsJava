package ch16.sec05.exam01;

public class Person {
	public void action(Calculable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println(result);
	}
}
