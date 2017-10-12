package com.kosta.j0811;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseTest extends JFrame implements MouseListener{
	JButton jb1;
	
	public MouseTest() {
		jb1 = new JButton("버르트른");
		
		setLayout(new FlowLayout());
		add(jb1);
		
		setSize(300, 300);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jb1.addMouseListener(this);
	}

	public static void main(String[] args) {
		new MouseTest();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}
}
