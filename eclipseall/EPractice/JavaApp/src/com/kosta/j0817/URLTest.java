package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		OutputStreamWriter oos=null;
		try {
			URL url = new URL("https://www.naver.com/index.html");
			System.out.println("�������� : "+url.getProtocol());
			System.out.println("ȣ��Ʈ pc : "+url.getHost());
			System.out.println("�������ϸ� : "+url.getFile());
			System.out.println("���� ��� : "+url.getPath());
			
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //�ܼ� read
			//BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream("���")));  //���� read
			BufferedReader ur = new BufferedReader(
					new InputStreamReader(url.openStream(),"UTF-8"));  //url read
			                                                //decoder => ���� ����
			oos = new OutputStreamWriter(new FileOutputStream("index.html"),"UTF-8");
			String str;
			char ch[] = new char[512];
			while((str=ur.readLine())!=null) {
				oos.write(str);
				System.out.println(str);
			}
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
