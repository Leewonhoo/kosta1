package com.kosta.j0808;

public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		System.out.println("�Ű������� ���� �ΰ��� ���� ��");
		System.out.println("su1 : "+su1+", su2 : "+su2);
		System.out.println(su1+"/"+su2+"="+(su1/su2));		
		}catch(Exception e){        // (Throwable e)
			System.out.println("# ��� ���� ó�� : "+e);
		}/*catch(NumberFormatException e) {
			System.out.println("# int�� ������ �Է��ϼ��� : "+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("# ��� �Է����ּ��� : "+e);
		}catch(ArithmeticException e) {
			System.out.println("# 0���� ���� �� �����ϴ� : "+e.toString());
		}*/finally {
			System.out.println("===END===END===END===END===END===END===");
		}
	}
}
