package com.kosta.j0802;

public class Person {  //자바 빈즈 : 서로 고나련성 있는 속성을 정의한 클래스
	//멤버 필드 정의
	private String name;
	private int age;
	private String job;
	
	//생성자를 이용한 방법
	public Person() {
		
	}
	
	public Person(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}

	//메도드를 이용한 방법
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
