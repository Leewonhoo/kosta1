package com.kosta.j0807;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		
		String tel = "010-123-4567";

		StringTokenizer st = new StringTokenizer(tel, "-");

		while(st.hasMoreTokens()){
			System.out.println("tel tokenizer ��� : "+st.nextToken());
		}
			
		
		String[] tels = tel.split("-");
		for (int i = 0; i < tels.length; i++) {
			System.out.println("tels split �̿� : "+ tels[i]);
		}
		
		System.out.println("\n=============================\n");
		
		String phone = "010--1452";
		
		StringTokenizer stt = new StringTokenizer(phone, "-");
		while(stt.hasMoreTokens())
			System.out.println("phone tokenizer ��� : "+stt.nextToken());
		
		String[] ph = phone.split("-");
		for(int j=0; j<ph.length; j++){
			System.out.println("phone split ��� : "+ph[j]);
		}
		
	}
}
