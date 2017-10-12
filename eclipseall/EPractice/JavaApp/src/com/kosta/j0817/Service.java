package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
	//소켓 입출력 서비스

	BufferedReader br;
	OutputStream os;
	Vector<Service> v;
	String nickn;

	public Service(Socket s, Vector<Service> v) {   // v: 모든 클래스가 저장된 벡터
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();
			this.v = v;
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//input service 클라이언트 tf 메시지 (언제보낸지 모르므로 스레드 처리)
	public void run() {
		try {
			//nickn = br.readLine();    //대화명 입력
			while(true) {
				String msg = br.readLine();
				String check[] = msg.split("\\|");
				switch(check[0]) {
				case "200":
					nickn=check[1];
					break;
				case "100":
					messageAll("["+nickn+"] ▶ "+check[1]);
					break;
				}
				//if(check[0].equals("200")) {
				//nickn=msg.substring(1);
				//}else {
				//messageAll("["+nickn+"] ▶ "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//output service 접속한 클라이언트에게 메시지 보내기
	public void messageTo(String msg) throws IOException{   //개별전송
		os.write((msg+"\n").getBytes());
	}

	public void messageAll(String msg) {  //전체 전송
		for (int i = 0; i < v.size(); i++) {
			Service sv = v.get(i);
			try {
				System.out.println(sv.nickn);
				sv.messageTo(msg);
			} catch (IOException e) {
				v.remove(i);         //문제가 발생한 벡터 제거
				if(v.size()<0) {
					return ;
				}
				i--;
				e.printStackTrace();
			}
		}
	}
}
