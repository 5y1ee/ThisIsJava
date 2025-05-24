package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i=0; i<5; ++i)
				{
					toolkit.beep();
					// Runnable 인터페이스에는 getName 메서드가 없음.
//					System.out.println(getName());
					System.out.println("beep");
					try {
						Thread.sleep(500);
					}
					catch (Exception e) {}
				}
			}
		});
		thread.start();
//		thread
		
		Thread thread2 = new Thread(new Beep());
		thread2.start();
		
		Runnable r = new Beep();
		Thread thread3 = new Thread(r);
		thread3.start();
		
		for (int i=0; i<5; ++i)
		{
			System.out.println("dd ");
			try {
				Thread.sleep(500);
			}
			catch (Exception e) {}
		}
		
		Thread th = new Thread() {
			@Override
			public void run() {
				System.out.println(getName());
			}
		};
		th.start();
		
		
	}

}
