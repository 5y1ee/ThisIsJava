package ch02;

public class PrimitiveConvertor {

	public static void main(String[] args) {
		String sInt = "10";
		String sDb = "3.14";
		String sCh = "c";
		String sBool = "true";
		
		int res = 0;
		for (int i=0; i<sInt.length(); ++i)
		{
			res *= 10;
			res += sInt.charAt(i) - '0';
//			System.out.println(sInt.charAt(i));
		}
		System.out.println(res);
		
		double db = 0;
		int flag = 0;
		for (int i=0; i<sDb.length(); ++i)
		{
			char c = sDb.charAt(i);
//			System.out.println("c : " + c);
			
			if (c == '.')
			{
				flag = i;
				continue;
			}
			
			if (flag != 0)
			{
				double val = c-'0';
//				System.out.println("val " + val);
				for (int k=0; k<i-flag; ++k)
				{
					val /= 10;
				}
				db += val;
			}
			// 아직 소숫점 아님
			else
			{
				db *= 10;
				db += c-'0';				
			}
			
//			System.out.println(db);
		}
		System.out.println(db);
		
		
		System.out.println(Integer.parseInt(sInt));
		System.out.println(Double.parseDouble(sDb));
		System.out.println(Boolean.parseBoolean(sBool));
		
		
		

	}

}
