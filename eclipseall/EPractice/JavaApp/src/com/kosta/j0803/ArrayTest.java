package com.kosta.j0803;

public class ArrayTest {
	public static void main(String[] args) {
//		                 1��              2��              3��
		int su2[][] = {{11,22},{33,44,55},{66,77,88,99}};
//		               1��    2��      3��   4��     5��   6��
		
		for(int i=0; i<su2.length; i++) {
			for(int j=0; j<su2[i].length; j++) {
				System.out.println("su2["+i+"]["+j+"]�� ��� : "+su2[i][j]);
			}
		}
		
		int[][] su5= new int[3][];
		su5[0]=new int[2];
		su5[1]=new int[1];
		su5[2]=new int[4];
		
		for(int i=0; i<su5.length; i++) {
			for(int j=0; j<su5[i].length; j++) {
				System.out.println("su5["+i+"]["+j+"]="+su5[i][j]);
			}
		}
	}
}
