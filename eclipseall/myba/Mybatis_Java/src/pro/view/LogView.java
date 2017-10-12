package pro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pro.controller.BmemberController;
import pro.model.dto.Bmember;

public class LogView {
	BufferedReader br;

	public LogView() {
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
	 * ȸ������ view
	 * </pre>
	 */
	public void register() {
		BmemberController bc = new BmemberController();
		boolean check = false;
		int select = 0;
		String id = null;
		String pw = null;
		String name = null;
		String nick = null;
		String birth = null;
		String phone = null;
		String mail = null;
		String gender = null;
		String address = null;
		String answer = null;
		System.out.println("=================================================================");
		System.out.println("\t\t\t || ȸ������ ||");
		System.out.println("=================================================================");
		while (!check) {
			System.out.println("* : �ʼ�");
			System.out.print("*���̵�(4~6��) : ");
			id = input(id);
			System.out.print("���̵� �ߺ� �˻� ��� =>");
			check = bc.idcheck(id);
		}
		System.out.print("*��й�ȣ(6~10��) : ");
		pw = input(pw);
		System.out.print("*�̸�(7�ڳ�) : ");
		name = input(name);
		while (check) {
			System.out.print("*�г���(2~10��) : ");
			nick = input(nick);
			System.out.print("�г��� �ߺ� �˻� ��� =>");
			check = bc.nickcheck(nick);
		}
		System.out.print("*������� : ");
		birth = input(birth);
		System.out.print("�޴���(-����) : ");
		phone = input(phone);
		System.out.print("�̸���(15�ڳ�) : ");
		mail = input(mail);
		System.out.print("*����(M/F) : ");
		gender = input(gender);
		System.out.print("�ּ�(20�ڳ�) : ");
		address = input(address);
		System.out.println("( ���� : ���� ������� ������? )");
		System.out.print("*�亯(25�ڳ�) : ");
		answer = input(answer);

		System.out.println("�Է��� ������ ȸ�������Ͻðڽ��ϱ�?");
		System.out.println("1. ȸ������  |  2. ���");
		System.out.print("���� => ");
		select = input(select);
		switch (select) {
		case 1:
			Bmember bmem = new Bmember(id, pw, name, nick, birth, phone, mail, gender, address, 1, answer);
			System.out.println(bc.memberinsert(bmem));
			return;
		case 2:
			return;
		default:
			System.out.println("�߸� �����Ͽ����ϴ�. �޴��� ���ư��ϴ�.");
			return;
		}
	}
	
	/**
	 * <pre>
	 * ID/PW ã�� view
	 * </pre>
	 */
	public void search() {
		BmemberController bc = new BmemberController();
		int select = 0;
		String id = null;
		String name = null;
		String birth = null;
		String answer = null;
		System.out.println("1. IDã��  |  2. PWã��  |  3.���");
		System.out.print("���� => ");
		select = input(select);
		switch (select) {
		case 1:
			System.out.println("IDã��");
			System.out.print("�̸��� �Է��ϼ��� => ");
			name = input(name);
			System.out.print("��������� �Է��ϼ��� => ");
			birth = input(birth);
			System.out.print("���� : ���� ������� ������ => ");
			answer = input(answer);
			Bmember bmem = new Bmember();
			bmem.setmName(name);
			bmem.setmBirth(birth);
			bmem.setmAnswer(answer);
			String result = bc.memberid(bmem);
			if (result != null) {
				System.out.println("���̵�� "+result+"�Դϴ�.\n");
			}
			break;
		case 2:
			System.out.println("PWã��");
			System.out.print("ID�� �Է��ϼ��� => ");
			id = input(id);
			System.out.print("�̸��� �Է��ϼ��� => ");
			name = input(name);
			System.out.print("��������� �Է��ϼ��� => ");
			birth = input(birth);
			System.out.print("���� : ���� ������� ������ => ");
			answer = input(answer);
			Bmember bmem1 = new Bmember();
			bmem1.setmId(id);
			bmem1.setmName(name);
			bmem1.setmBirth(birth);
			bmem1.setmAnswer(answer);
			String result1 = bc.memberpw(bmem1);
			if (result1 != null) {
				System.out.println("��й�ȣ�� "+result1+"�Դϴ�.\n");
			}
			break;
		case 3:
			System.out.println("�޴��� ���ư��ϴ�.");
			break;
		default: System.out.println("�߸� �����Ͽ����ϴ�.");
		}
	}
	
}
