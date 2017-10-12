package com.kosta.j0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraySortTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[5];
		int temp;

		System.out.println("���ڸ� �Է��ϼ���.");
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1)+"��° �� : ");
			/*arr[i]=System.in.read()-48;    //���ڸ��� �Է�
			System.in.read();
			System.in.read();*/
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println();
		
		System.out.println("�Էµ� �迭");
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("]\n");

		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}			
		}

		System.out.println("���ĵ� �迭");
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
		
		
		int[] su2 = {22,33,44,11,66,55};
		char[] ch = {'v', 'b', 'd', 'e', 'j'};
		String[] str = {"ȫ�浿", "�ֿ�", "�����", "������"};
		
		Arrays.sort(su2);
		Arrays.sort(ch);
		Arrays.sort(str);
		
		for (int i = 0; i < su2.length; i++) {
			System.out.print(su2[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+" ");
		}

	}

}
