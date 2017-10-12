package com.kosta.j0811;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame{
	
	JRadioButton jrb1, jrb2, jrb3;
	ButtonGroup bg;
	ImageIcon icon1, icon2, icon3;
	
	public JRadioButtonTest() {
		icon1 = new ImageIcon("image/left.GIF");
		icon2 = new ImageIcon("image/leftRollover.GIF");
		icon3 = new ImageIcon("image/leftDown.GIF");
		
		bg = new ButtonGroup();
		jrb1 = new JRadioButton("1라디오", icon1);
		jrb2 = new JRadioButton("2라디오");
		jrb3 = new JRadioButton("3라디오");		
		
		setLayout(new GridLayout(3, 1));
		jrb1.setPressedIcon(icon2);
		jrb1.setRolloverIcon(icon3);
		
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		
		add(jrb1);
		add(jrb2);
		add(jrb3);
		
		setSize(300, 300);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JRadioButtonTest();
	}
}
