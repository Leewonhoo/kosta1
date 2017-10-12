package pro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import pro.controller.BboardController;
import pro.model.dto.Bboard;
import pro.model.dto.Bmember;

public class BoardmenuView {
	BufferedReader br;
	BboardController bbc;

	public BoardmenuView() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * <pre>
	 * �����Է�
	 * </pre>
	 * @param num
	 * @return �Է��� ����
	 */
	private int input(int num) {
		try {
			num = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("== ���ڸ� �Է����ּ��� ==");
		}
		return num;
	}

	/**
	 * <pre>
	 * �����Է�
	 * </pre>
	 * @param str
	 * @return �Է��� ����
	 */
	private String input(String str) {
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * <pre>
	 * �Խ��� ��� view
	 * </pre>
	 * @param id
	 * @param nick
	 */
	public void binputmenu(String id, String nick) {
		bbc = new BboardController();
		String title = null;
		String memo = null;
		String pw = null;
		String tag = null;

		System.out.println("=================================================================");
		System.out.println("\t\t\t\tW ����");
		System.out.println("\t\t\t"+nick+" �� ȯ���մϴ� ~~~");
		System.out.println("=================================================================");
		System.out.println("1. �Խ��� ���");

		System.out.print("���� : ");
		title = input(title);
		System.out.println("���� : ");
		memo = input(memo);
		System.out.print("��й�ȣ : ");
		pw = input(pw);
		System.out.print("�±� : ");
		tag = input(tag);

		Bboard bb = new Bboard();
		bb.setbId(id);
		bb.setbNick(nick);
		bb.setbTitle(title);
		bb.setbMemo(memo);
		bb.setbPw(pw);
		bb.setbTag(tag);

		String result = bbc.boardinsert(bb);
		System.out.println(result);
	}

	/**
	 * <pre>
	 * �Խñ� ���� view
	 * </pre>
	 * @param id
	 * @param nick
	 */
	public void bdelmenu(String id, String nick) {
		bbc = new BboardController();
		int num = 0;
		String memo = null;
		String pw = null;
		String tag = null;

		System.out.println("=================================================================");
		System.out.println("\t\t\t\tW ����");
		System.out.println("\t\t\t"+nick+" �� ȯ���մϴ� ~~~");
		System.out.println("=================================================================");
		System.out.println("====  �Խñ� ����  ====");

		System.out.print("�Խñ� ��ȣ : ");
		num = input(num);
		System.out.print("�Խñ� ��й�ȣ : ");
		pw = input(pw);

		Bboard bb = new Bboard();
		bb.setbNick(nick);
		bb.setbNum(num);
		bb.setbPw(pw);

		String result = bbc.boarddelete(bb);
		System.out.println(result);
	}

	/**
	 * <pre>
	 * ���� ���� ��ȸ
	 * </pre>
	 * @param id
	 * @param nick
	 */
	public void bmodmenu(String id, String nick) {
		bbc = new BboardController();
		int select = 0;
		int num = 0;
		String memo = null;
		String pw = null;
		String tag = null;

		System.out.println("=================================================================");
		System.out.println("\t\t\t\tW ����");
		System.out.println("\t\t\t"+nick+" �� ȯ���մϴ� ~~~");
		System.out.println("=================================================================");
		System.out.println("====  ���� ����  ====");

		Bboard bb = new Bboard();
		bb.setbId(id);
		bb.setbNick(nick);
		String st[] = bbc.bmeminfor(bb).split(",");

		System.out.println("=================================================================");
		System.out.println("\t\t\t\t|  ȸ�� ���� ��ȸ ���  |");
		System.out.println("=================================================================");
		System.out.print("���̵� : "+st[0]+"\t");
		System.out.print("��й�ȣ : "+st[1]+"\t");
		System.out.println("�̸� : "+st[2]);
		System.out.print("�г��� : "+st[3]+"\t");
		System.out.print("������� : "+st[4]+"\t");
		System.out.println("�޴��� : "+st[5]);
		System.out.print("�̸��� : "+st[6]+"\t");
		System.out.print("���� : "+st[7]+"\t");
		System.out.println("�ּ� : "+st[8]);
		System.out.println("���� : ���� ������� ������?");
		System.out.println("�亯 : "+st[9]);
		System.out.println("=================================================================");
		System.out.println("�����Ͻðڽ��ϱ�?");
		while ((select != 1) || (select != 2)) {
			System.out.println("1.����\t2.���");
			select = input(select);
			switch(select) {
			case 1:
				bmodinfor(id, nick);
				return;
			case 2:
				return ;
			default: System.out.println("�߸� �����Ͽ����ϴ�. �ٽ� �������ּ���.");
			}
		}
	}

	/**
	 * <pre>
	 * �������� ����
	 * </pre>
	 * @param id
	 * @param nick
	 */
	private void bmodinfor(String id, String nick) {      //�������� ����
		bbc = new BboardController();
		Bmember bb = new Bmember();
		LoginView lv = new LoginView();
		boolean check = false;
		int select = 0;
		String str = null;
		System.out.print("*��й�ȣ(6~10��) : ");
		bb.setmPw(input(str));
		while (!check) {
			System.out.print("*�г���(2~10��) : ");
			bb.setmNick(input(str));
			System.out.print("�г��� �ߺ� �˻� ��� =>");
			check = bbc.nickcheck(id, bb.getmNick());
		}

		bb.setmId(id);
		System.out.print("*������� : ");
		bb.setmBirth(input(str));
		System.out.print("�޴���(-����) : ");
		bb.setmPhone(input(str));
		System.out.print("�̸���(15�ڳ�) : ");
		bb.setmMail(input(str));
		System.out.print("*����(M/F) : ");
		bb.setmGender(input(str));
		System.out.print("�ּ�(20�ڳ�) : ");
		bb.setmAddress(input(str));
		System.out.println("���� : ���� ������� ������?");
		System.out.print("*�亯(25�ڳ�) : ");
		bb.setmAnswer(input(str));

		System.out.println("�Է��� ������ �����Ͻðڽ��ϱ�?");
		System.out.println("1. ����  |  2. ���");
		System.out.print("���� => ");
		select = input(select);
		switch (select) {
		case 1:
			System.out.println(bbc.bmemupdate(bb));
			nick = bb.getmNick();
			System.out.println(bbc.bnickupdate(id, nick));
			lv.logmenu(id, nick);
			break;
		case 2:
			return;
		default:
			System.out.println("�߸� �����Ͽ����ϴ�. �޴��� ���ư��ϴ�.");
			return;
		}
	}
	
	/**
	 * �Խñ� ��� view
	 * @param id
	 * @param nick
	 */
	public void boutmenu(String id, String nick) {
		BoardmenuView bv = new BoardmenuView();
		int num = 0;
		int select = 0;
		do {
			System.out.println("=================================================================");
			System.out.println("\t\t\t\tW ����");
			System.out.println("\t\t\t"+nick+" �� ȯ���մϴ� ~~~");
			System.out.println("=================================================================");
			System.out.println("1. �Խ��� ��ü ��ȸ");
			System.out.println("2. �Խ��� ���� �ۼ��� ���");
			System.out.println("3. �Խñ� �� ����");
			System.out.println("4. �Խñ� ����");
			System.out.println("5. ����");
			System.out.print("���� => ");

			select = input(select);
			switch (select) {
			case 1:
				boutAll();//�Խ��� ��ü ��� UI
				break;
			case 2:
				boutmy(nick);
				break;
			case 3:
				System.out.print("��ȸ�� �Խñ� ��ȣ �Է� : ");
				num = input(num);
				bdetail(num);
				break;
			case 4:
				bdelmenu(id, nick);
				break;
			case 5:
				System.out.println();
				return ;
			default: System.out.println("�߸� �����Ͽ����ϴ�.");
			}
		} while (select != 5);
	}

	/**
	 * <pre>
	 * �Խñ� ��ü ��� view
	 * </pre>
	 */
	private void boutAll() {
		bbc = new BboardController();
		int num = 1;
		int page = 1;
		int line = 1;
		System.out.println("�Խ��� ���");
		do {
			ArrayList al = bbc.boardselectAll(num);
			if (al == null) {
				System.out.println("\n����� �����ϴ�.");
			} else {
				System.out.println("   ��ȣ | �� ��ȣ |    �г���    |     ��¥     |   �湮�ڼ�   |             ����");
				Iterator str = al.iterator();
				while(str.hasNext()) {
					String st[] = str.next().toString().split(",");
					System.out.printf("  %1d", (line++));
					System.out.printf("  %7s", st[1].trim());
					System.out.printf("\t%-11s", st[0].trim());
					System.out.printf("  %13s", st[3].trim());
					System.out.printf("  %4s", st[4].trim());
					System.out.printf("\t\t%-25s\n", st[2].trim());
				}
			}
			line = 1;
			int last = bbc.boardLast();
			if (num == 1) {
				System.out.println("=================================================================");
				System.out.println("| 2.�޴�  | 3.����  | 4.���뺸��");
			} else if (num*5+1 > last) {
				System.out.println("=================================================================");
				System.out.println("1.����  | 2.�޴�  | 4.���뺸��");
			} else {
				System.out.println("=================================================================");
				System.out.println("1.����  | 2.�޴�  | 3.����  | 4.���뺸��");
			}
			System.out.print("���� => ");
			page = input(page);
			switch (page) {
			case 1:
				if (num == 1) {
					num = 1;
					System.out.println("�ּ� ������ �Դϴ�.\n");
				} else {
					num--;
				}
				break;
			case 2:
				break ;
			case 3:
				if (num*5+1 < last) {
					num++;
				} else {
					System.out.println("�ִ� ������ �Դϴ�.\n");
				}
				break;
			case 4:
				System.out.print("��ȸ�� �Խñ� ��ȣ �Է� : ");
				num = input(num);
				bdetail(num);
				break;
			default:
				System.out.println("�߸� �����Ͽ����ϴ�. �޴��� ���ư��ϴ�.");
				return;
			}			
		} while (page != 2);
	}

	/**
	 * <pre>
	 * ���� ���� view
	 * </pre>
	 * @param nick
	 */
	private void boutmy(String nick) {
		System.out.println("��������");
		bbc = new BboardController();
		int num = 1;
		int page = 1;
		int line = 1;
		System.out.println("���� �ۼ��� �Խ��� ���");
		do {
			ArrayList al = bbc.boardselectmy(num, nick);
			if (al == null) {
				System.out.println("\n����� �����ϴ�.");
			} else {
				System.out.println("   ��ȣ | �� ��ȣ |    �г���    |     ��¥     |   �湮�ڼ�   |             ����");
				Iterator str = al.iterator();
				while(str.hasNext()) {
					String st[] = str.next().toString().split(",");
					System.out.printf("  %1d", (line++));
					System.out.printf("  %7s", st[1].trim());
					System.out.printf("\t%-11s", st[0].trim());
					System.out.printf("  %13s", st[3].trim());
					System.out.printf("  %4s", st[4].trim());
					System.out.printf("\t\t%-25s\n", st[2].trim());
				}
			}
			line = 1;
			int last = bbc.boardLast();
			if (num == 1) {
				System.out.println("=================================================================");
				System.out.println("| 2.�޴�  | 3.����  | 4.���뺸��");
			} else if (num*5+1 > last) {
				System.out.println("=================================================================");
				System.out.println("1.����  | 2.�޴�  | 4.���뺸��");
			} else {
				System.out.println("=================================================================");
				System.out.println("1.����  | 2.�޴�  | 3.����  | 4.���뺸��");
			}
			System.out.print("���� => ");
			page = input(page);
			switch (page) {
			case 1:
				if (num == 1) {
					num = 1;
					System.out.println("�ּ� ������ �Դϴ�.\n");
				} else {
					num--;
				}
				break;
			case 2:
				break ;
			case 3:
				if (num*5+1 < last) {
					num++;
				} else {
					System.out.println("�ִ� ������ �Դϴ�.\n");
				}
				break;
			case 4:
				System.out.print("��ȸ�� �Խñ� ��ȣ �Է� : ");
				num = input(num);
				bdetail(num);
				break;
			default:
				System.out.println("�߸� �����Ͽ����ϴ�. �޴��� ���ư��ϴ�.");
				return;
			}			
		} while (page != 2);
	}
	
	/**
	 * <pre>
	 * �Խ��� ���γ��� view
	 * </pre>
	 * @param num
	 */
	public void bdetail(int num) {
		bbc = new BboardController();
		bbc.bvisitup(num);
		ArrayList al = bbc.bbetail(num);
		System.out.println("=================================================================");
		System.out.println("\t\t\t�� ��ȸ");
		System.out.println("=================================================================");
		if (al == null) {
			System.out.println("��ȸ����� �������� �ʽ��ϴ�.");
			return ;
		}
		System.out.printf("  ���� : %26s\t|", al.get(1));
		System.out.printf("  ��¥ : %3s\n", al.get(3));
		System.out.printf("  �۾��� : %26s\t|", al.get(0));
		System.out.printf("  �湮�� �� : %4s\n", al.get(4));
		System.out.printf("  �±� : %250S\n", al.get(5));
		System.out.println("=================================================================");
		System.out.printf("%s\n", al.get(2));
		System.out.println("=================================================================\n\n");
	}

}
