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
			System.out.println("�����ϴ� �̸��Դϴ�.");
			return;
		}
		pb = new PhoneBook(name, phone, address);
		hash.put(name, pb);
	}

	public void print() {
		System.out.println("�̸�\t|��ȭ��ȣ\t\t|�ּ�");
		
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
				System.out.println("�������� �ʴ� �̸��Դϴ�.");
				return;
			}
			pb = hash.get(name);
			System.out.println("�̸�\t|��ȭ��ȣ\t\t|�ּ�");
			System.out.println("-------------------");
			System.out.println(pb.getName()+"\t|"+pb.getPhone()+"\t|"+pb.getAddress());
			break;
		case 4:
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if(!hash.containsKey(name)) {
				System.out.println("�������� �ʴ� �̸��Դϴ�.");
				return;
			}
			pb = hash.get(name);
			System.out.println("��ȭ��ȣ["+pb.getPhone()+"] : ");
			String phone = br.readLine();
			System.out.println("�ּ�["+pb.getAddress()+"] : ");
			String add = br.readLine();
			pb.setPhone(phone);
			pb.setAddress(add);
			hash.replace(name, pb);
			break;
		case 5:
			if(!hash.containsKey(name)) {
				System.out.println("�������� �ʴ� �̸��Դϴ�.");
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
			System.out.println("[Message] ���� ���� : "+f.getAbsolutePath());
			System.out.println("## -------------------");
			System.out.println("[Message] ��ȭ��ȣ�� ���Ͽ� ���� �� �Դϴ�.");
			System.out.println("## -------------------");
			System.out.println("[Message] ��ȭ��ȣ�� ���Ͽ� "+count+"�� ������ �����Ͽ����ϴ�.");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		if(!f.exists())
			System.out.println("## -----������ �����ϴ�.-----");
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
