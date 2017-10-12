package com.kosta.j0817;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerA implements Runnable{
	//소켓을 통한 접속 서비스, 접속한 클라이언트 관리
	// 벡터를 이용한 관리
	
	ServerSocket ss;
	Vector<Service> v;
	
	public ServerA() {
		try {
			v = new Vector<>();
			ss = new ServerSocket(6666);
			
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("serv start");
		while(true) {
			try {
				Socket s = ss.accept();
				v.add(new Service(s,v));
				/*Service service = new Service(s);
				v.add(service);*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ServerA();
	}
	
}
