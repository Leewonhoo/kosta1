package com.kosta.j0807;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "java";
		String s2 = "JAVA";
		
		if(s1.equals(s2))
			System.out.println("�����ϴ�");
		else
			System.out.println("�ٸ��ϴ�.");
		
		System.out.println("=======================");
		
		if(s1.equalsIgnoreCase(s2))
			System.out.println("���ڿ� ����");
		else
			System.out.println("���ڿ� �ٸ�");
		
		System.out.println("=======================");
		
		String str = "Java Programming";
		//index =>    0123456789012345
		//                      111111
		System.out.println("���ڿ� ��� : "+str);                               //���ڿ� ���
		System.out.println("���ڿ� ���� : "+str.length());                      //���ڿ� ����
		System.out.println("�빮�� ��ȯ : "+str.toUpperCase());                 //�빮�� ��ȯ
		System.out.println("�ҹ��� ��ȯ : "+str.toLowerCase());                 //�ҹ��� ��ȯ
		System.out.println("���ڿ� ��ü : "+str.replace('a', 'c'));             //���ڿ� ��ü
		System.out.println("���ڿ� ��ü : "+str.replaceAll("Java", "�ڹ�"));
		System.out.println("���ڿ� �������� : "+str.charAt(2));                  //���� ��������
		System.out.println("���ڿ� �ε������� : "+str.indexOf('P'));              //�ε��� ��������
		System.out.println("���ڿ� �ߺ� ù��° �ε��� : "+str.indexOf('a',1));       //�ε��� 1 ����
		System.out.println("���ڿ� �ߺ� �ι�° �ε��� : "+str.indexOf('a',2));       //�ε��� 2 ����
		System.out.println("���ڿ� ������ �ε��� ��� : "+str.lastIndexOf('a'));
		System.out.println("���ڿ� �κ���� : "+str.substring(4));               //�ε��� 4���� ���
		System.out.println("���ڿ� �κ���� : "+str.substring(str.indexOf('a',1)));
		System.out.println("���ڿ� �κ���� : "+str.substring(str.indexOf('a',2)));
		str="   "+str;
		System.out.println("�߰��� ���ڿ� Ȯ�� : "+str);
		System.out.println("�߰��� ���ڿ� ���� Ȯ�� : "+str.length());
		System.out.println("���ʿ� ���� ���� ���� : "+str.trim().length());
		System.out.println("���ʿ� ���� ���� : "+str.trim());                     //���ʿ� ���� ���� (�� �ڸ� ����)
	}

}
