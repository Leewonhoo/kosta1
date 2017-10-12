package com.kosta.j0811;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMoveTest extends Frame implements ActionListener{

	Panel p1, p2, p3, p12, p22, p32;
	List li1, li2;
	Button bt1, bt2, bt3, bt4;
	TextField tf1, tf2;

	GridLayout gl1, gl2;
	BorderLayout bl1, bl2;

	public ItemMoveTest() {
		gl1 = new GridLayout(1,3);
		gl2 = new GridLayout(6,3,0,30);
		bl1 = new BorderLayout();
		bl2 = new BorderLayout();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p12 = new Panel();
		p22 = new Panel();
		p32 = new Panel();
		li1 = new List();
		li2 = new List();
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		bt1 = new Button("▷");
		bt2 = new Button("▶");
		bt3 = new Button("◁");
		bt4 = new Button("◀");

		this.setLayout(gl1);
		p1.setLayout(bl1);
		p2.setLayout(null);
		p3.setLayout(bl2);
		p2.setBackground(Color.ORANGE);

		p1.add("Center", li1);
		p1.add("South", tf1);

		bt1.setBounds(45, 70, 40, 40);
		bt2.setBounds(45, 160, 40, 40);
		bt3.setBounds(45, 250, 40, 40);
		bt4.setBounds(45, 340, 40, 40);
		p2.add(bt1);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);
		
		p3.add("Center", li2);
		p3.add("South", tf2);

		add(p1);
		add(p2);
		add(p3);

		setTitle("ItemMove");
		setSize(400, 500);
		setVisible(true);

		buonclick();
		tfinput();
		winframe();
		
	}
	
	private void buonclick() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}
	private void tfinput() {
		tf1.addActionListener(this);
		tf2.addActionListener(this);
	}
	private void winframe() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			li2.add(li1.getSelectedItem());
			li1.remove(li1.getSelectedIndex());
		}else if(e.getSource()==bt2) {
			for(int i=0; i<li1.getItemCount(); i++) {
				String sel = li1.getItem(i);
				li2.add(sel);
			}
			li1.removeAll();
		}else if(e.getSource()==bt3) {
			li1.add(li2.getSelectedItem());
			li2.remove(li2.getSelectedIndex());
		}else if(e.getSource()==bt4) {
			for(int i=0; i<li2.getItemCount(); i++) {
				String sel = li2.getItem(i);
				li1.add(sel);
			}
			li2.removeAll();
		}else if(e.getSource()==tf1){
			if(tf1.getText().trim().length()<=0)  //공백 및 엔터 제거
				return;
			li1.add(tf1.getText());
			tf1.setText("");
		}else if(e.getSource()==tf2){
			if(tf2.getText().trim().length()<=0)
				return;
			li2.add(tf2.getText());
			tf2.setText("");
		}else {
		}
	}

	public static void main(String[] args) {
		new ItemMoveTest();
	}

}
