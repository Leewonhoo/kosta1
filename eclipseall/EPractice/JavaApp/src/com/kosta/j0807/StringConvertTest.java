package com.kosta.j0807;

public class StringConvertTest {
	
	public void convert1() {
		String s1="�츮����";
		String s2="���ѹα� ����!!";
		s1+=s2;
		System.out.println(s1);
	}
	
	public void convert2() {
		StringBuffer s1 = new StringBuffer("�츮����");
		s1.append("���ѹα� ����!!");
		System.out.println(s1);
	}
	
	public static void main(String[] args) {
		StringConvertTest sct = new StringConvertTest();
		sct.convert1();
		sct.convert2();
	}
}
