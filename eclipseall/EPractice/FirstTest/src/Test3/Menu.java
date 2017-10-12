package Test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	Management ma;

	public Menu() throws IOException {
		ma = new Management();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int select=0;
		
		ma.load();

		do {
			System.out.println("### �ʱ�ȭ ������ �߰� ##\n");
			System.out.println("## -------------------");
			System.out.println("## ��ȭ��ȣ�� ���θ޴�");
			System.out.println("## -------------------");
			System.out.println(" 1. ��ȭ��ȣ ���");
			System.out.println(" 2. ��ȭ��ȣ ��ü��ȸ");
			System.out.println(" 3. ��ȭ��ȣ ����ȸ");
			System.out.println(" 4. ��ȭ��ȣ ����");
			System.out.println(" 5. ��ȭ��ȣ ����");
			System.out.println("98. ��ȭ��ȣ ���� �� ����");
			System.out.println("99. ��ȭ��ȣ ����");
			System.out.println("## -------------------");
			System.out.print("[�޴���ȣ �Է�] : ");
			
			try {
				select = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("���ڷ� �Է����ּ���.\n\n");
				continue;
			}

			switch(select) {
			case 1:
				
				System.out.println("## -------------------");
				System.out.println("## ��ȭ��ȣ ���");
				System.out.println("## -------------------");
				System.out.print("�̸� : ");
				String name = br.readLine();
				System.out.print("��ȣ : ");
				String phone = br.readLine();
				System.out.print("�ּ� : ");
				String add = br.readLine();
				ma.insert(name, phone, add);
				System.out.println("## -------------------");
				System.out.println("[Message] : ȸ����� �Ϸ�Ǿ����ϴ�.\n");
				break;
			case 2:
				System.out.println("## -------------------");
				System.out.println("## ��ȭ��ȣ ��ü��ȸ");
				System.out.println("## -------------------");
				ma.print();
				System.out.println("## -------------------\n");
				break;
			case 3:
				System.out.println("## -------------------");
				System.out.println("## ��ȭ��ȣ ����ȸ");
				System.out.println("## -------------------");
				System.out.print("�̸� : ");
				String name1 = br.readLine();
				ma.serarch(select, name1);
				System.out.println("## -------------------\n");
				break;
			case 4:
				System.out.println("## -------------------");
				System.out.println("## ��ȭ��ȣ ����");
				System.out.println("## -------------------");
				System.out.print("�̸� : ");
				String name2 = br.readLine();
				ma.serarch(select, name2);
				System.out.println("[Message] : ȸ������ �Ϸ�Ǿ����ϴ�.\n");
				break;
			case 5:
				System.out.println("## -------------------");
				System.out.println("## ��ȭ��ȣ ����");
				System.out.println("## -------------------");
				System.out.print("�̸� : ");
				String name3 = br.readLine();
				ma.serarch(select, name3);
				System.out.println("[Message] : ȸ������ �Ϸ�Ǿ����ϴ�.\n");
				break;
			case 98:				
				System.out.println("## -------------------");
				System.out.println("## -------------------");
				ma.save();
				System.out.println("## -------------------");
				System.out.println("## ���� ������ ���α׷��� ���� �����մϴ�.");
				System.out.println("## -------------------");
				return;
			case 99:
				System.out.println("## -------------------");
				System.out.println("## ���α׷��� ���� �����մϴ�.");
				System.out.println("## -------------------");
				return;
			default:
				System.out.println("�ٽ� �Է����ּ���.\n\n");
			}
		}while(select!=99);
		br.close();
	}

}
