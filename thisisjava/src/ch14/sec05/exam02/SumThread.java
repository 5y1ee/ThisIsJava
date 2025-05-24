package ch14.sec05.exam02;

import lombok.Data;

@Data
public class SumThread extends Thread {
	private long sum;
	
	@Override
	public void run() {
		for (int i=0; i<100; ++i)
			sum+=i;
		System.out.println(getName());
	}
}
