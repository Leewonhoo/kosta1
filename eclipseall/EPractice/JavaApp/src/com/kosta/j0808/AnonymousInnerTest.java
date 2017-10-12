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
		
		
		// A a = new A() { }   =>  ������ Ŭ���� body ��ȣ
		A aa = new A() {
			@Override
			void hello(){    //new A() == class Temp extends A
				System.out.println("anonymous hello~");
				}
			void gile() {
				System.out.println("�޼ҵ� ����");
			}
			};
		aa.hello();        //�������̵��� �޼ҵ常 ȣ���� �����ϴ�.
//		aa.gile();         //�ڽ� Ŭ�������� ������ ���� ȣ���� �Ұ����ϴ�.
		
		B b = new B() {
			@Override
			void draw() {
				System.out.println("�׸�");
			}
		};
		
		C c = new C() {
			@Override
			public void print() {
				System.out.println("�������̽� ���");
			}			
		};
	}
}
