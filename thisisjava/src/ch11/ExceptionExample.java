package ch11;

public class ExceptionExample {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 0;
		
		int[] ary = {1,2,3};

		String str = null;
		
		try {
			System.out.println(a/b);
			ary[3] = 0;
			str.charAt(b);
		}
		catch (ArithmeticException e)
		{
			System.out.println(e);
			System.out.println(e.toString());
			return;
		}
		catch (NullPointerException e)
		{
			
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			System.out.println("항상 실행");
			
			try {
				test();
			}
			catch(Exception e) {}
			
		}
		
	}
	
	
	public static void test() throws Exception {
		
		Class.forName("java.lang.String");
		
		
	}
	
	
	
}
