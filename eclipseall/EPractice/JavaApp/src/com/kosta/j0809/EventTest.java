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
		bt1 = new Button("이벤트 버튼");
		setLayout(new FlowLayout());
		add(bt1);
		
		setTitle("Event Test");
		setSize(300,300);
		setVisible(true);
		
		//이벤트 소스.add인터페이스명(핸들러 위치)
		bt1.addActionListener(this);          //같은 클래스의 actionperformed
		bt1.addActionListener(new A());       //다른 클래스의 actionperformed
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트 처리부(event handler)   //기능정의
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventTest();
	}

}
