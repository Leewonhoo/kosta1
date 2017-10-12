package com.kosta.j0808;

public class MyExceptionTest {
	public static void main(String[] args) {
		int su = 3;
		
		if(su%2==1) {
			try {
				throw new OddException("홀수 예외발행");
			} catch (OddException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
