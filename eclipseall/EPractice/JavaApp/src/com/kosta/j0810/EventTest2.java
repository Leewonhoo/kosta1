package com.kosta.j0810;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest2 extends Frame implements ActionListener{
	
	Button bt1, bt2, bt3;
	int count =0;
	
	public EventTest2() {
		bt1 = new Button("안녕");
		bt1.setActionCommand("1번버튼은 안녕");
		bt2 = new Button("타이틀");
		bt3 = new Button("종료");
		
		this.setLayout(new FlowLayout());
		
		add(bt1);
		add(bt2);
		add(bt3);
		
		this.setTitle("이벤트");
		this.setSize(300, 300);
		this.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {     //이벤트 처리부
		String command = e.getActionCommand();
			//버튼, 라벨의 이름, setActionCommand("")의 값으로 처리
			//TextField 같은 경우 입력한 값 호출
		Object ob = e.getSource();     //모든 이벤트 핸들러 처리가능
			//이벤터 소스의 reference
		
		System.out.println(command);
			//여기서는 버튼의 이름 호출, setActionCommand 값 호출
		
		if(ob==bt1) {                        //getSource() 사용
			System.out.println("안녕");
			count++;
		}else if(command.equals("타이틀")) {  //getActionCommand() 사용
			setTitle("누른횟수"+count);
		}else if(ob==bt3){
			System.exit(0);
		}else {
		}
	}

	public static void main(String[] args) {
		new EventTest2();
	}

}
