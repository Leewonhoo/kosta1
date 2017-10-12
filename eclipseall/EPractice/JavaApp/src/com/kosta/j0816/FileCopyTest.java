package com.kosta.j0816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopyTest {

	FileInputStream fis, fis3;       //바이트 단위
	FileOutputStream fos, fos3;
	FileReader fr;       //문자 단위
	FileWriter fw;
	BufferedReader br;       //버퍼 단위
	BufferedWriter bw;

	public FileCopyTest() {
		try {
			fis = new FileInputStream("giledong/sub/a.txt");   //FileNotException 자식
			fos = new FileOutputStream("giledong/sub/b.txt");

			long start = System.currentTimeMillis();
			int i;   //IOException 부모
			while((i=fis.read())!=-1) {   //파일 안에 읽은 데이터가 있으면
				fos.write(i);
				//System.out.write(i);
				//System.out.println((char)i);
			}
			fos.close();
			fis.close();
			long end = System.currentTimeMillis();
			System.out.println("복사 성공(바이트 단위) : "+(end-start));
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
			System.out.println("복사 성공(문자 단위) : "+(end-start));
			
			start = System.currentTimeMillis();
			br = new BufferedReader(new FileReader("giledong/sub/aa.txt"));
			bw = new BufferedWriter(new FileWriter("giledong/sub/bbb.txt"));
			
			String str;
			while((str=br.readLine())!=null) {  //읽은 라인이 있을 경우
				bw.write(str);
			}
			end = System.currentTimeMillis();
			bw.close();
			br.close();
			System.out.println("복사 성공(버퍼 단위) : "+(end-start));
			
			
			fis3 = new FileInputStream("giledong/sub/a.txt");   //FileNotException 자식
			fos3 = new FileOutputStream("giledong/sub/bbbb.txt");
			byte[] b = new byte[1024];
			start = System.currentTimeMillis();
			while((i=fis3.read(b))!=-1) {
				fos3.write(b, 0, i);
			}
			fos.close();
			fis.close();
			end = System.currentTimeMillis();
			System.out.println("복사 성공(바이트 단위,배열) : "+(end-start));
			
		}catch(Exception e) {
			System.out.println("복사 실패");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		//FileInputStream fis = new FileInputStream(File file);
		//FileInputStream fis = new FileInputStream(String path);

		new FileCopyTest();
	}
}
