package com.kosta.j0802;

class Abc{
	String str;  //�������� �⺻�� : null(����)
	Abc(){  //�⺻������
		this("�ڹ�");  //���ڿ��� �Ű������� ������ �ٸ� ������ ȣ��
		System.out.println("Abc �⺻������");
	}
	Abc(String str){  //�����ε� ������
		System.out.println("Abc �����ε� ������");
		this.str=str;
	}
}

public class ThisTest {
	public static void main(String[] args) {
		Abc abc = new Abc();
		System.out.println("str : "+abc.str);
//		abc.str.substring(0);   //nullpointerException  => null���� ���� ���̹Ƿ� ������ ���Ѵ�.
	}
}