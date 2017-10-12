package com.kosta.j0803;

interface Animal {   //다른 파일일 경우 인터페이스명.java로 저장
	void walk();
	public abstract void sleep();
	void bark();
}

class Dog implements Animal {
	// Animal 인터페이스의 모든 메소드를 Dog에 구현한다.
	
	public void sleep( ) {
		System.out.println("쿨");
	}
	public void walk( ) {
		System.out.println("볼트");
	}
	public void bark( ) {
		System.out.println("멍");
	}
	public void run( ) {
		System.out.println("빵");
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
