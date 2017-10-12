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
	 * 숫자입력
	 * </pre>
	 * @param num
	 * @return 입력한 숫자
	 */
	private int input(int num) {
		try {
			num = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("== 숫자를 입력해주세요 ==");
		}
		return num;
	}

	/**
	 * <pre>
	 * 문자입력
	 * </pre>
	 * @param str
	 * @return 입력한 문자
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
	 * 로그인 후 목록 view
	 * </pre>
	 * @param id
	 * @param nick
	 */
	public void logmenu(String id, String nick) {
		BoardmenuView bv = new BoardmenuView();
		BlogController blc = new BlogController();
		
		// 닉네임 불러오기
		int select = 0;
		do {
			System.out.println("=================================================================");
			System.out.println("\t\t\t\tW 까페");
			System.out.println("\t\t\t"+nick+" 님 환영합니다 ~~~");
			System.out.println("=================================================================");
			System.out.println("1. 게시판 등록");
			System.out.println("2. 게시판 목록");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 정보변경");
			System.out.println("5. 로그아웃");
			System.out.print("선택 => ");

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
			default: System.out.println("잘못 선택하였습니다.");
			}
		} while (select != 5);
	}

}
