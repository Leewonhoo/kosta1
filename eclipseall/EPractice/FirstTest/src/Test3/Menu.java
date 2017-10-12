package Test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	Management ma;

	public Menu() throws IOException {
		ma = new Management();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int select=0;
		
		ma.load();

		do {
			System.out.println("### 초기화 데이터 추가 ##\n");
			System.out.println("## -------------------");
			System.out.println("## 전화번호부 메인메뉴");
			System.out.println("## -------------------");
			System.out.println(" 1. 전화번호 등록");
			System.out.println(" 2. 전화번호 전체조회");
			System.out.println(" 3. 전화번호 상세조회");
			System.out.println(" 4. 전화번호 변경");
			System.out.println(" 5. 전화번호 삭제");
			System.out.println("98. 전화번호 저장 후 종료");
			System.out.println("99. 전화번호 종료");
			System.out.println("## -------------------");
			System.out.print("[메뉴번호 입력] : ");
			
			try {
				select = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("숫자로 입력해주세요.\n\n");
				continue;
			}

			switch(select) {
			case 1:
				
				System.out.println("## -------------------");
				System.out.println("## 전화번호 등록");
				System.out.println("## -------------------");
				System.out.print("이름 : ");
				String name = br.readLine();
				System.out.print("번호 : ");
				String phone = br.readLine();
				System.out.print("주소 : ");
				String add = br.readLine();
				ma.insert(name, phone, add);
				System.out.println("## -------------------");
				System.out.println("[Message] : 회원등록 완료되었습니다.\n");
				break;
			case 2:
				System.out.println("## -------------------");
				System.out.println("## 전화번호 전체조회");
				System.out.println("## -------------------");
				ma.print();
				System.out.println("## -------------------\n");
				break;
			case 3:
				System.out.println("## -------------------");
				System.out.println("## 전화번호 상세조회");
				System.out.println("## -------------------");
				System.out.print("이름 : ");
				String name1 = br.readLine();
				ma.serarch(select, name1);
				System.out.println("## -------------------\n");
				break;
			case 4:
				System.out.println("## -------------------");
				System.out.println("## 전화번호 변경");
				System.out.println("## -------------------");
				System.out.print("이름 : ");
				String name2 = br.readLine();
				ma.serarch(select, name2);
				System.out.println("[Message] : 회원변경 완료되었습니다.\n");
				break;
			case 5:
				System.out.println("## -------------------");
				System.out.println("## 전화번호 삭제");
				System.out.println("## -------------------");
				System.out.print("이름 : ");
				String name3 = br.readLine();
				ma.serarch(select, name3);
				System.out.println("[Message] : 회원삭제 완료되었습니다.\n");
				break;
			case 98:				
				System.out.println("## -------------------");
				System.out.println("## -------------------");
				ma.save();
				System.out.println("## -------------------");
				System.out.println("## 파일 저장후 프로그램을 정상 종료합니다.");
				System.out.println("## -------------------");
				return;
			case 99:
				System.out.println("## -------------------");
				System.out.println("## 프로그램을 정상 종료합니다.");
				System.out.println("## -------------------");
				return;
			default:
				System.out.println("다시 입력해주세요.\n\n");
			}
		}while(select!=99);
		br.close();
	}

}
