package com.kosta.j0811;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputFrom extends JFrame{
	JLabel la1, la2, la3;
	JTextField tf1, tf2, tf3;
	JButton bt1, bt2;
	
	public InputFrom() {
		la1 = new JLabel("이름");
		la2 = new JLabel("나이");
		la3 = new JLabel("직업");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		bt1 = new JButton("확인");
		bt2 = new JButton("취소");
		
		la1.setBounds(30, 30, 50, 30);
		la2.setBounds(30, 80, 50, 30);
		la3.setBounds(30, 130, 50, 30);
		tf1.setBounds(70, 30, 80, 30);
		tf2.setBounds(70, 80, 80, 30);
		tf3.setBounds(70, 130, 80, 30);
		bt1.setBounds(30, 190, 60, 30);
		bt2.setBounds(100, 190, 60, 30);
		
		setLayout(null);
		add(la1);
		add(la2);
		add(la3);
		add(tf1);
		add(tf2);
		add(tf3);
		add(bt1);
		add(bt2);
		
		setSize(200, 300);
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new InputFrom();
	}

}
