package com.kosta.j0818;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class MainChat extends JFrame implements ActionListener, Runnable{      //대기실
	JList<String> roomInfo,roomInwon,waitInfo;
	JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
	JButton bt_create, bt_enter, bt_exit;

	JPanel p;
	ChatClient cc;
	BufferedReader br;
	OutputStream os;

	String selectedroom;    //대기방에서 선택한 방 정보

	public MainChat() {	 
		setTitle("대기실");

		cc = new ChatClient();

		roomInfo = new JList<String>();
		roomInfo.setBorder(new TitledBorder("방정보"));	 

		roomInwon = new JList<String>();
		roomInwon.setBorder(new TitledBorder("인원정보"));
		waitInfo = new JList<String>();
		waitInfo.setBorder(new TitledBorder("대기실정보"));

		sp_roomInfo = new JScrollPane(roomInfo);
		sp_roomInwon = new JScrollPane(roomInwon);
		sp_waitInfo = new JScrollPane(waitInfo);

		bt_create = new JButton("방만들기");
		bt_enter = new JButton("방들어가기");
		bt_exit = new JButton("나가기");     

		p = new JPanel();

		sp_roomInfo.setBounds(10, 10, 300, 300);
		sp_roomInwon.setBounds(320, 10, 150, 300);
		sp_waitInfo.setBounds(10, 320, 300, 130);

		bt_create.setBounds(320,330,150,30);
		bt_enter.setBounds(320,370,150,30);
		bt_exit.setBounds(320,410,150,30);

		p.setLayout(null);
		p.setBackground(Color.orange);
		p.add(sp_roomInfo);
		p.add(sp_roomInwon);
		p.add(sp_waitInfo);
		p.add(bt_create);
		p.add(bt_enter);
		p.add(bt_exit);

		add(p);
		setBounds(300,200, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);    

		String nickName = JOptionPane.showInputDialog("대화명 => ");
		connect();    //서버 연결 시도
		sendMsg("500|"+nickName);
		sendMsg("100|");
		new Thread(this).start();
		eventUp();

	}//생성자

	private void eventUp(){//이벤트소스-이벤트처리부 연결
		//대기실
		bt_create.addActionListener(this);
		bt_enter.addActionListener(this);
		roomInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = roomInfo.getSelectedValue();
				selectedroom = str.substring(0, str.indexOf("--"));
			}
		});
		bt_exit.addActionListener(this);

		//대화방
		cc.sendTF.addActionListener(this);
		cc.bt_change.addActionListener(this);
		cc.bt_exit.addActionListener(this);
		cc.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(true);
				cc.setVisible(false);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==bt_create) {
			String roomName = JOptionPane.showInputDialog(this, "방제목 입력");
			sendMsg("200|"+roomName);
			cc.setTitle("채팅방"+roomName);
			setVisible(false);
			cc.setVisible(true);
			
		}else if(ob==bt_enter) {
			sendMsg("110|"+selectedroom);
			cc.setTitle("채팅방 ["+selectedroom+"]");
			setVisible(false);
			cc.setVisible(true);
		}else if(ob==bt_exit) {
			System.exit(0);
			
		}else if(ob==cc.sendTF){
			String msg = cc.sendTF.getText().trim();
			if(msg.length()<1) {
				return ;
			}else
				sendMsg("300|"+msg);
			cc.sendTF.setText("");
			
		}else if(ob==cc.bt_change) {
			String nickname = JOptionPane.showInputDialog(cc, "닉네임 변경");
			sendMsg("500|"+nickname);
			
		}else if(ob==cc.bt_exit){
			sendMsg("");
			setVisible(true);
			cc.setVisible(false);
			
		}
	}

	public void connect(){//(소켓)서버연결 요청
		try {
			Socket s = new Socket("192.168.0.188",5353);  //연결 시도
			//			Socket s = new Socket("192.168.0.188",5353);  //연결 시도
			//자신의 pc일 경우 localhost 또는 127.0.0.1로 사용 가능
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//connect

	public void sendMsg(String msg){//서버에게 메시지 보내기
		try {
			os.write((msg+"\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//sendMsg

	public void run(){//서버가 보낸 모든 메시지 읽기	   
		while(true){
			try {
				String msg = br.readLine();
				String msgs[]=msg.split("\\|");
				String protocol = msgs[0];
				switch (protocol) {
				case "200":
					String listData[] = msgs[1].split(",");
					roomInfo.setListData(listData);
					break;
				case "300":
					String test="";
					for(int i=1; i<msgs.length; i++)
						test+=msgs[i];
					cc.ta.append(test+"\n");
					cc.ta.setCaretPosition(cc.ta.getText().length());      //스크롤바 자동 내림
					break;

				default:
					break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}	 
	}//run


	public static void main(String[] args) {
		new MainChat();
	}


}
