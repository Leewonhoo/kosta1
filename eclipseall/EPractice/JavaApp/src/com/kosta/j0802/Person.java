package com.kosta.j0802;

public class Person {  //�ڹ� ���� : ���� ���ü� �ִ� �Ӽ��� ������ Ŭ����
	//��� �ʵ� ����
	private String name;
	private int age;
	private String job;
	
	//�����ڸ� �̿��� ���
	public Person() {
		
	}
	
	public Person(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}

	//�޵��带 �̿��� ���
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
