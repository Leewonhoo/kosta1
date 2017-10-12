package com.kosta.j0817;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{

	JPanel p1, p2;
	JTextArea ta;
	JScrollPane sp;
	JTextField tf;
	JLabel la;
	JButton bt;

	//소켓입출력 객체
	BufferedReader br;
	OutputStream os;
	Service c;
	String nickname;

	public ChatClient() {
		p1 = new JPanel();
		p2 = new JPanel();
		ta = new JTextArea();
		sp = new JScrollPane(ta);
		tf = new JTextField(15);
		la = new JLabel("입력");
		bt = new JButton("닉변경");

		p1.add(sp);
		p2.add(la);
		p2.add(tf);
		p2.add(bt);
		add("Center", sp);
		add("South", p2);

		setTitle("Chat");
		setBounds(300, 300, 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		conpro();
		/*try {
			nickname = JOptionPane.showInputDialog(this, "닉네임 설정");
			os.write((nickname+"\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		nickname = JOptionPane.showInputDialog(this, "닉네임 설정");
		sendmsg(nickname);
		new Thread(this).start();
		event();
		tf.requestFocus();
	}

	private void event() {
		tf.addActionListener(this);
		bt.addActionListener(this);
	}

	public void conpro() {
		try {
			Socket s = new Socket("192.168.0.188", 6666);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendmsg(String msg) {
		try {
			os.write(("100|"+msg+"\n").getBytes());
			System.out.println("send msg"+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void nickchange() {
		try {
			String cnick = JOptionPane.showInputDialog(this, "닉네임 설정");
			//os.write(("200|"+cnick+"\n").getBytes());
			sendmsg(("200|"+cnick+"\n"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void run() {      //서버 데이터를 별도로 받기 위해 쓰레드 사용
		while(true) {
			try {
				String msg = br.readLine();
				ta.append(msg+"\n");

				ta.setCaretPosition(ta.getText().length());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tf) {
			String msg = tf.getText().trim();
			sendmsg(msg);
			//ta.append(msg+"\n");
			tf.setText("");
		}else if(e.getSource()==bt) {
			nickchange();			
		}
	}

	public static void main(String[] args) {
		new ChatClient();
	}

}
