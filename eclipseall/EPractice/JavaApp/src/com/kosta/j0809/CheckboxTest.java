package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

public class CheckboxTest {
	
	Frame f1;
	Panel p1, p2;
	Checkbox c1, c2, cc1, cc2;
	Label l1;
	TextArea ta1;
	
	public CheckboxTest() {
		CheckboxGroup a = new CheckboxGroup();
		
		f1 = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		c1 = new Checkbox("사과");
		c2 = new Checkbox("딸기");
		cc1 = new Checkbox("남자", false, a);      //awt. checkbox로 swing. radiobutton 만들기
		cc2 = new Checkbox("여자", false, a);
		l1 = new Label("성별");
		ta1 = new TextArea();
		
		f1.setLayout(new BorderLayout());
		p1.setBackground(Color.GRAY);
		p2.setBackground(Color.GREEN);
		
		p1.add(c1);
		p1.add(c2);
		p2.add(l1);
		p2.add(cc1);
		p2.add(cc2);
		f1.add("North", p1);
		f1.add("Center", ta1);
		f1.add("South", p2);
		
		f1.setSize(500, 500);
		f1.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckboxTest();
	}
}
