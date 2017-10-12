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
	 * 회원가입 view
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
		System.out.println("\t\t\t || 회원가입 ||");
		System.out.println("=================================================================");
		while (!check) {
			System.out.println("* : 필수");
			System.out.print("*아이디(4~6자) : ");
			id = input(id);
			System.out.print("아이디 중복 검사 결과 =>");
			check = bc.idcheck(id);
		}
		System.out.print("*비밀번호(6~10자) : ");
		pw = input(pw);
		System.out.print("*이름(7자내) : ");
		name = input(name);
		while (check) {
			System.out.print("*닉네임(2~10자) : ");
			nick = input(nick);
			System.out.print("닉네임 중복 검사 결과 =>");
			check = bc.nickcheck(nick);
		}
		System.out.print("*생년월일 : ");
		birth = input(birth);
		System.out.print("휴대폰(-생략) : ");
		phone = input(phone);
		System.out.print("이메일(15자내) : ");
		mail = input(mail);
		System.out.print("*성별(M/F) : ");
		gender = input(gender);
		System.out.print("주소(20자내) : ");
		address = input(address);
		System.out.println("( 질문 : 나의 유년시절 별명은? )");
		System.out.print("*답변(25자내) : ");
		answer = input(answer);

		System.out.println("입력한 정보로 회원가입하시겠습니까?");
		System.out.println("1. 회원가입  |  2. 취소");
		System.out.print("선택 => ");
		select = input(select);
		switch (select) {
		case 1:
			Bmember bmem = new Bmember(id, pw, name, nick, birth, phone, mail, gender, address, 1, answer);
			System.out.println(bc.memberinsert(bmem));
			return;
		case 2:
			return;
		default:
			System.out.println("잘못 선택하였습니다. 메뉴로 돌아갑니다.");
			return;
		}
	}
	
	/**
	 * <pre>
	 * ID/PW 찾기 view
	 * </pre>
	 */
	public void search() {
		BmemberController bc = new BmemberController();
		int select = 0;
		String id = null;
		String name = null;
		String birth = null;
		String answer = null;
		System.out.println("1. ID찾기  |  2. PW찾기  |  3.취소");
		System.out.print("선택 => ");
		select = input(select);
		switch (select) {
		case 1:
			System.out.println("ID찾기");
			System.out.print("이름을 입력하세요 => ");
			name = input(name);
			System.out.print("생년월일을 입력하세요 => ");
			birth = input(birth);
			System.out.print("질문 : 나의 유년시절 별명은 => ");
			answer = input(answer);
			Bmember bmem = new Bmember();
			bmem.setmName(name);
			bmem.setmBirth(birth);
			bmem.setmAnswer(answer);
			String result = bc.memberid(bmem);
			if (result != null) {
				System.out.println("아이디는 "+result+"입니다.\n");
			}
			break;
		case 2:
			System.out.println("PW찾기");
			System.out.print("ID를 입력하세요 => ");
			id = input(id);
			System.out.print("이름을 입력하세요 => ");
			name = input(name);
			System.out.print("생년월일을 입력하세요 => ");
			birth = input(birth);
			System.out.print("질문 : 나의 유년시절 별명은 => ");
			answer = input(answer);
			Bmember bmem1 = new Bmember();
			bmem1.setmId(id);
			bmem1.setmName(name);
			bmem1.setmBirth(birth);
			bmem1.setmAnswer(answer);
			String result1 = bc.memberpw(bmem1);
			if (result1 != null) {
				System.out.println("비밀번호는 "+result1+"입니다.\n");
			}
			break;
		case 3:
			System.out.println("메뉴로 돌아갑니다.");
			break;
		default: System.out.println("잘못 선택하였습니다.");
		}
	}
	
}
