package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
	TextField tf1, tf2;
	TextArea ta;
	Label la;
	BorderLayout br;
	Panel p1, p2;
	
	public TextFieldAreaTest() {
		tf1=new TextField(20);
		tf2=new TextField(15);
		ta=new TextArea();
		la=new Label("파일이름:");
		br=new BorderLayout();
		p1=new Panel();
		p2=new Panel();
		
		this.setLayout(br);
		this.setSize(400, 400);
		this.setTitle("TextFieldArea테스트");
		
		this.add("North", p1);
		p1.add(tf1);
		this.add("Center", ta);
		this.add("South", p2);
		p2.add("South", la);
		p2.add("South", tf2);
		
		p1.setBackground(new Color(240,128,128));
		p2.setBackground(new Color(140,128,128));
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TextFieldAreaTest();
	}

}
