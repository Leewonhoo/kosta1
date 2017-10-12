package com.kosta.j0810;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuEventTest implements ItemListener{
	Frame f;
	Panel pt, pc, pb;
	CheckboxGroup bap;
	Checkbox b1, b2, b3, i1, i2, i3;
	TextArea ta;
	Choice c;
	GridLayout gl;

	public MenuEventTest() {
		f = new Frame();
		pt = new Panel();
		pc = new Panel();
		pb = new Panel();
		bap = new CheckboxGroup();
		b1 = new Checkbox("아침", false, bap);
		b2 = new Checkbox("점심", false, bap);
		b3 = new Checkbox("저녁", false, bap);
		i1 = new Checkbox("돼지바", false);
		i2 = new Checkbox("보석바", false);
		i3 = new Checkbox("수박바", false);
		ta = new TextArea();
		c = new Choice();
		gl = new GridLayout(2, 3);

		pt.setLayout(gl);
		pt.setBackground(Color.ORANGE);
		pb.setBackground(Color.PINK);
		
		c.add(b1.getLabel());
		c.add(b2.getLabel());
		c.add(b3.getLabel());

		pt.add(b1);
		pt.add(b2);
		pt.add(b3);
		pt.add(i1);
		pt.add(i2);
		pt.add(i3);
		pc.add(ta);
		pb.add(c);
		f.add("North", pt);
		f.add("Center", pc);
		f.add("South", pb);

		f.setSize(500, 300);
		f.setVisible(true);

		winframe();
		button();
	}

	private void button() {
		b1.addItemListener(this);
		b2.addItemListener(this);
		b3.addItemListener(this);
		i1.addItemListener(this);
		i2.addItemListener(this);
		i3.addItemListener(this);
		c.addItemListener(this);
	}
	
	private void print(String name) {
		boolean i1stat=i1.getState();
		boolean i2stat=i2.getState();
		boolean i3stat=i3.getState();
		ta.setText("\t\t\t\t*** "+name+" ***\n");
		ta.append("\t\t\t1."+i1.getLabel()+" : "+i1stat+"\n");
		ta.append("\t\t\t2."+i2.getLabel()+" : "+i2stat+"\n");
		ta.append("\t\t\t3."+i3.getLabel()+" : "+i3stat+"\n");
	}

	private void winframe() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox ch = bap.getSelectedCheckbox();
		if(e.getSource()==c){
			print(c.getSelectedItem().toString());
		}
		
		if(e.getSource()==b1) {
			print(b1.getLabel());
			c.select(b1.getLabel());
		}else if(e.getSource()==b2) {
			print(b2.getLabel());
			c.select(b2.getLabel());
		}else if(e.getSource()==b3) {
			print(b3.getLabel());
			c.select(b3.getLabel());
		}else if(e.getSource()==i1) {
			print(ch.getLabel());
		}else if(e.getSource()==i2) {
			print(ch.getLabel());
		}else if(e.getSource()==i3) {
			print(ch.getLabel());
		}else if(e.getSource()==c){
			System.out.println("초이스?");
			String cc= c.getSelectedItem();
			if(cc.equals(b1.getLabel()))
				b1.setState(true);
			else if(cc.equals(b2.getLabel()))
				b2.setState(true);
			else
				b3.setState(true);
		}		
		
	}

	public static void main(String[] args) {
		new MenuEventTest();
	}





}
