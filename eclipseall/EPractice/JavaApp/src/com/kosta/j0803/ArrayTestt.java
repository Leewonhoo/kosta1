package com.kosta.j0803;

import java.util.Arrays;

public class ArrayTestt {
	public static void main(String[] args) {
		int su[] = {1,2,3,4,5};
		
		System.out.println("---------1번 문제---------");
		System.out.print("[");
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]);
			if(i!=(su.length-1)){
				System.out.print(", ");
			}else {
				System.out.println("]");
			}
		}
		System.out.println("\n");
		
		System.out.println("---------2번 문제---------");
		System.out.print("[");
		for (int i = (su.length-1); i >=0; i--) {
			System.out.print(su[i]);
			if(i!=0){
				System.out.print(", ");
			}else {
				System.out.println("]");
			}
		}
		System.out.println("\n");
		
		System.out.println("---------3번 문제---------");
		int su2[][] = {{1}, {1,2},{1,2,3}};
		for (int i = 0; i < su2.length; i++) {
			if(i==(su2[i].length-1)) {
				System.out.print("[ ");
			}
			for (int j = 0; j < su2[i].length; j++) {
				System.out.print("su2["+i+"]["+j+"] = "+su2[i][j]+" ");
			}
			if(i==(su2[i].length-1)){
				System.out.println("]");
			}
		}
		System.out.println();
		
		System.out.println("---------4번 문제---------");
		
		int[] su3 = new int[su.length];    //su3에게 su의 값을 복사
		for (int i = 0; i < su.length; i++) {
		su3[i] = su[i];
		}
		
//		int[] su4 = Arrays.copyOf(su, su.length);    //라이브러리를 이용한 값 복사
		
//		int su3[];
//		su3=su;        // su3에게 su의 주소 값 전달
		

		for (int i = 0; i < su3.length; i++) {
			System.out.print("su3["+i+"]\t");
		}
		System.out.println();
		for (int i = 0; i < su3.length; i++) {
			System.out.print("  "+su3[i]+"\t");
		}
		System.out.println("\n");
		
		System.out.println("---------5번 문제---------");
		Arrays.sort(su,0,su.length);
		int temp;
		for (int i=0, j=su.length-1; i<su.length/2; i++, j--) {
					temp=su[i];
					su[i]=su[j];
					su[j]=temp;			
		}
		
		System.out.print("[");
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i]);
			
			if(i!=su.length-1) {
				System.out.print(", ");
			}else {
				System.out.println("]");
			}
		}
		
		
	}

}
