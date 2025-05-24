package ch19.sec02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("localhost");
			for (InetAddress remote : iaArr) {
				System.out.println("naver : " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
