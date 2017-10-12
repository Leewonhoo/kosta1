package com.kosta.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		int i=0;

		try {
			// 1.���� ���� ��ü ����
			ServerSocket ss = new ServerSocket(6666/*port*/); //VJM�� IP�� ��õ� port�� ���� ����
			System.out.println("--start--");

			while(true) {
				//2. Ŭ���̾�Ʈ�� ���� ���� ���
				Socket s = ss.accept();

				InetAddress ia = s.getInetAddress();
				System.out.println("Client Ip : "+ia.getHostAddress());

				// 6. ������ ����
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String str = in.readLine();

				System.out.println("client msg : "+str);
				
				// 7. ������ �۽�
				String msg = "Your add ["+ia.getHostAddress()+"]\n";
				OutputStream os = s.getOutputStream();
				os.write(msg.getBytes());
				os.write(str.getBytes());
				
				//System.out.println("--end--");
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
