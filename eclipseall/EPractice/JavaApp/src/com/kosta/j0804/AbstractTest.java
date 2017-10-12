package com.kosta.j0804;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

abstract class Shape{
	abstract void draw();    //선언된 메소드
}

class Circle extends Shape{
	void draw() {
		System.out.println("동그라미");
	}
}

class Rectangle extends Shape{
	void draw() {
		System.out.println("네모");
	}
}

class Triangle extends Shape{
	void draw() {
		System.out.println("세모");
	}
}

public class AbstractTest {   //abstract : 선언, 특징
	public static void main(String args[]) {
		Shape s = new Circle();
		s = new Triangle();
		Shape r = new Rectangle();
		s.draw();  // s에 선언이 2가지 되었지만 마지막으로 된 곳을 가리킨다.
		r.draw();
	}
}