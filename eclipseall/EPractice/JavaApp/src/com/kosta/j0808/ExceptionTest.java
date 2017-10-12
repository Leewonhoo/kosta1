package com.kosta.j0808;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("I:\\ho\\EPractice\\JavaApp\\aa.txt");
			//FileReader fr = new FileReader("a.txt");
			//��θ� �����ϰ� ���ϸ� ���� ���� ��Ŭ������ �ڹٿ����� �����ϴ�.
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException fne) {
			System.out.println("������ ã�� ���߽��ϴ�.");
			System.out.println(fne.toString());
			System.out.println(fne);
			System.out.println(fne.getMessage());  //�����޽����� ���
			fne.printStackTrace();   //�ڼ��� �����޽��� ���
		} catch(IOException e) {
			System.out.println("������ ���� ���߽��ϴ�.");
			e.printStackTrace();
		}
	}
}
