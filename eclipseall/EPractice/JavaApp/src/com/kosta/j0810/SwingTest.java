package com.kosta.j0810;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	JButton bt1;
	
	public SwingTest() {
		bt1 = new JButton("<html><font size=14 color=red face=±Ã¼­Ã¼>jbutton</font></html>");
		this.add(bt1);
		this.setSize(300,300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}
}
