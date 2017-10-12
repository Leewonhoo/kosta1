package com.kosta.j0802;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("이원호");
		p.setAge(25);
		p.setJob("학생");
		
		Person pp = new Person("leewonho", 25, "student");
		
		System.out.println("이름 : "+p.getName());
		System.out.println("나이 : "+p.getAge());
		System.out.println("직업 : "+p.getJob()+"\n");
		System.out.println("이름 : "+pp.getName());
		System.out.println("나이 : "+pp.getAge());
		System.out.println("직업 : "+pp.getJob());
	}
}
