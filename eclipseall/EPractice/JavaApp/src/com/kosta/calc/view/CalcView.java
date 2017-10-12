package com.kosta.calc.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcView extends JFrame{
	JPanel p1, p2;
	public JTextField tf1, tf2;
	public JButton bt1;
	public JLabel la1;
	public JComboBox<String> com1;
	
	public CalcView() {
		p1 = new JPanel();
		p2 = new JPanel();
		tf1 = new JTextField(3);
		tf2 = new JTextField(3);
		bt1 = new JButton("계산");
		la1 = new JLabel();
		com1 = new JComboBox<>();
		
		com1.addItem("+");
		com1.addItem("-");
		com1.addItem("*");
		com1.addItem("/");
		
		setLayout(new GridLayout(2, 1));
		
		p1.add(tf1);
		p1.add(com1);
		p1.add(tf2);
		p1.add(bt1);
		p2.add(la1);
		
		add(p1);
		add(p2);
		
		setBounds(500, 300, 250, 150);
		setResizable(false);
		setTitle("계산기");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
