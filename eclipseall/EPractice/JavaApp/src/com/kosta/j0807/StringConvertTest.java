package com.kosta.j0807;

public class StringConvertTest {
	
	public void convert1() {
		String s1="우리나라";
		String s2="대한민국 만세!!";
		s1+=s2;
		System.out.println(s1);
	}
	
	public void convert2() {
		StringBuffer s1 = new StringBuffer("우리나라");
		s1.append("대한민국 만세!!");
		System.out.println(s1);
	}
	
	public static void main(String[] args) {
		StringConvertTest sct = new StringConvertTest();
		sct.convert1();
		sct.convert2();
	}
}
