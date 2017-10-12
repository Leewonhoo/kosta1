package com.kosta.j0808;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector/*<Object>*/ v = new Vector/*<Object>*/(5,3);  //방크기, 증가하는 갯수
		System.out.println("벡터의 방크기 : "+v.capacity());
		System.out.println("벡터의 요소갯수 : "+v.size());
		
		for(int i=0; i<10; i++) {
			v.addElement(new Integer(i));
		}
		
		System.out.println("벡터의 방크기 : "+v.capacity());
		//3개씩 증가하기 때문에 방크기는 11이 출력된다.
		System.out.println("벡터의 요소갯수 : "+v.size());
		
		v.addElement(new Double(3.12));
		v.addElement(new Double(4.23));		
		v.addElement(new String("잡아"));
		
		System.out.println("벡터의 방크기 : "+v.capacity());
		//3개씩 증가하기 때문에 방크기는 14이 출력된다.
		System.out.println("벡터의 요소갯수 : "+v.size());
		
		System.out.println("벡터 첫요소 : "+v.firstElement());
		System.out.println("벡터 마지막 요소 : "+v.lastElement());
		System.out.println("벡터에 포함 확인 : "+v.contains(new Double(3.14)));
		
		//열거형 인터페이스
		Enumeration enu = v.elements();
		
		while(enu.hasMoreElements()) {
			System.out.println("벡터 요소 : "+enu.nextElement());
		}
	}
}
