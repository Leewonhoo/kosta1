package com.kosta.j0803;

import java.util.Random;

public class RandomArrayTest {
	public static void main(String[] args) {
		//�迭 ��ü ���� : �ڷ��� ������[] = new �ڷ���[�迭 ũ��];
		int su[] = new int[5];
		
		A[] arry = new A[3];
		A obj = new A();
		arry[0] = obj;
		arry[1] = new A();
		
		for (int i = 0; i < arry.length; i++) {
			System.out.println(arry[i]);
		}
		arry[1].hello();
		
		//�ڹ� ���� ���� �Լ� : Math~random(),  java.util.Random~next();
		int su2[] = new int[5];
		for(int i=0; i<su2.length; i++) {
			System.out.println(su2[i]);
			su2[i]=(int) (Math.random()*100);   //random�� double �� ����
			System.out.println(su2[i]);
		}
		
		Random r = new Random();
		for (int i = 0; i < su2.length; i++) {
			System.out.println(su2[i]);
			su2[i] = r.nextInt(1000);    //0~999
			System.out.println(su2[i]);
		}
	}
}

class A{
	void hello() {
		System.out.println("�ȳ�~");
	}
}