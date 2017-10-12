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
				System.out.println("블로그 로그인 후 (ver. 1.0)");
				System.out.println("===========================");
				System.out.print("\t"+id +"님 환영합니다.\t");
				System.out.println("최근 접속일 : 2017/08/28");
				System.out.println("오늘의 방문자 수 : 10 명");
				System.out.println("1. 게시판");
				System.out.println("2. 로그아웃");

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
