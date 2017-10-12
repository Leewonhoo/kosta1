package com.kosta.j0802;

import java.io.BufferedReader;

class A{
	public A(){
		System.out.println("기본 생성자");
	}
	public A(String a) {
		System.out.println("오버로딩 된 생성자");
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
