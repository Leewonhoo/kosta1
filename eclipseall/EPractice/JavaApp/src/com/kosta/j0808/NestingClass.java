package com.kosta.j0808;

class NestingClassTest {
	void hello() {
		System.out.println("Hello~~");
	}
	void callTest() {
		NestedClass nc = new NestedClass();
		nc.print();
	}
	
	class NestedClass{
		void print() {
			System.out.println("내부클래스 print 메소드");
		}
		void callTest() {
			hello();
		}
	}
}
public class NestingClass{
	public static void main(String[] args) {
		NestingClassTest nct = new NestingClassTest();
		nct.hello();
		
		NestingClassTest.NestedClass ncc = new NestingClassTest().new NestedClass();
		ncc.print();
	}
}