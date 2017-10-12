package com.kosta.j0818;

public class StringSplitTest {
	public static void main(String[] args) {
		String data = "ȫ �浿,�����, ���ֿ�";
		String names[] = data.split(",");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		System.out.println("\n================");
		String data2 = "ȫ �浿|�����| ���ֿ�";
		String names2[] = data2.split("\\|");
		for (int i = 0; i < names2.length; i++) {
			System.out.println(names2[i]);
		}
		
	}
}
