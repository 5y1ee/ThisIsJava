package ch08.sec02;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();	// 자동형변환
		rc.turnOn();
		
		
		// 익명객체
//		RemoteControl rc2 = new RemoteControl(); // Interface는 객체 생성 불가
		RemoteControl rc2 = new RemoteControl() {
			public void turnOn() {
				System.out.println("Anonymous turn on.");
			}
		};
		rc2.turnOn();
		
		
		cal(new LambdaEX() {
			@Override
			public int calc(int x, int y)
			{
				return x * y;
			}
		});
		
		cal((x, y) -> {
			return x - y;
		});
		
	}
	
	
	
	public static void cal(LambdaEX ex)
	{
//		int res = ex.calc(10, 5);
//		System.out.println(res);
		System.out.println(ex.calc(10, 5));
	}
	
}
