package com.kosta.j0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Savename2 {
	Vector<String> name;

	public Savename2() {
		name = new Vector<>();
	}

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
				System.out.println("1.입력  2.검색 3.수정 4.삭제 5.종료");
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
			default :
				System.out.println("잘못 누르셨습니다.");
			}
		}
		System.out.println("\n----END----");
	}

	private void insert(String in) {
		if(name.contains(in))
			System.out.println("중복된 이름입니다.\n");
		else {
			name.add(in);
			System.out.println("--insert--\n");
		}
	}

	private void select() {
		for(int i=0; i<name.size(); i++) {
			System.out.println("이름 "+i+"번째 : "+name.get(i));
		}
		System.out.println("--select--\n");
	}

	private void update(String sel, String mo) {
		if(name.contains(sel)) {
			name.set(name.indexOf(sel), mo);
			System.out.println("--update--\n");
		}
		else 
			System.out.println("찾는 이름이 없습니다.\n");
	}

	private void delete(String del) {
		if(name.contains(del)) {
			name.remove(del);
			System.out.println("--delete--\n");
		}
		else
			System.out.println("찾는 이름이 없습니다.\n");
	}		

}
