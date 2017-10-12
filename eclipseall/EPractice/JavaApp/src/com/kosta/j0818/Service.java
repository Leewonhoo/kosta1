package com.kosta.j0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread {   //접속 클라이언트 하나당 Service 한개

	public static final String SEND_MESSAGE = "300";

	Room myRoom;//클라이언트가 입장한 대화방		//새로운 대화방 => new //존재하는 대화방 =>받아오기
	String nickName;

	BufferedReader br;    //from 클라이언트
	OutputStream os;      //to 클라이언트

	Vector<Service> allV;
	Vector<Service> waitV;
	Vector<Room> roomV;

	public Service(Socket s, Server server) { 
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();

			this.allV = server.allV;
			this.waitV = server.waitV;
			this.roomV = server.roomV;

			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//생성자

	@Override
	public void run() { 		//클라이언트가 전송한 모든 메시지 수신
		try {
			while(true){
				String msg = br.readLine();
				String check[] = msg.split("\\|");
				String chek=check[0];
				switch (chek) {
				case "100":    //대기실 입장
					allV.add(this);
					waitV.add(this);
					if(getRoomInfo().length()>0)
						messageWait("200|"+getRoomInfo());
					break;

				case "110":
					for (int i = 0; i < roomV.size(); i++) {
						Room room = roomV.get(i);
						if(room.title.equals(check[1])) {
							myRoom = room;
							room.count++;
							break;         //방제목의 유일성
						}
					}
					waitV.remove(this);
					myRoom.userV.add(this);
					messageWait("200|"+getRoomInfo());
					break;
					
				case "190":

				case "200":
					String test2="";
					for(int i=1; i<check.length; i++)
						test2+=check[i];
					Room room = new Room(test2,1,nickName);
					myRoom=room;

					room.userV.add(this);    //대기방 => 새로운 방
					waitV.remove(this);
					roomV.add(room);
					
					messageWait("200|"+getRoomInfo());    //대기실 인원에게 방정보 출력					

					break;					

				case SEND_MESSAGE:		//메시지 전달
					String test3="";
					for(int i=1; i<check.length; i++)
						test3+=check[i];
					messageRoom("300|["+nickName+"] ▶ "+test3);
					break;

				case "500":		//대화명 변경
					String test5="";
					for(int i=1; i<check.length; i++)
						test5+=check[i];
					nickName=test5;
					break;

				default:
					break;
				}
			}//while
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//run  

	public void messageAll(String msg){//전체사용자
		//접속된 모든 클라이언트(대기실+대화방)에게 메시지 전달	   
		for(int i=0; i<allV.size(); i++) {
			Service all = allV.get(i);
			try {
				all.messageTo(msg);
			} catch (IOException e) {
				System.out.println("채팅 접속 종료 : "+e.getMessage());
				myRoom.userV.remove(i--);
				//e.printStackTrace();
			}
		}
	}//messageAll

	public void messageWait(String msg){//대기실 사용자	   

		for(int i=0; i<waitV.size(); i++) {
			Service wait =waitV.get(i);
			try {
				wait.messageTo(msg);
			} catch (IOException e) {
				System.out.println("대기방 접속 종료 : "+e.getMessage());
				waitV.remove(i--);
				//e.printStackTrace();
			}
		}
	}//messageWait

	public void messageRoom(String msg){//대화방사용자
		for(int i=0; i<myRoom.userV.size(); i++) {
			Service rom = myRoom.userV.get(i);
			try {
				rom.messageTo(msg);
			} catch (IOException e) {
				System.out.println("대화방 접속 종료 : "+e.getMessage());
				myRoom.userV.remove(i--);
				System.out.println("대화방 유수 : "+myRoom.userV.size());
				//messageWait("200|"+getRoomInfo());
				//String mess = rom.nickName;
				//try {
				//rom.messageTo(mess+"님이 퇴장하엿습니다.");
				//} catch (IOException e1) {
				//e1.printStackTrace();
				//}
				//e.printStackTrace();
			}
		}

	}//messageRoom

	public void messageTo(String msg) throws IOException{
		//특정 클라이언트에게 메시지 전달 (실제 서버--->클라이언트 메시지 전달)
		os.write((msg+"\n").getBytes());
	}

	public String getRoomInfo() {
		String roomInfor="";
		for(int i=0; i<roomV.size(); i++) {
			String title = roomV.get(i).title;
			int count = roomV.get(i).count;
			roomInfor = title+"--"+count;
			if(i<(roomV.size()-1))
				roomInfor+=",";
		}
		return roomInfor;
	}

}



