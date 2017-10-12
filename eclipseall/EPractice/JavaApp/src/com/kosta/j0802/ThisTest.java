package com.kosta.j0802;

class Abc{
	String str;  //ㅋ르래스 기본값 : null(미정)
	Abc(){  //기본생성자
		this("자바");  //문자열을 매개변수로 정의한 다른 생성자 호출
		System.out.println("Abc 기본생성자");
	}
	Abc(String str){  //오버로딩 생성자
		System.out.println("Abc 오버로딩 생성자");
		this.str=str;
	}
}

public class ThisTest {
	public static void main(String[] args) {
		Abc abc = new Abc();
		System.out.println("str : "+abc.str);
//		abc.str.substring(0);   //nullpointerException  => null값은 없는 값이므로 나누지 못한다.
	}
}