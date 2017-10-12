package com.kosta.j0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Savename {
	//	static String[] name = {"null", "null", "null", "null", "null"};
	static String[] name = new String[5];

	public void smain() throws Exception {
		boolean auto = true;
		while(auto) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int select;
			String na1, na2;
			boolean cc = false;
			String input="null";
			
			do {
				System.out.println("---메뉴를 선택하세요---");
				System.out.println("1.입력  2.검색 3.수정 4.삭제 5.종료 6.저장된갯수");
				System.out.print("선택 =>");
				input = br.readLine();

				cc = input.matches("[0-9]");
			}while(!cc);
			
			select = Integer.parseInt(input);
			
			switch(select) {
			case 1:
				System.out.print("이름을 입력하세요 : ");
				na1=br.readLine();
				insert(na1);
				break;
			case 2:
				select();
				break;
			case 3:
				System.out.print("검색할 이름을 입력하세요 : ");
				na1=br.readLine();
				System.out.print("수정할 이름을 입력하세요 : ");
				na2=br.readLine();
				update(na1, na2);
				break;
			case 4:
				System.out.print("삭제할 이름을 입력하세요 : ");
				na1=br.readLine();
				delete(na1);
				break;
			case 5:
				auto=false;
				break;
			case 6:
				System.out.println("현재 저장된 이름의 갯수 : "+count()+"\n");
				break;
			default :
				System.out.println("잘못 누르셨습니다.");
			}
		}
		System.out.println("----END----");
	}

	private void insert(String in) {
		for(int i=0; i<name.length; i++) {

			//			if(!name[name.length-1].equals("null")) {
			if(name[name.length-1]!=null) {
				System.out.println("저장 공간이 부족합니다.");
				System.out.println("다른 이름을 삭제 후 입력하세요.");
				break;
			}

			//			if(name[i].equals("null")) {
			if(name[i]==null) {
				name[i]=in;
				for(int j=0; j<i; j++) {
					if(name[j].equals(in)) {
						System.out.println("이름이 중복 됩니다.");
						name[i]=null;
						break;
					}
				}
				break;
			}
		}
		System.out.println("--insert--\n");		
	}

	private void select() {
		for(int i=0; i<name.length; i++) {
			//			if(name[i].equals("null"))
			if(name[i]==null)
				continue;
			System.out.println("이름 : "+name[i]);
		}
		System.out.println("--select--\n");
	}

	private void update(String sel, String mo) {
		
		/*for(int i=0; i<name.length; i++) {              //compare 메소드 사용하지 않음
			if(name[i]==null) {                               // (1)
				if(i==(name.length-1)) {
					System.out.println("일치하는 이름이 없습니다.\n");
					break;
				}
				continue;
			}
			else if(name[i].equals(sel)) {
				name[i]=mo;
				System.out.println("--update--");
				break;
			}
			else{
				if(i==(name.length-1)) {
					System.out.println("일치하는 이름이 없습니다.\n");
					break;
				}
			}
			
			//			if(name[i]!=null&&name[i].equals(sel)) {        // &&를 이용한 방법 (2)
			//				name[i]=mo;
			//				System.out.println("--update--");
			//				break;
			//			}else{
			//				if(i==(name.length-1)) {
			//					System.out.println("일치하는 이름이 없습니다.\n");
			//					break;
			//				}
			//				continue;
			//			}

			// 다른 방법 (3)
			//			if(sel.equals(name[i])) {                   // 비교할 문자.equls를 사용시 null 값이 들어가질 않는다.
			//				name[i]=mo;
			//				System.out.println("--update--");
			//				break;
			//			}else {
			//				if(i==(name.length-1)) {
			//					System.out.println("일치하는 이름이 없습니다.\n");
			//				}
			//				continue;
			//			}
		}*/
		
		int num = compare(sel);
		if(num==(name.length+1)) {
			return ;
		}else {
			name[num]=mo;
			System.out.println("--update--\n");
		}
	}

	private void delete(String del) {
		/*for(int i=0; i<name.length; i++) {
			if(del.equals(name[i])) {
//				name[i]="null";
				name[i]=null;
				System.out.println("--delete--");
				break;
			}
		}*/
		
		int num = compare(del);              //compare메소드를 사용한 방법
		if(num==(name.length+1)) {
			return ;
		}else {		
			name[num]=null;
			System.out.println("--delete--\n");
		}
	}

	private int compare(String sel) {         // 배열의 이름 찾는 메소드
		int num = 0;
		for (int i = 0; i < name.length; i++) {
			if(sel.equals(name[i])) {
				System.out.println("이름이 존재합니다.");
				return i;
			}
			else {
				if(i==(name.length-1)) {
					System.out.println("이름이 존재하지 않습니다.\n");
					break;
				}
			}
		}
		return (name.length+1);
	}

	private int count() {             // 배열의 이름 갯수 파악하는 메소드
		int num=0;
		for(int i=0; i<name.length; i++) {
			if(name[i]!=null)
				num++;
		}
		return num;		
	}

}
