package com.kosta.j0817;

import java.io.Serializable;

public class Person implements Serializable{
	//현 클래스를 직렬화로 선언
	String name = "이원호";
	transient int age = 25;           //객체 직렬화시 데이터 전달 X
	String job = "학생";
}
