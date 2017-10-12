package com.kosta.j0817;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadTest {
	public static void main(String[] args) {
		ObjectInputStream ois=null;
		Object ob;
		try {
			ois = new ObjectInputStream(new FileInputStream("person.ser"));
			ob = ois.readObject();
			Person p = (Person)ob;
			System.out.println("이름 : "+p.name);
			System.out.println("나이 : "+p.age);
			System.out.println("직업 : "+p.job);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
