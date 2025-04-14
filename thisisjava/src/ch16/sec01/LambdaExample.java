package ch16.sec01;

public class LambdaExample {
	public static void main(String[] args) {
		action((x, y) -> {
			int result = x + y;
			System.out.println("res:"+result);
		});

	
		action((x, y) -> {
			int result = x - y;
			System.out.println("res:"+result);
		});
		
		
		
	}
	
	
	public static void action(Calculable calculable) {
		// Data
		int x = 10;
		int y = 4;
		
		// Data progress
		calculable.calculate(x, y);
	}
	
	// 익명 구현 객체가 담긴 것
	public static Calculable cal = (x, y) -> {
		int result = x-y;
		System.out.println(result);
	};
	
	// return
	public static Calculable get() {
		return (x,y) -> {
			
			
		}
	}
	
	
	
	
}
