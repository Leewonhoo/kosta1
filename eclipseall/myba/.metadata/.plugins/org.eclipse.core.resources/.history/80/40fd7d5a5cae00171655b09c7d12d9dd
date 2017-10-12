package pro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pro.controller.BlogController;
import pro.controller.BmemberController;
import pro.model.dto.Blogin;

public class Menu {
	
	BufferedReader br;
	LogView lv;
	
	public Menu() {
		br = new BufferedReader(new InputStreamReader(System.in));
		lv = new LogView();
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
	 * 로그인 전 메인 view
	 * </pre>
	 */
	public void menu() {
		int select = 0;
		while(select!=4) {
			System.out.println("=================================================================");
			System.out.println("\t\t\t\tW 까페");
			System.out.println("=================================================================");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. ID/PW 찾기");
			System.out.println("4. 종료");
			System.out.print("선택 => ");

			select = input(select);
			switch (select) {
			case 1:
				login();
				break;
			case 2:
				lv.register();
				break;
			case 3:
				lv.search();
				break;
			case 4:
				System.exit(0);
			default: System.out.println("잘못 선택하였습니다.");
			}
		}
		return ;
	}
	
	/**
	 * <pre>
	 * 로그인 view
	 * </pre>
	 */
	public void login() {
		BmemberController bc = new BmemberController();
		BlogController blc = new BlogController();
		LoginView lv = new LoginView();
		String id = null;
		String pw = null;
		System.out.println("\n\n=================================================================");
		System.out.println("\t\t\t || 로그인 ||");
		System.out.println("=================================================================");
		System.out.print("아이디 : ");
		id = input(id);
		System.out.print("비밀번호 : ");
		pw = input(pw);
		String result = bc.memberlogin(id, pw);
		
		if (result != null) {
			String[] str = result.split(",");
			lv.logmenu(str[0], str[1]);
			System.out.println(blc.loginsert(id).toString());
		} else {
			menu();
		}
	}
	
}
