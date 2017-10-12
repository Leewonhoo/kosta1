package com.kosta.j0810;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloEvent extends Frame implements ActionListener, ItemListener{
	
	Panel pt, pc, pb;
	TextField tf1;
	CheckboxGroup cg;
	Checkbox cb1, cb2, cb3;
	Button bt1, bt2, bt3;
	
	public HelloEvent() {
		pt = new Panel();
		pc = new Panel();
		pb = new Panel();
		tf1 = new TextField(20);
		cg = new CheckboxGroup();
		cb1 = new Checkbox("자바초급", false, cg);
		cb2 = new Checkbox("자바중급", false, cg);
		cb3 = new Checkbox("자바고급", false, cg);
		bt1 = new Button("hello");
		bt2 = new Button("clear");
		bt3 = new Button("exit");
		
		setTitle("HelloEvent");
		pc.setLayout(new GridLayout(3, 1));
		pt.setBackground(Color.ORANGE);
		pc.setBackground(Color.WHITE);
		pb.setBackground(Color.PINK);
		
		pt.add(tf1);
		
		pc.add(cb1);
		pc.add(cb2);
		pc.add(cb3);
		
		pb.add(bt1);
		pb.add(bt2);
		pb.add(bt3);
		
		add("North", pt);
		add("Center", pc);
		add("South", pb);
		
		setSize(200, 200);
		setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		
	}
	
	public static void main(String[] args) {
		new HelloEvent();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			Checkbox ch = cg.getSelectedCheckbox();
			tf1.setText(ch.getLabel());
		}else if(e.getSource()==bt2) {
			tf1.setText("");
		}else if(e.getSource()==bt3) {
			System.exit(0);
		}else {
			
		}	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox ch = cg.getSelectedCheckbox();
		tf1.setText(ch.getLabel());
	}

}
