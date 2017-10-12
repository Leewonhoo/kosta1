package com.kosta.j0818;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	//Server클래스: 소켓을 통한 접속서비스, 접속클라이언트 관리

	Vector<Service> allV;//모든 사용자(대기실사용자 + 대화방사용자)
	Vector<Service> waitV;//대기실 사용자	   
	Vector<Room> roomV;//개설된 대화방 

	ServerSocket ss;

	public Server() {
		allV = new Vector<>();
		waitV = new Vector<>();
		roomV = new Vector<>();

		new Thread(this).start();

	}//생성자


	@Override
	public void run(){	   
		try {
			ss = new ServerSocket(5353);       //현 서버의 JVM IP, 명시된 port
			while(true){
				Socket s = ss.accept();      //접속한 클라이언트 소켓정보
				System.out.println("접속 클라 : "+s.getInetAddress().getHostName()
						+" "+s.getInetAddress().getHostAddress());
				Service service = new Service(s, this);    //this : allV, waitV, roomV
				
				//관리받기 위한 벡터에 등록
				allV.add(service);
				waitV.add(service);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//run	

	public static void main(String[] args) {
		new Server();
	}


}
