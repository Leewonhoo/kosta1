package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuYes {

	public MenuYes(String id) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String select="0";

		try {
			do {
				System.out.println("===========================");
				System.out.println("��α� �α��� �� (ver. 1.0)");
				System.out.println("===========================");
				System.out.print("\t"+id +"�� ȯ���մϴ�.\t");
				System.out.println("�ֱ� ������ : 2017/08/28");
				System.out.println("������ �湮�� �� : 10 ��");
				System.out.println("1. �Խ���");
				System.out.println("2. �α׾ƿ�");

				select = br.readLine();

				switch(select) {
				case "1":
					break;
				case "2":
					MenuNo mn = new MenuNo();
					break;
				default:
				}

			}while(select.equals("0"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MenuYes("asd");
	}

}
