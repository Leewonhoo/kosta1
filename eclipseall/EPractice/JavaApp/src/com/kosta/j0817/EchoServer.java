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
			// 1.서버 소켓 객체 생성
			ServerSocket ss = new ServerSocket(6666/*port*/); //VJM의 IP와 명시된 port로 서비스 시작
			System.out.println("--start--");

			while(true) {
				//2. 클라이언트에 대한 무한 대기
				Socket s = ss.accept();

				InetAddress ia = s.getInetAddress();
				System.out.println("Client Ip : "+ia.getHostAddress());

				// 6. 데이터 수신
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String str = in.readLine();

				System.out.println("client msg : "+str);
				
				// 7. 데이터 송신
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
