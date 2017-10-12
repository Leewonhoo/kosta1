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
			// 3. 서버 접속 시도
			Socket s = new Socket("192.168.0.188", 6666);
			System.out.println("성공");
			
			// 4. 입 출력 객체 생성
			OutputStream ou = s.getOutputStream();
			String msg = "First Socket Time!\n";
			
			// 5. 데이터 송신
			ou.write(msg.getBytes());
			
			// 8. 데이터 수신
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
