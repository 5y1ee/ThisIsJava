package ch12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringEx {

	public static void main(String[] args) {
		
		
		String mga = "Mrs.Motoki";
		System.out.println(mga.substring(mga.indexOf(".")+1));
		
		System.out.println(mga.toUpperCase());
		
		String wb = "   s s m y ...";
		System.out.println(wb.trim());
		System.out.println(wb.replace(" ", ""));
		
		System.out.println(mga.startsWith("Mrs"));
		System.out.println(mga.endsWith("ki"));
		
		
		int a = 11;
		String s = String.valueOf(a);
		System.out.println(s);
		Object o = s;
		s = (String)o;
		System.out.println(s);
		
		
		String fileName = "2025.04.10_시간표.xlsx";
		System.out.println(System.currentTimeMillis());
		String newFileName = String.valueOf(System.currentTimeMillis()) + fileName.substring(fileName.indexOf(".xlsx"));
		System.out.println(newFileName);
		
		var d = fileName.split("\\.");
//		System.out.println(d.getClass().getName());
		System.out.println(d[0]);
		
		StringBuilder sb = new StringBuilder();
		sb.append(d.toString()).append("ff").append(123);
		String tmp = sb.toString();
		System.out.println(tmp);
		
		System.out.println(d.toString()+"\n"+d);
		
		Date now = new Date();
		System.out.println(now.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(now));
		
		
	}

}
