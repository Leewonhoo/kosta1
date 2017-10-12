package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {
		
		try {
			// 3. ���� ���� �õ�
			Socket s = new Socket("192.168.0.188", 6666);
			System.out.println("����");
			
			// 4. �� ��� ��ü ����
			OutputStream ou = s.getOutputStream();
			String msg = "First Socket Time!\n";
			
			// 5. ������ �۽�
			ou.write(msg.getBytes());
			
			// 8. ������ ����
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = in.readLine();

			
			System.out.println("client msg : "+str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
