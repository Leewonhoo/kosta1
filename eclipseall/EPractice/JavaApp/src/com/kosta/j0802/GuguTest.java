package com.kosta.j0802;

import java.io.IOException;

public class GuguTest {

	public static void main(String[] args) throws IOException {
		char con='y';
		while(con=='y'||con=='Y') {
			Gugudan gugu = new Gugudan();
			gugu.danOutput(gugu.danInput());
			con = gugu.danContinue();
		}
		System.out.println("프로그램 종료");
	}

}
