package ch06.sec04;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		s1.Func();
		s2.Func();
		
		Student s3 = s1;
		s3.Func();
		
	}

}
