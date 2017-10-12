package UI;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogUi {

	BufferedWriter bw;
	BufferedReader br;


	public LogUi() {
		try {			

			br = new BufferedReader(new InputStreamReader(System.in));
			String id;
			String pw;

			System.out.println("===========================");
			System.out.println("로그인 하기 (ver. 1.0)");
			System.out.println("===========================");
			System.out.print("ID : ");
			id = br.readLine();
			System.out.print("PW : ");
			pw = br.readLine();

			int logcheck = check(id, pw);    //로그인 확인			
			if(logcheck==2) {
				MenuYes my = new MenuYes(id);
			}else {
				MenuNo mn = new MenuNo();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int check(String id, String pw) {
		if(id.equals("idisa2")) {
			if(pw.equals("password2")) {

			}else {
				System.out.println("비밀번호를 확인해주세요!!\\n\\n");
				return 1;
			}
		}else {
			System.out.println("아이디를 확인해주세요!!\n\n");
			return 1;			
		}
		System.out.println("\n\n");
		return 2;
	}

	public static void main(String[] args) {
		new LogUi();
	}

}
