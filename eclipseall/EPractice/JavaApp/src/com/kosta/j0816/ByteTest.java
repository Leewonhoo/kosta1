package com.kosta.j0816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteTest {
	FileInputStream fis;
	FileOutputStream fos;

	public ByteTest() throws FileNotFoundException {
		fis = new FileInputStream("giledong/sub/a.txt");
		fos = new FileOutputStream("giledong/sub/bbb.txt");
		byte[] b = new byte[1024];
		
	}
	
	public static void main(String[] args) {
	}
}
