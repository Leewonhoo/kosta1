package com.kosta.j0802;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("�̿�ȣ");
		p.setAge(25);
		p.setJob("�л�");
		
		Person pp = new Person("leewonho", 25, "student");
		
		System.out.println("�̸� : "+p.getName());
		System.out.println("���� : "+p.getAge());
		System.out.println("���� : "+p.getJob()+"\n");
		System.out.println("�̸� : "+pp.getName());
		System.out.println("���� : "+pp.getAge());
		System.out.println("���� : "+pp.getJob());
	}
}
