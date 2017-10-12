package com.kosta.j0810;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CardLayoutTest extends Frame implements ActionListener{
	
	Panel p1, p2, p3, py, pb, pr;
	Button bt1, bt2, bt3;
	CardLayout cl;
	
	public CardLayoutTest() {
		cl = new CardLayout();
		bt1 = new Button("next");
		bt2 = new Button("next");
		bt3 = new Button("next");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		py = new Panel();
		pb = new Panel();
		pr = new Panel();
		
		setLayout(cl);
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		
		py.setBackground(Color.YELLOW);
		pb.setBackground(Color.BLUE);
		pr.setBackground(Color.RED);
		
		p1.add("Center", py);
		p1.add("South", bt1);
		p2.add("Center", pb);
		p2.add("South", bt2);
		p3.add("Center", pr);
		p3.add("South", bt3);
		
		add("a1", p1);
		add("a2", p2);
		add("a3", p3);
		
		cl.show(this, "a1");  //ÃÊ±â
		
		setTitle("CardLayout");
		setSize(300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new CardLayoutTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			cl.show(this, "a2");
			System.out.println("ÆÄ¶û");
		}else if(e.getSource()==bt2) {
			cl.show(this, "a3");
			System.out.println("»¡°­");
		}else if(e.getSource()==bt3) {
			cl.show(this, "a1");
			System.out.println("³ë¶û");
		}else {
			
		}
		
	}
}
