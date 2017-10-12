package com.kosta.j0817;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			String host="naver.com";
			InetAddress ia = InetAddress.getByName(host);
			
			System.out.println("hostname : "+ia.getHostName());
			System.out.println("hostadd(임시) : "+ia.getHostAddress());
			System.out.println("hostcanoi(직접) "+ia.getCanonicalHostName());
			
			InetAddress[] ias = InetAddress.getAllByName(host);
			for (int j = 0; j < ias.length; j++) {				
				System.out.println("alladd1 : "+ias[j].getHostAddress());
			}
			
			InetAddress[] ias2 = InetAddress.getAllByName("www."+host);
			for (int j = 0; j < ias2.length; j++) {				
				System.out.println("alladd2 : "+ias2[j].getHostAddress());
			}
			
			InetAddress[] ias3 = InetAddress.getAllByName("google.co.uk");
			for (int j = 0; j < ias3.length; j++) {				
				System.out.println("alladd3 : "+ias3[j].getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			System.out.println("host error");
			e.printStackTrace();
		}
	}
}
