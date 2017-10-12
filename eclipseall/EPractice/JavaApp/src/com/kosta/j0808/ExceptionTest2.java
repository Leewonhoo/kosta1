package com.kosta.j0808;

public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		System.out.println("매개변수로 받은 두개의 정수 값");
		System.out.println("su1 : "+su1+", su2 : "+su2);
		System.out.println(su1+"/"+su2+"="+(su1/su2));		
		}catch(Exception e){        // (Throwable e)
			System.out.println("# 모든 예외 처리 : "+e);
		}/*catch(NumberFormatException e) {
			System.out.println("# int형 변수를 입력하세요 : "+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("# 모두 입력해주세요 : "+e);
		}catch(ArithmeticException e) {
			System.out.println("# 0으로 나눌 수 없습니다 : "+e.toString());
		}*/finally {
			System.out.println("===END===END===END===END===END===END===");
		}
	}
}
