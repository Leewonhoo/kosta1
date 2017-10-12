package com.kosta.j0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Savename2 {
	Vector<String> name;

	public Savename2() {
		name = new Vector<>();
	}

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
				System.out.println("1.�Է�  2.�˻� 3.���� 4.���� 5.����");
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
			default :
				System.out.println("�߸� �����̽��ϴ�.");
			}
		}
		System.out.println("\n----END----");
	}

	private void insert(String in) {
		if(name.contains(in))
			System.out.println("�ߺ��� �̸��Դϴ�.\n");
		else {
			name.add(in);
			System.out.println("--insert--\n");
		}
	}

	private void select() {
		for(int i=0; i<name.size(); i++) {
			System.out.println("�̸� "+i+"��° : "+name.get(i));
		}
		System.out.println("--select--\n");
	}

	private void update(String sel, String mo) {
		if(name.contains(sel)) {
			name.set(name.indexOf(sel), mo);
			System.out.println("--update--\n");
		}
		else 
			System.out.println("ã�� �̸��� �����ϴ�.\n");
	}

	private void delete(String del) {
		if(name.contains(del)) {
			name.remove(del);
			System.out.println("--delete--\n");
		}
		else
			System.out.println("ã�� �̸��� �����ϴ�.\n");
	}		

}
