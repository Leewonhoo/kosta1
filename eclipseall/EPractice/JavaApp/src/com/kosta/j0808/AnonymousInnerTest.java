package com.kosta.j0808;

class A{
	void hello() {
		System.out.println("hello");
	}
}

abstract class B{
	abstract void draw();
}

interface C{
	void print();
}


public class AnonymousInnerTest {
	public static void main(String[] args) {
		A a = new A();
		a.hello();
		
		
		// A a = new A() { }   =>  무명의 클래스 body 괄호
		A aa = new A() {
			@Override
			void hello(){    //new A() == class Temp extends A
				System.out.println("anonymous hello~");
				}
			void gile() {
				System.out.println("메소드 정의");
			}
			};
		aa.hello();        //오버라이딩된 메소드만 호출이 가능하다.
//		aa.gile();         //자식 클래스에서 정의한 것은 호출이 불가능하다.
		
		B b = new B() {
			@Override
			void draw() {
				System.out.println("그림");
			}
		};
		
		C c = new C() {
			@Override
			public void print() {
				System.out.println("인터페이스 출력");
			}			
		};
	}
}
