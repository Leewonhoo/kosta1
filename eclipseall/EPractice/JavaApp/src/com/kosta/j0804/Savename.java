package com.kosta.j0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Savename {
	//	static String[] name = {"null", "null", "null", "null", "null"};
	static String[] name = new String[5];

	public void smain() throws Exception {
		boolean auto = true;
		while(auto) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int select;
			String na1, na2;
			boolean cc = false;
			String input="null";
			
			do {
				System.out.println("---�޴��� �����ϼ���---");
				System.out.println("1.�Է�  2.�˻� 3.���� 4.���� 5.���� 6.����Ȱ���");
				System.out.print("���� =>");
				input = br.readLine();

				cc = input.matches("[0-9]");
			}while(!cc);
			
			select = Integer.parseInt(input);
			
			switch(select) {
			case 1:
				System.out.print("�̸��� �Է��ϼ��� : ");
				na1=br.readLine();
				insert(na1);
				break;
			case 2:
				select();
				break;
			case 3:
				System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
				na1=br.readLine();
				System.out.print("������ �̸��� �Է��ϼ��� : ");
				na2=br.readLine();
				update(na1, na2);
				break;
			case 4:
				System.out.print("������ �̸��� �Է��ϼ��� : ");
				na1=br.readLine();
				delete(na1);
				break;
			case 5:
				auto=false;
				break;
			case 6:
				System.out.println("���� ����� �̸��� ���� : "+count()+"\n");
				break;
			default :
				System.out.println("�߸� �����̽��ϴ�.");
			}
		}
		System.out.println("----END----");
	}

	private void insert(String in) {
		for(int i=0; i<name.length; i++) {

			//			if(!name[name.length-1].equals("null")) {
			if(name[name.length-1]!=null) {
				System.out.println("���� ������ �����մϴ�.");
				System.out.println("�ٸ� �̸��� ���� �� �Է��ϼ���.");
				break;
			}

			//			if(name[i].equals("null")) {
			if(name[i]==null) {
				name[i]=in;
				for(int j=0; j<i; j++) {
					if(name[j].equals(in)) {
						System.out.println("�̸��� �ߺ� �˴ϴ�.");
						name[i]=null;
						break;
					}
				}
				break;
			}
		}
		System.out.println("--insert--\n");		
	}

	private void select() {
		for(int i=0; i<name.length; i++) {
			//			if(name[i].equals("null"))
			if(name[i]==null)
				continue;
			System.out.println("�̸� : "+name[i]);
		}
		System.out.println("--select--\n");
	}

	private void update(String sel, String mo) {
		
		/*for(int i=0; i<name.length; i++) {              //compare �޼ҵ� ������� ����
			if(name[i]==null) {                               // (1)
				if(i==(name.length-1)) {
					System.out.println("��ġ�ϴ� �̸��� �����ϴ�.\n");
					break;
				}
				continue;
			}
			else if(name[i].equals(sel)) {
				name[i]=mo;
				System.out.println("--update--");
				break;
			}
			else{
				if(i==(name.length-1)) {
					System.out.println("��ġ�ϴ� �̸��� �����ϴ�.\n");
					break;
				}
			}
			
			//			if(name[i]!=null&&name[i].equals(sel)) {        // &&�� �̿��� ��� (2)
			//				name[i]=mo;
			//				System.out.println("--update--");
			//				break;
			//			}else{
			//				if(i==(name.length-1)) {
			//					System.out.println("��ġ�ϴ� �̸��� �����ϴ�.\n");
			//					break;
			//				}
			//				continue;
			//			}

			// �ٸ� ��� (3)
			//			if(sel.equals(name[i])) {                   // ���� ����.equls�� ���� null ���� ���� �ʴ´�.
			//				name[i]=mo;
			//				System.out.println("--update--");
			//				break;
			//			}else {
			//				if(i==(name.length-1)) {
			//					System.out.println("��ġ�ϴ� �̸��� �����ϴ�.\n");
			//				}
			//				continue;
			//			}
		}*/
		
		int num = compare(sel);
		if(num==(name.length+1)) {
			return ;
		}else {
			name[num]=mo;
			System.out.println("--update--\n");
		}
	}

	private void delete(String del) {
		/*for(int i=0; i<name.length; i++) {
			if(del.equals(name[i])) {
//				name[i]="null";
				name[i]=null;
				System.out.println("--delete--");
				break;
			}
		}*/
		
		int num = compare(del);              //compare�޼ҵ带 ����� ���
		if(num==(name.length+1)) {
			return ;
		}else {		
			name[num]=null;
			System.out.println("--delete--\n");
		}
	}

	private int compare(String sel) {         // �迭�� �̸� ã�� �޼ҵ�
		int num = 0;
		for (int i = 0; i < name.length; i++) {
			if(sel.equals(name[i])) {
				System.out.println("�̸��� �����մϴ�.");
				return i;
			}
			else {
				if(i==(name.length-1)) {
					System.out.println("�̸��� �������� �ʽ��ϴ�.\n");
					break;
				}
			}
		}
		return (name.length+1);
	}

	private int count() {             // �迭�� �̸� ���� �ľ��ϴ� �޼ҵ�
		int num=0;
		for(int i=0; i<name.length; i++) {
			if(name[i]!=null)
				num++;
		}
		return num;		
	}

}
