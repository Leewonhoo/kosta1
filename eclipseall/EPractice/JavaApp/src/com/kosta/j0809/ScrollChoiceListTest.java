package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

public class ScrollChoiceListTest extends Frame{

	GridLayout gl;
	Panel p11, p12, p13, p21, p31, pt, pc, pb, p121, p122;
	Label la1;
	Scrollbar s1;
	Choice c1;
	List li1;

	public ScrollChoiceListTest() {
		gl = new GridLayout(3, 1);
		pt = new Panel();
		pc = new Panel();
		pb = new Panel();
		p11 = new Panel();
		p12 = new Panel();
		p13 = new Panel();
		p21 = new Panel();
		p121 = new Panel();
		p122 = new Panel();
		p31 = new Panel();
		la1 = new Label("����");
		s1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 1, 50);
			// 0: ����ũ�ѹ�, 1: ������ũ�ѹ�
			//����, ������ġ, �ѹ��̵� ũ��, �ּ�, �ִ�
		c1 = new Choice();
		li1 = new List(3, true);   //5���� �����ָ� ���� ���� ����
		
		this.setLayout(gl);
		
		pt.setLayout(gl);
		pt.setBackground(Color.RED);
		p12.setLayout(new BorderLayout());
		p122.setLayout(new BorderLayout());
		p121.add(la1);
		p122.add("Center", s1);
		p12.add("West", p121);
		p12.add("Center", p122);
		pt.add(p11);
		pt.add(p12);
		pt.add(p13);
		
		pc.setLayout(gl);
		pc.setBackground(Color.GREEN);
		p21.add(c1);
		pc.add(p21);
		
		c1.add("����");
		c1.add("����");
		c1.add("�뱸");
		c1.add("�λ�");
		c1.add("���");
		c1.add("����");
		
		
		pb.setLayout(gl);
		p31.add(li1);
		pb.add(p31);
		
		li1.add("������");
		li1.add("�౸");
		li1.add("�豸");
		li1.add("�߱�");
		li1.add("��");
		li1.add("����");
		
		
		add(pt);
		add(pc);
		add(pb);
		
		this.setSize(600, 700);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ScrollChoiceListTest();
	}

}
