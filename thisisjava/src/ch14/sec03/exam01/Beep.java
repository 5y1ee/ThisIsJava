package ch14.sec03.exam01;

import java.awt.Toolkit;

public class Beep implements Runnable {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i<5; ++i)
		{
			toolkit.beep();
			// 얘도 Runnable implements라서 getName 못함.
//			getName();
			System.out.println("beep");
			try {
				Thread.sleep(500);
			}
			catch (Exception e) {}
		}
	}

}
