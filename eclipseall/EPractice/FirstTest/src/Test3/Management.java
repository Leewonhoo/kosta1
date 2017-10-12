package Test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Management {
	PhoneBook pb;
	HashMap<String, PhoneBook> hash;
	File f;

	public Management() {
		hash = new HashMap<>();
		f = new File("I:\\ho\\EPractice\\FirstTest\\PhoneBook.txt");
	}

	public void insert(String name, String phone, String address) {		
		if(hash.containsKey(name)) {
			System.out.println("존재하는 이름입니다.");
			return;
		}
		pb = new PhoneBook(name, phone, address);
		hash.put(name, pb);
	}

	public void print() {
		System.out.println("이름\t|전화번호\t\t|주소");
		
		Set<String> a = hash.keySet();
//		a.j
//		List<String> li = hash.
		Object[] ab = a.toArray();
		for(int i=0; i<ab.length; i++) {
			pb=hash.get(ab[i].toString());
			System.out.println(pb.getName()+"\t|"+pb.getPhone()+"\t|"+pb.getAddress());			
		}
	}

	public void serarch(int n, String name) throws IOException {
		switch(n) {
		case 3:
			if(!hash.containsKey(name)) {
				System.out.println("존재하지 않는 이름입니다.");
				return;
			}
			pb = hash.get(name);
			System.out.println("이름\t|전화번호\t\t|주소");
			System.out.println("-------------------");
			System.out.println(pb.getName()+"\t|"+pb.getPhone()+"\t|"+pb.getAddress());
			break;
		case 4:
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if(!hash.containsKey(name)) {
				System.out.println("존재하지 않는 이름입니다.");
				return;
			}
			pb = hash.get(name);
			System.out.println("전화번호["+pb.getPhone()+"] : ");
			String phone = br.readLine();
			System.out.println("주소["+pb.getAddress()+"] : ");
			String add = br.readLine();
			pb.setPhone(phone);
			pb.setAddress(add);
			hash.replace(name, pb);
			break;
		case 5:
			if(!hash.containsKey(name)) {
				System.out.println("존재하지 않는 이름입니다.");
				return;
			}
			hash.remove(name);
			break;
		}
	}

	public void save() {
		int count=0;
		try {
			if(!f.exists())
				f = new File("I:\\ho\\EPractice\\FirstTest\\PhoneBook.txt");

			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			Set<String> a = hash.keySet();
			Object[] ab = a.toArray();
			for(int i=0; i<ab.length; i++) {
				pb=hash.get(ab[i].toString());		
				String ss = pb.getName()+"\t|"+pb.getPhone()+"\t|"+pb.getAddress();
				bw.write(ss+"\r\n");
				count++;
			}
			bw.flush();			
			System.out.println("## -------------------");
			System.out.println("[Message] 파일 저장 : "+f.getAbsolutePath());
			System.out.println("## -------------------");
			System.out.println("[Message] 전화번호부 파일에 저장 중 입니다.");
			System.out.println("## -------------------");
			System.out.println("[Message] 전화번호부 파일에 "+count+"개 정보를 저장하였습니다.");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		if(!f.exists())
			System.out.println("## -----파일이 없습니다.-----");
		else {
			try {
				String str="";
				BufferedReader br = new BufferedReader(new FileReader(f));
				while((str=br.readLine())!=null) {
					String[] lo = str.split("\\|");
					pb = new PhoneBook(lo[0].trim(), lo[1].trim(), lo[2].trim());
					hash.put(lo[0], pb);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
