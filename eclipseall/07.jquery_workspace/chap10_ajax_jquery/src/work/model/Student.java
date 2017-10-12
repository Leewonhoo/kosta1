package work.model;

import java.io.Serializable;

public class Student implements Serializable {
	private int roll;
	private String name;
	private int marks;

	public void setRoll(int roll) { this.roll = roll; }
	public int getRoll() { return roll; }

	public void setName(String name) { this.name = name; }
	public String getName() { return name; }

	public void setMarks(int marks) { this.marks = marks; }
	public int getMarks() { return marks; }

	public Student(){}
	public Student(int roll, String name, int marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return roll + ":" + name +":"+ marks;
	}
}
