package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame implements ActionListener{
	Button bt1;
	//ActionListener -->  ActionPerformed()
	
	public EventTest() {
		bt1 = new Button("�̺�Ʈ ��ư");
		setLayout(new FlowLayout());
		add(bt1);
		
		setTitle("Event Test");
		setSize(300,300);
		setVisible(true);
		
		//�̺�Ʈ �ҽ�.add�������̽���(�ڵ鷯 ��ġ)
		bt1.addActionListener(this);          //���� Ŭ������ actionperformed
		bt1.addActionListener(new A());       //�ٸ� Ŭ������ actionperformed
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ ó����(event handler)   //�������
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventTest();
	}

}
