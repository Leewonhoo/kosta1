package com.kosta.j0818;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	//ServerŬ����: ������ ���� ���Ӽ���, ����Ŭ���̾�Ʈ ����

	Vector<Service> allV;//��� �����(���ǻ���� + ��ȭ������)
	Vector<Service> waitV;//���� �����	   
	Vector<Room> roomV;//������ ��ȭ�� 

	ServerSocket ss;

	public Server() {
		allV = new Vector<>();
		waitV = new Vector<>();
		roomV = new Vector<>();

		new Thread(this).start();

	}//������


	@Override
	public void run(){	   
		try {
			ss = new ServerSocket(5353);       //�� ������ JVM IP, ��õ� port
			while(true){
				Socket s = ss.accept();      //������ Ŭ���̾�Ʈ ��������
				System.out.println("���� Ŭ�� : "+s.getInetAddress().getHostName()
						+" "+s.getInetAddress().getHostAddress());
				Service service = new Service(s, this);    //this : allV, waitV, roomV
				
				//�����ޱ� ���� ���Ϳ� ���
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
