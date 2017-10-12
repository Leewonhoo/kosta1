package com.kosta.j0811;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class JCheckBoxTest extends JFrame{
	JPanel p1;
	JCheckBox cb1, cb2, cb3;
	
	public JCheckBoxTest() {
		ImageIcon icon1 = new ImageIcon("image/left.GIF");
		ImageIcon icon2 = new ImageIcon("image/leftRollover.GIF");
		ImageIcon icon3 = new ImageIcon("image/leftDown.GIF");
		ImageIcon icon4 = new ImageIcon("image/RIGHT.GIF");
		ImageIcon icon5 = new ImageIcon("image/rightRollover.GIF");
		ImageIcon icon6 = new ImageIcon("image/rightDown.GIF");
		
		p1 = new JPanel();
		cb1 = new JCheckBox("üũ�ڽ�1", icon1);
		cb1.setRolloverIcon(icon2);
		cb1.setSelectedIcon(icon3);
		cb2 = new JCheckBox("üũ�ڽ�2", icon4);
		cb2.setRolloverIcon(icon5);
		cb2.setSelectedIcon(icon6);
		cb3 = new JCheckBox("üũ�ڽ�3");
		
		cb2.setToolTipText("This is cb2!!");
		p1.setLayout(new GridLayout(3,1));
		p1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"�г� Ÿ��Ʋ"));
//		p1.setBorder(new BevelBorder(BevelBorder.RAISED));   //�簢
//		p1.setBorder(new BevelBorder(BevelBorder.LOWERED));  //����
		
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		this.add(p1);
		
		this.setTitle("JFrame JCheckBox Test");
		this.setSize(300, 300);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this.EXIT_ON_CLOSE
	}
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}
