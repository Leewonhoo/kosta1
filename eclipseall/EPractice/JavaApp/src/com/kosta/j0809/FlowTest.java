package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
	//�ʿ��� ������Ʈ, �����̳� ����
	Button b1, b2, b3, b4;
	Frame f;
	FlowLayout fl;
	
	public FlowTest() {
		//������Ʈ, �����̳� �ʱ�ȭ
		b1=new Button("��ư1");
		b2=new Button("��ư2");
		b3=new Button("��ư3");
		b4=new Button("��ư4");
		f=new Frame("�÷ο췹�̾ƿ�");
		
		//�Ӽ�����
		fl = new FlowLayout();
		f.setLayout(fl);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		//������(�޼ҵ� ȣ��- ������ũ�� �� ���̱�)
		f.setSize(300, 300);
		f.setVisible(true);
		
	}//������
	
	public static void main(String[] args) {
//		FlowTest ft = new FlowTest();
		new FlowTest();
	}
}
