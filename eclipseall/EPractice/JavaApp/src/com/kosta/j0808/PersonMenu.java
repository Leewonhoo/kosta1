package com.kosta.j0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class PersonMenu {
	Vector<Person> memo;

	public PersonMenu() {
		//������ Ư�� : �ٸ� �޼ҵ庸�� ���� ����Ǹ� �ѹ� ����ȴ�.
		memo = new Vector<>();
	}

	public void smain() throws Exception {
		boolean auto = true;
		while(auto) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int select;
			String na1, na2, na3;
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
				System.out.print("������ �Է��ϼ��� : ");
				na2=br.readLine();
				System.out.print("������ �Է��ϼ��� : ");
				na3=br.readLine();
				insert(na1, na2, na3);
				break;
			case 2:
				select();
				break;
			case 3:
				System.out.print("������ ��ȣ�� �Է��ϼ��� : ");
				na1=br.readLine();
				System.out.print("������ ������ �Է��ϼ��� : ");
				na2=br.readLine();
				System.out.print("������ ������ �Է��ϼ��� : ");
				na3=br.readLine();
				update(na1, na2, na3);
				break;
			case 4:
				System.out.print("������ ��ȣ�� �Է��ϼ��� : ");
				na1=br.readLine();
				delete(na1);
				break;
			case 5:
//				return;
				auto=false;
				break;
			default :
				System.out.println("�߸� �����̽��ϴ�.");
			}
		}
		System.out.println("\n----END----");
	}

	private void insert(String name, String age, String job) {
		int num = 1;
		int nai;
		for(int i=0; i<memo.size(); i++) {
			Person sel = memo.get(i);
			num=sel.getNo();
			num+=1;
		}		
		nai=Integer.parseInt(age);
		memo.add(new Person(num, name, nai, job));
		System.out.println("--insert--\n");
	}

	private void select() {
		int num, age;
		String name, job;
		System.out.println("��ȣ : [�̸�, ����, ����]");

		/*for(int i=0; i<memo.size(); i++) {
			Object sel = memo.get(i);
			num=((Person)sel).getNo();
			name=((Person)sel).getName();
			age=((Person)sel).getAge();
			job=((Person)sel).getJob();
			System.out.println(num+": ["+name+", "+age+", "+job+"]");
		}*/
		/*for(int i=0; i<memo.size(); i++) {
		 * // <element>�� ���������Ƿ� ������ ���� ��� ����.
			Person sel=memo.get(i);
			num=sel.getNo();
			name=sel.getName();
			age=sel.getAge();
			job=sel.getJob();
			System.out.println(num+": ["+name+", "+age+", "+job+"]");
		}*/
		
		for(int i=0; i<memo.size(); i++) {
			//Person�� �������̵� toString�̿�
			System.out.println(memo.get(i).toString());
		}
		
		System.out.println("--select--\n");
	}

	private void update(String num, String age, String job) {
		int no;
		int com = Integer.parseInt(num);
		String nn, jj;
		int nai=Integer.parseInt(age);
		for(int i=0; i<memo.size(); i++) {
			Object sel = memo.get(i);
			no=((Person)sel).getNo();
			if(com==no) {
				nn=((Person)sel).getName();
				memo.set(i, new Person(no, nn, nai, job));
				System.out.println("--update--\n");
				return;
			}
			/*if(com==no) {
				Person aa = memo.get(i);
				aa.setAge(nai);
				aa.setJob(job);
				System.out.println("--update--\n");
				return;
			}*/
		}		
		System.out.println("ã�� ��ȣ�� �����ϴ�.\n");
	}

	private void delete(String del) {
		int num;
		int com = Integer.parseInt(del);
		for(int i=0; i<memo.size(); i++) {
			Object sel = memo.get(i);
			num=((Person)sel).getNo();
			if(com==num) {
				memo.remove(memo.get(i));
				System.out.println("--delete--\n");
				return;
			}
		}
		System.out.println("ã�� ��ȣ�� �����ϴ�.\n");
	}
}
