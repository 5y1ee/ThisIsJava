package ch13;

import java.util.ArrayList;
import java.util.List;

import ch08.sec02.Television;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GenericEx {

	public static void main(String[] args) {
		
		
		// List 인터페이스
		// 타입 제한 없음, 가변 길이
		List list = new ArrayList();
		
//		list.add(1);
//		list.add(3.14);
//		list.add("dd");
//		list.add(new Television());
		
		for (var val : list)
		{
			System.out.println(val);
			// list.get(i);
		}
		
		var o1 = new Order("111", "0410", 10000);
		var o2 = new Order("222", "0411", 20000);
		var o3 = new Order("333", "0412", 30000);
		
		list.add(o1);
		list.add(o2);
		list.add(o3);
		
		for (int i=0; i<list.size(); ++i)
		{
			System.out.println(list.get(i));
			System.out.println(((Order)list.get(i)).getDate());
			
		}
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(o1);
		orderList.add(o2);
		orderList.add(o3);
		
		for (int i=0; i<orderList.size(); ++i)
		{
			System.out.println(orderList.get(i).getPrice());
		}
		
		
		
	}

}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Order
{
	private String number;
	private String date;
	private int price;
}



