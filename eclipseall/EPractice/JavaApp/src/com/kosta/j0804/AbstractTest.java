package com.kosta.j0804;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

abstract class Shape{
	abstract void draw();    //����� �޼ҵ�
}

class Circle extends Shape{
	void draw() {
		System.out.println("���׶��");
	}
}

class Rectangle extends Shape{
	void draw() {
		System.out.println("�׸�");
	}
}

class Triangle extends Shape{
	void draw() {
		System.out.println("����");
	}
}

public class AbstractTest {   //abstract : ����, Ư¡
	public static void main(String args[]) {
		Shape s = new Circle();
		s = new Triangle();
		Shape r = new Rectangle();
		s.draw();  // s�� ������ 2���� �Ǿ����� ���������� �� ���� ����Ų��.
		r.draw();
	}
}