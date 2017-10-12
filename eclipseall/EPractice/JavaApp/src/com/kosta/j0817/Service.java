package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
	//���� ����� ����

	BufferedReader br;
	OutputStream os;
	Vector<Service> v;
	String nickn;

	public Service(Socket s, Vector<Service> v) {   // v: ��� Ŭ������ ����� ����
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();
			this.v = v;
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//input service Ŭ���̾�Ʈ tf �޽��� (���������� �𸣹Ƿ� ������ ó��)
	public void run() {
		try {
			//nickn = br.readLine();    //��ȭ�� �Է�
			while(true) {
				String msg = br.readLine();
				String check[] = msg.split("\\|");
				switch(check[0]) {
				case "200":
					nickn=check[1];
					break;
				case "100":
					messageAll("["+nickn+"] �� "+check[1]);
					break;
				}
				//if(check[0].equals("200")) {
				//nickn=msg.substring(1);
				//}else {
				//messageAll("["+nickn+"] �� "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//output service ������ Ŭ���̾�Ʈ���� �޽��� ������
	public void messageTo(String msg) throws IOException{   //��������
		os.write((msg+"\n").getBytes());
	}

	public void messageAll(String msg) {  //��ü ����
		for (int i = 0; i < v.size(); i++) {
			Service sv = v.get(i);
			try {
				System.out.println(sv.nickn);
				sv.messageTo(msg);
			} catch (IOException e) {
				v.remove(i);         //������ �߻��� ���� ����
				if(v.size()<0) {
					return ;
				}
				i--;
				e.printStackTrace();
			}
		}
	}
}
