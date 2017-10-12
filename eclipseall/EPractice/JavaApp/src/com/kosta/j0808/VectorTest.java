package com.kosta.j0808;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector/*<Object>*/ v = new Vector/*<Object>*/(5,3);  //��ũ��, �����ϴ� ����
		System.out.println("������ ��ũ�� : "+v.capacity());
		System.out.println("������ ��Ұ��� : "+v.size());
		
		for(int i=0; i<10; i++) {
			v.addElement(new Integer(i));
		}
		
		System.out.println("������ ��ũ�� : "+v.capacity());
		//3���� �����ϱ� ������ ��ũ��� 11�� ��µȴ�.
		System.out.println("������ ��Ұ��� : "+v.size());
		
		v.addElement(new Double(3.12));
		v.addElement(new Double(4.23));		
		v.addElement(new String("���"));
		
		System.out.println("������ ��ũ�� : "+v.capacity());
		//3���� �����ϱ� ������ ��ũ��� 14�� ��µȴ�.
		System.out.println("������ ��Ұ��� : "+v.size());
		
		System.out.println("���� ù��� : "+v.firstElement());
		System.out.println("���� ������ ��� : "+v.lastElement());
		System.out.println("���Ϳ� ���� Ȯ�� : "+v.contains(new Double(3.14)));
		
		//������ �������̽�
		Enumeration enu = v.elements();
		
		while(enu.hasMoreElements()) {
			System.out.println("���� ��� : "+enu.nextElement());
		}
	}
}
