package com.kosta.j0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread {   //���� Ŭ���̾�Ʈ �ϳ��� Service �Ѱ�

	public static final String SEND_MESSAGE = "300";

	Room myRoom;//Ŭ���̾�Ʈ�� ������ ��ȭ��		//���ο� ��ȭ�� => new //�����ϴ� ��ȭ�� =>�޾ƿ���
	String nickName;

	BufferedReader br;    //from Ŭ���̾�Ʈ
	OutputStream os;      //to Ŭ���̾�Ʈ

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
	}//������

	@Override
	public void run() { 		//Ŭ���̾�Ʈ�� ������ ��� �޽��� ����
		try {
			while(true){
				String msg = br.readLine();
				String check[] = msg.split("\\|");
				String chek=check[0];
				switch (chek) {
				case "100":    //���� ����
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
							break;         //�������� ���ϼ�
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

					room.userV.add(this);    //���� => ���ο� ��
					waitV.remove(this);
					roomV.add(room);
					
					messageWait("200|"+getRoomInfo());    //���� �ο����� ������ ���					

					break;					

				case SEND_MESSAGE:		//�޽��� ����
					String test3="";
					for(int i=1; i<check.length; i++)
						test3+=check[i];
					messageRoom("300|["+nickName+"] �� "+test3);
					break;

				case "500":		//��ȭ�� ����
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

	public void messageAll(String msg){//��ü�����
		//���ӵ� ��� Ŭ���̾�Ʈ(����+��ȭ��)���� �޽��� ����	   
		for(int i=0; i<allV.size(); i++) {
			Service all = allV.get(i);
			try {
				all.messageTo(msg);
			} catch (IOException e) {
				System.out.println("ä�� ���� ���� : "+e.getMessage());
				myRoom.userV.remove(i--);
				//e.printStackTrace();
			}
		}
	}//messageAll

	public void messageWait(String msg){//���� �����	   

		for(int i=0; i<waitV.size(); i++) {
			Service wait =waitV.get(i);
			try {
				wait.messageTo(msg);
			} catch (IOException e) {
				System.out.println("���� ���� ���� : "+e.getMessage());
				waitV.remove(i--);
				//e.printStackTrace();
			}
		}
	}//messageWait

	public void messageRoom(String msg){//��ȭ������
		for(int i=0; i<myRoom.userV.size(); i++) {
			Service rom = myRoom.userV.get(i);
			try {
				rom.messageTo(msg);
			} catch (IOException e) {
				System.out.println("��ȭ�� ���� ���� : "+e.getMessage());
				myRoom.userV.remove(i--);
				System.out.println("��ȭ�� ���� : "+myRoom.userV.size());
				//messageWait("200|"+getRoomInfo());
				//String mess = rom.nickName;
				//try {
				//rom.messageTo(mess+"���� �����Ͽ����ϴ�.");
				//} catch (IOException e1) {
				//e1.printStackTrace();
				//}
				//e.printStackTrace();
			}
		}

	}//messageRoom

	public void messageTo(String msg) throws IOException{
		//Ư�� Ŭ���̾�Ʈ���� �޽��� ���� (���� ����--->Ŭ���̾�Ʈ �޽��� ����)
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



