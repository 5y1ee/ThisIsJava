package ch06.sec04;

public class Student {
	
	static int num;
	int privateNum;
	public Student()
	{
		++num;
		privateNum = num;
	}
	
	public void Func()
	{
		System.out.println("Num:"+privateNum);
	}
}
