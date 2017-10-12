package com.kosta.j0808;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("I:\\ho\\EPractice\\JavaApp\\aa.txt");
			//FileReader fr = new FileReader("a.txt");
			//경로를 생략하고 파일명만 쓰는 것은 이클립스의 자바에서만 가능하다.
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException fne) {
			System.out.println("파일을 찾지 못했습니다.");
			System.out.println(fne.toString());
			System.out.println(fne);
			System.out.println(fne.getMessage());  //에러메시지만 출력
			fne.printStackTrace();   //자세한 에러메시지 출력
		} catch(IOException e) {
			System.out.println("파일을 읽지 못했습니다.");
			e.printStackTrace();
		}
	}
}
