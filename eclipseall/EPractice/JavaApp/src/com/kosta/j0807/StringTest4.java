package com.kosta.j0807;

public class StringTest4 {
	public static void main(String[] args) {
		//�ܺ� �����Ϳ� ���� ��ȿ�� �˻�
		String str = args[0];
		
		int su1 = Integer.parseInt(args[0]);
		int su2 = 100;
		
		String suPattern = "[0-9]+";
		
		System.out.println(su1+su2);
		System.out.println(str.matches(suPattern));   //str.matches(String regex);   //regex ���� ����
		
		if(str.matches(suPattern)) {
			System.out.println(su1+su2);
		}else {
			System.out.println("�߸� �Է�");
		}
		
		System.out.println("==================");
		String juminP = "[\\d]{6}-[\\d]{7}";      //[0-9]{6}-[0-9]{7} �� ����.
		String jumin = "930212-1542312";
		System.out.println("�ֹι�ȣ �˻� : "+jumin.matches(juminP));
	}
}
