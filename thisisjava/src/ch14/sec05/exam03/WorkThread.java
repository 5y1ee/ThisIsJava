package ch14.sec05.exam03;

public class WorkThread extends Thread{
	
	boolean work = true;
	
	public WorkThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while (true)
		{
			if (work) {
				System.out.println(getName());
			} else
				Thread.yield();
		}
	}

}
