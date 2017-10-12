package com.kosta.j0816;

public class StringGetBytes {
	public static void main(String[] args) {
		String str = "Hi, your name is wonho";
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.write(b[i]);
			if(i%3==2)System.out.write('\n');
		}
//		System.out.flush();
		System.out.close();
	}
}
