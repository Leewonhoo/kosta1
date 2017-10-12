package com.kosta.j0808;

public class Person {  //자바빈즈(VO, DTO : 관련된 속성을 Person클래스로 묶어 주는 역할
	private int no;
	private String name;
	private int age;
	private String job;
	
	public Person(int no, String name, int age, String job) {
		this.no=no;
		this.name=name;
		this.age=age;
		this.job=job;
	}
	
	//현재 클래스의 현재 상태를 표현
	@Override
	public String toString() {
		return no+" : [" + name + ", " + age + ", " + job + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

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
