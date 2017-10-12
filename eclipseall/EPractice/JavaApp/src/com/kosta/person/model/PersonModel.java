package com.kosta.person.model;

import java.io.Serializable;
import java.util.Vector;

public class PersonModel implements Serializable{
	
	private int num;
	private String name;
	private int age;
	private String job;
	public int getNum() {
		return num;
	}
	
	public PersonModel() {
		
	}
	
	public PersonModel(int num, String name, int age, String job) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	public PersonModel(int age, String job) {
		this.age = age;
		this.job = job;
	}
	
	public void setNum(int num) {
		this.num = num;
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
