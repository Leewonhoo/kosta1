package com.kosta.j0816;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		//File f = new File(String pathname);
		File f = new File("./a.txt");        //���� ����� a.txt
		System.out.println("f.exists() : "+f.exists());
		System.out.println("f.isDirectory() : "+f.isDirectory());
		System.out.println("f.isFile() : "+f.isFile()+"\n\n");
		
		System.out.println("f.getPath() : "+f.getPath());
		System.out.println("f.getAbsolutePath() : "+f.getAbsolutePath());
		System.out.println("f.getCanonicalPath() : "+f.getCanonicalPath()+"\n\n");
		
		System.out.println("f.getName() : "+f.getName());
		System.out.println("f.getParent() : "+f.getParent());
		
		
		//JaveApp/gildong/sub
		String path = "giledong/sub";
		String fileName = "baby.jpg";
		File f4 = new File(path);
		
		if(f4.exists()) {
			System.out.println("���� O");
			FileOutputStream fos = new FileOutputStream(path+"/"+fileName);  //�� �̹��� ����
			fos.close();
			
			f4.delete();
		}else {
			System.out.println("���� X");
			f4.mkdirs();
		}
		
		System.out.println("f4���� : "+f4.exists());

		
	}
}
