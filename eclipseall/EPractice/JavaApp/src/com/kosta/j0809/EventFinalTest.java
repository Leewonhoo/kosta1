package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventFinalTest extends Frame implements ActionListener{
	Panel p1, p2, p3, p4, p5;
	Button bt1, bt2, bt3, bt4, bt5;
	BorderLayout lay, a;
	
	public EventFinalTest() {
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		bt1 = new Button("버1");
		bt2 = new Button("버2");
		bt3 = new Button("버3");
		bt4 = new Button("버4");
		bt5 = new Button("버5");

		p1.setLayout(new BorderLayout());		
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		p4.setLayout(new BorderLayout());
		p5.setLayout(new BorderLayout());
		
		p1.add("Center", bt1);
		p2.add("Center", bt2);
		p3.add("Center", bt3);
		p4.add("Center", bt4);
		p5.add("Center", bt5);
		
		this.add("North", p1);
		this.add("West", p2);
		this.add("Center", p3);
		this.add("East", p4);
		this.add("South", p5);
		
		this.setSize(500, 500);
		this.setVisible(true);
		bt1.addActionListener(this);        //addActionListener : bt1의 메소드
		bt2.addActionListener(new EventFinal());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("this class");
	}
	
	public static void main(String[] args) {
		new EventFinalTest();
	}

	

}
