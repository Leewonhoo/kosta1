package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuNo {

	public MenuNo() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String select="0";
			do {
				System.out.println("===========================");
				System.out.println("��α� �����ϱ� (ver. 1.0)");
				System.out.println("===========================");
				System.out.println("1. �α���");
				System.out.println("2. ����");
				System.out.print("���� => ");
				select = br.readLine();
				switch(select) {
				case "1": 
					LogUi lu = new LogUi();
					br.close();
					break;
				case "2":
					br.close();
					System.exit(0);
					break;
				default:
					select="0";
					System.out.println("�ٽ� �Է����ּ���.");
				}
			}while(select.equals("0"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MenuNo();
	}

}
