package com.kosta.j0816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyTest {

	FileInputStream fis, fis3;       //����Ʈ ����
	FileOutputStream fos, fos3;
	FileReader fr;       //���� ����
	FileWriter fw;
	BufferedReader br;       //���� ����
	BufferedWriter bw;

	public FileCopyTest() {
		try {
			fis = new FileInputStream("giledong/sub/a.txt");   //FileNotException �ڽ�
			fos = new FileOutputStream("giledong/sub/b.txt");

			long start = System.currentTimeMillis();
			int i;   //IOException �θ�
			while((i=fis.read())!=-1) {   //���� �ȿ� ���� �����Ͱ� ������
				fos.write(i);
				//System.out.write(i);
				//System.out.println((char)i);
			}
			fos.close();
			fis.close();
			long end = System.currentTimeMillis();
			System.out.println("���� ����(����Ʈ ����) : "+(end-start));
			//System.out.flush();
			
			start = System.currentTimeMillis();
			fr = new FileReader("giledong/sub/a.txt");
			fw = new FileWriter("giledong/sub/bb.txt");
			while((i=fr.read())!=-1) {
				fw.write(i);
			}
			fw.close();
			fr.close();
			end = System.currentTimeMillis();
			System.out.println("���� ����(���� ����) : "+(end-start));
			
			start = System.currentTimeMillis();
			br = new BufferedReader(new FileReader("giledong/sub/aa.txt"));
			bw = new BufferedWriter(new FileWriter("giledong/sub/bbb.txt"));
			
			String str;
			while((str=br.readLine())!=null) {  //���� ������ ���� ���
				bw.write(str);
			}
			end = System.currentTimeMillis();
			bw.close();
			br.close();
			System.out.println("���� ����(���� ����) : "+(end-start));
			
			
			fis3 = new FileInputStream("giledong/sub/a.txt");   //FileNotException �ڽ�
			fos3 = new FileOutputStream("giledong/sub/bbbb.txt");
			byte[] b = new byte[1024];
			start = System.currentTimeMillis();
			while((i=fis3.read(b))!=-1) {
				fos3.write(b, 0, i);
			}
			fos.close();
			fis.close();
			end = System.currentTimeMillis();
			System.out.println("���� ����(����Ʈ ����,�迭) : "+(end-start));
			
		}catch(Exception e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		//FileInputStream fis = new FileInputStream(File file);
		//FileInputStream fis = new FileInputStream(String path);

		new FileCopyTest();
	}
}
