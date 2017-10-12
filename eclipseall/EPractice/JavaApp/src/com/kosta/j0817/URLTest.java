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
			System.out.println("프로토콜 : "+url.getProtocol());
			System.out.println("호스트 pc : "+url.getHost());
			System.out.println("서비스파일명 : "+url.getFile());
			System.out.println("서비스 경로 : "+url.getPath());
			
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //콘솔 read
			//BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream("경로")));  //파일 read
			BufferedReader ur = new BufferedReader(
					new InputStreamReader(url.openStream(),"UTF-8"));  //url read
			                                                //decoder => 깨짐 방지
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
