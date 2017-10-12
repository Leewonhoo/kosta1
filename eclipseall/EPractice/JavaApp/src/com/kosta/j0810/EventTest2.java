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
		bt1 = new Button("�ȳ�");
		bt1.setActionCommand("1����ư�� �ȳ�");
		bt2 = new Button("Ÿ��Ʋ");
		bt3 = new Button("����");
		
		this.setLayout(new FlowLayout());
		
		add(bt1);
		add(bt2);
		add(bt3);
		
		this.setTitle("�̺�Ʈ");
		this.setSize(300, 300);
		this.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {     //�̺�Ʈ ó����
		String command = e.getActionCommand();
			//��ư, ���� �̸�, setActionCommand("")�� ������ ó��
			//TextField ���� ��� �Է��� �� ȣ��
		Object ob = e.getSource();     //��� �̺�Ʈ �ڵ鷯 ó������
			//�̺��� �ҽ��� reference
		
		System.out.println(command);
			//���⼭�� ��ư�� �̸� ȣ��, setActionCommand �� ȣ��
		
		if(ob==bt1) {                        //getSource() ���
			System.out.println("�ȳ�");
			count++;
		}else if(command.equals("Ÿ��Ʋ")) {  //getActionCommand() ���
			setTitle("����Ƚ��"+count);
		}else if(ob==bt3){
			System.exit(0);
		}else {
		}
	}

	public static void main(String[] args) {
		new EventTest2();
	}

}
