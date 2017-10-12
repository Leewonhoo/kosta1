package com.kosta.j0804;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto {

	public static void main(String[] args) {
		Random ran = new Random();
		int[][] arr = new int[5][6];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ran.nextInt(45)+1;              // 1~45 ����
				for(int k=0; k<j; k++) {                    // ������ ���� ���� �� �ߺ� ����
					while(arr[i][j]==arr[i][k]) {
						arr[i][j] = ran.nextInt(45)+1;
					}
				}
			}
			System.out.println();
		}		
		
		System.out.println("�ڡڱ��� ����� �ζ� ��ȣ�ڡ�");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+(i+1)+"ȸ : ");
			Arrays.sort(arr[i]);                               //�迭 ����
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d", arr[i][j]);
				if(j!=arr[i].length-1) {                       //���� ���̿� , �ֱ�
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

}
