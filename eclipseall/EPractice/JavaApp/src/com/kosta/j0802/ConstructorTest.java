package com.kosta.j0802;

import java.io.BufferedReader;

class A{
	public A(){
		System.out.println("�⺻ ������");
	}
	public A(String a) {
		System.out.println("�����ε� �� ������");
	}
	void hello() {
		System.out.println("Aclass Hello~~");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		A aa = new A("a");
		a.hello();
		
		String s = new String();
//		BufferedReader br = new BufferedReader();
	}

}
