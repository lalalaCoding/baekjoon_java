package java_01.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkDemo {
	public static void main(String[] args) {
		try {
			InetAddress inet1 = InetAddress.getByName("www.naver.com");
			System.out.println(inet1.getHostAddress());
			
			InetAddress[] inet2 = InetAddress.getAllByName("www.naver.com");
			for(InetAddress i : inet2) {
				System.out.println(i.toString());
			}
			
			String fqdn = inet1.getCanonicalHostName();
			System.out.println(fqdn);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
