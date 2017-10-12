package com.kosta.j0811;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionTest extends JFrame implements MouseMotionListener{
	JLabel jlm, jld;
	
	public MouseMotionTest() {
		jlm = new JLabel("Move");
		jld = new JLabel("Drag");
		
		this.setLayout(null);      //null 레이아웃 => 컴포넌트 필요
		
		jlm.setForeground(Color.MAGENTA);
		jlm.setBackground(Color.DARK_GRAY);
		jld.setForeground(Color.WHITE);
		jld.setBackground(Color.BLACK);
		
		jlm.setBounds(10, 10, 80, 80);
//		jld.setBounds(10, 40, 30, 20);
		jld.setSize(80, 80);
		jld.setLocation(60, 60);
		
		jlm.setOpaque(true);
		jld.setOpaque(true);      // 불투명하게 설정
		
		this.add(jlm);
		this.add(jld);
		
		this.setSize(400, 400);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseMotionListener(this);
		addMouseMotionListener(this);
	}
	
	public static void main(String[] args) {
		new MouseMotionTest();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		jld.setText("Move : "+e.getX()+", "+e.getY());
		jld.setLocation(e.getX()-91, e.getY()-115);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		jlm.setText("Drag : "+e.getX()+", "+e.getY());
		jlm.setLocation(e.getX()-91, e.getY()-115);
	}
}
