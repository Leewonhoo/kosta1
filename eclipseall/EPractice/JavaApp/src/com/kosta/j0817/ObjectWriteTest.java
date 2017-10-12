package com.kosta.j0817;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {
	public static void main(String[] args) {
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
			oos.writeObject(new Person());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
