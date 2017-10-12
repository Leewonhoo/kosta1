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
	 * 게시판 등록 view
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
		System.out.println("\t\t\t\tW 까페");
		System.out.println("\t\t\t"+nick+" 님 환영합니다 ~~~");
		System.out.println("=================================================================");
		System.out.println("1. 게시판 등록");

		System.out.print("제목 : ");
		title = input(title);
		System.out.println("내용 : ");
		memo = input(memo);
		System.out.print("비밀번호 : ");
		pw = input(pw);
		System.out.print("태그 : ");
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
	 * 게시글 삭제 view
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
		System.out.println("\t\t\t\tW 까페");
		System.out.println("\t\t\t"+nick+" 님 환영합니다 ~~~");
		System.out.println("=================================================================");
		System.out.println("====  게시글 삭제  ====");

		System.out.print("게시글 번호 : ");
		num = input(num);
		System.out.print("게시글 비밀번호 : ");
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
	 * 개인 정보 조회
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
		System.out.println("\t\t\t\tW 까페");
		System.out.println("\t\t\t"+nick+" 님 환영합니다 ~~~");
		System.out.println("=================================================================");
		System.out.println("====  정보 변경  ====");

		Bboard bb = new Bboard();
		bb.setbId(id);
		bb.setbNick(nick);
		String st[] = bbc.bmeminfor(bb).split(",");

		System.out.println("=================================================================");
		System.out.println("\t\t\t\t|  회원 정보 조회 결과  |");
		System.out.println("=================================================================");
		System.out.print("아이디 : "+st[0]+"\t");
		System.out.print("비밀번호 : "+st[1]+"\t");
		System.out.println("이름 : "+st[2]);
		System.out.print("닉네임 : "+st[3]+"\t");
		System.out.print("생년월일 : "+st[4]+"\t");
		System.out.println("휴대폰 : "+st[5]);
		System.out.print("이메일 : "+st[6]+"\t");
		System.out.print("성별 : "+st[7]+"\t");
		System.out.println("주소 : "+st[8]);
		System.out.println("질문 : 나의 유년시절 별명은?");
		System.out.println("답변 : "+st[9]);
		System.out.println("=================================================================");
		System.out.println("변경하시겠습니까?");
		while ((select != 1) || (select != 2)) {
			System.out.println("1.변경\t2.취소");
			select = input(select);
			switch(select) {
			case 1:
				bmodinfor(id, nick);
				return;
			case 2:
				return ;
			default: System.out.println("잘못 선택하였습니다. 다시 선택해주세요.");
			}
		}
	}

	/**
	 * <pre>
	 * 개인정보 변경
	 * </pre>
	 * @param id
	 * @param nick
	 */
	private void bmodinfor(String id, String nick) {      //개인정보 수정
		bbc = new BboardController();
		Bmember bb = new Bmember();
		LoginView lv = new LoginView();
		boolean check = false;
		int select = 0;
		String str = null;
		System.out.print("*비밀번호(6~10자) : ");
		bb.setmPw(input(str));
		while (!check) {
			System.out.print("*닉네임(2~10자) : ");
			bb.setmNick(input(str));
			System.out.print("닉네임 중복 검사 결과 =>");
			check = bbc.nickcheck(id, bb.getmNick());
		}

		bb.setmId(id);
		System.out.print("*생년월일 : ");
		bb.setmBirth(input(str));
		System.out.print("휴대폰(-생략) : ");
		bb.setmPhone(input(str));
		System.out.print("이메일(15자내) : ");
		bb.setmMail(input(str));
		System.out.print("*성별(M/F) : ");
		bb.setmGender(input(str));
		System.out.print("주소(20자내) : ");
		bb.setmAddress(input(str));
		System.out.println("질문 : 나의 유년시절 별명은?");
		System.out.print("*답변(25자내) : ");
		bb.setmAnswer(input(str));

		System.out.println("입력한 정보로 변경하시겠습니까?");
		System.out.println("1. 변경  |  2. 취소");
		System.out.print("선택 => ");
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
			System.out.println("잘못 선택하였습니다. 메뉴로 돌아갑니다.");
			return;
		}
	}
	
	/**
	 * 게시글 목록 view
	 * @param id
	 * @param nick
	 */
	public void boutmenu(String id, String nick) {
		BoardmenuView bv = new BoardmenuView();
		int num = 0;
		int select = 0;
		do {
			System.out.println("=================================================================");
			System.out.println("\t\t\t\tW 까페");
			System.out.println("\t\t\t"+nick+" 님 환영합니다 ~~~");
			System.out.println("=================================================================");
			System.out.println("1. 게시판 전체 조회");
			System.out.println("2. 게시판 내가 작성한 목록");
			System.out.println("3. 게시글 상세 보기");
			System.out.println("4. 게시글 삭제");
			System.out.println("5. 이전");
			System.out.print("선택 => ");

			select = input(select);
			switch (select) {
			case 1:
				boutAll();//게시판 전체 목록 UI
				break;
			case 2:
				boutmy(nick);
				break;
			case 3:
				System.out.print("조회할 게시글 번호 입력 : ");
				num = input(num);
				bdetail(num);
				break;
			case 4:
				bdelmenu(id, nick);
				break;
			case 5:
				System.out.println();
				return ;
			default: System.out.println("잘못 선택하였습니다.");
			}
		} while (select != 5);
	}

	/**
	 * <pre>
	 * 게시글 전체 목록 view
	 * </pre>
	 */
	private void boutAll() {
		bbc = new BboardController();
		int num = 1;
		int page = 1;
		int line = 1;
		System.out.println("게시판 목록");
		do {
			ArrayList al = bbc.boardselectAll(num);
			if (al == null) {
				System.out.println("\n목록이 없습니다.");
			} else {
				System.out.println("   번호 | 글 번호 |    닉네임    |     날짜     |   방문자수   |             제목");
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
				System.out.println("| 2.메뉴  | 3.다음  | 4.내용보기");
			} else if (num*5+1 > last) {
				System.out.println("=================================================================");
				System.out.println("1.이전  | 2.메뉴  | 4.내용보기");
			} else {
				System.out.println("=================================================================");
				System.out.println("1.이전  | 2.메뉴  | 3.다음  | 4.내용보기");
			}
			System.out.print("선택 => ");
			page = input(page);
			switch (page) {
			case 1:
				if (num == 1) {
					num = 1;
					System.out.println("최소 페이지 입니다.\n");
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
					System.out.println("최대 페이지 입니다.\n");
				}
				break;
			case 4:
				System.out.print("조회할 게시글 번호 입력 : ");
				num = input(num);
				bdetail(num);
				break;
			default:
				System.out.println("잘못 선택하였습니다. 메뉴로 돌아갑니다.");
				return;
			}			
		} while (page != 2);
	}

	/**
	 * <pre>
	 * 내가 쓴글 view
	 * </pre>
	 * @param nick
	 */
	private void boutmy(String nick) {
		System.out.println("내가쓴글");
		bbc = new BboardController();
		int num = 1;
		int page = 1;
		int line = 1;
		System.out.println("내가 작성한 게시판 목록");
		do {
			ArrayList al = bbc.boardselectmy(num, nick);
			if (al == null) {
				System.out.println("\n목록이 없습니다.");
			} else {
				System.out.println("   번호 | 글 번호 |    닉네임    |     날짜     |   방문자수   |             제목");
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
				System.out.println("| 2.메뉴  | 3.다음  | 4.내용보기");
			} else if (num*5+1 > last) {
				System.out.println("=================================================================");
				System.out.println("1.이전  | 2.메뉴  | 4.내용보기");
			} else {
				System.out.println("=================================================================");
				System.out.println("1.이전  | 2.메뉴  | 3.다음  | 4.내용보기");
			}
			System.out.print("선택 => ");
			page = input(page);
			switch (page) {
			case 1:
				if (num == 1) {
					num = 1;
					System.out.println("최소 페이지 입니다.\n");
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
					System.out.println("최대 페이지 입니다.\n");
				}
				break;
			case 4:
				System.out.print("조회할 게시글 번호 입력 : ");
				num = input(num);
				bdetail(num);
				break;
			default:
				System.out.println("잘못 선택하였습니다. 메뉴로 돌아갑니다.");
				return;
			}			
		} while (page != 2);
	}
	
	/**
	 * <pre>
	 * 게시판 세부내용 view
	 * </pre>
	 * @param num
	 */
	public void bdetail(int num) {
		bbc = new BboardController();
		bbc.bvisitup(num);
		ArrayList al = bbc.bbetail(num);
		System.out.println("=================================================================");
		System.out.println("\t\t\t상세 조회");
		System.out.println("=================================================================");
		if (al == null) {
			System.out.println("조회결과가 존재하지 않습니다.");
			return ;
		}
		System.out.printf("  제목 : %26s\t|", al.get(1));
		System.out.printf("  날짜 : %3s\n", al.get(3));
		System.out.printf("  글쓴이 : %26s\t|", al.get(0));
		System.out.printf("  방문자 수 : %4s\n", al.get(4));
		System.out.printf("  태그 : %250S\n", al.get(5));
		System.out.println("=================================================================");
		System.out.printf("%s\n", al.get(2));
		System.out.println("=================================================================\n\n");
	}

}
