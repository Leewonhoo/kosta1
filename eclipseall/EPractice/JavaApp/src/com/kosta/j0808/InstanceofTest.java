package com.kosta.j0808;

class D{
	int i=11;
}
class E extends D{
	int j=22;
}
class F extends E{
	int k=33;
}

public class InstanceofTest {
	public static void main(String[] args) {
		//instanceof type => boolean ���
		D d=new D();
		E e=new E();
		F f=new F();
		
		if(d instanceof D) {
			System.out.println("d�� Ŭ���� D�� ��ü�̴�.");
		}else {
			System.out.println("d�� Ŭ���� D�� ��ü�� �ƴϴ�.");			
		}
		
		if(d instanceof F) {
			System.out.println("d�� Ŭ���� F�� ��ü�̴�.");
		}else {
			System.out.println("d�� Ŭ���� F�� ��ü�� �ƴϴ�.");			
		}
		if(f instanceof D) {
			System.out.println("f�� Ŭ���� D�� ��ü�̴�.");
		}else {
			System.out.println("f�� Ŭ���� D�� ��ü�� �ƴϴ�.");			
		}
		
		int su=25;
		String result = (su%2==0) ? "����" : "����" ;
		System.out.println("���׿����� ��� : "+result);
	}
}
