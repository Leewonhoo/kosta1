package com.kosta.j0803;

interface Animal {   //�ٸ� ������ ��� �������̽���.java�� ����
	void walk();
	public abstract void sleep();
	void bark();
}

class Dog implements Animal {
	// Animal �������̽��� ��� �޼ҵ带 Dog�� �����Ѵ�.
	
	public void sleep( ) {
		System.out.println("��");
	}
	public void walk( ) {
		System.out.println("��Ʈ");
	}
	public void bark( ) {
		System.out.println("��");
	}
	public void run( ) {
		System.out.println("��");
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal al;
		al = new Dog();
		al.bark();
		
		Dog d = new Dog();
		d.bark();
	}

}
