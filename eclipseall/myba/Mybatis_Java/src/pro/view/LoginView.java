package pro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pro.controller.BlogController;
import pro.model.dto.Blogin;

public class LoginView {
	BufferedReader br;

	public LoginView() {
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
	 * �α��� �� ��� view
	 * </pre>
	 * @param id
	 * @param nick
	 */
	public void logmenu(String id, String nick) {
		BoardmenuView bv = new BoardmenuView();
		BlogController blc = new BlogController();
		
		// �г��� �ҷ�����
		int select = 0;
		do {
			System.out.println("=================================================================");
			System.out.println("\t\t\t\tW ����");
			System.out.println("\t\t\t"+nick+" �� ȯ���մϴ� ~~~");
			System.out.println("=================================================================");
			System.out.println("1. �Խ��� ���");
			System.out.println("2. �Խ��� ���");
			System.out.println("3. �Խñ� ����");
			System.out.println("4. ��������");
			System.out.println("5. �α׾ƿ�");
			System.out.print("���� => ");

			select = input(select);
			switch (select) {
			case 1:
				bv.binputmenu(id, nick);
				break;
			case 2:
				bv.boutmenu(id, nick);
				break;
			case 3:
				bv.bdelmenu(id, nick);
				break;
			case 4:
				bv.bmodmenu(id, nick);
				break;
			case 5:
				System.out.println();
				String a = "O";
				System.out.println(blc.logupdate(a, id));
				return ;
			default: System.out.println("�߸� �����Ͽ����ϴ�.");
			}
		} while (select != 5);
	}

}
