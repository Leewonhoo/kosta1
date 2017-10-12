package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest extends Frame{
	//�ʿ��� ������Ʈ, �����̳� ����
	Button b1, b2, b3, b4, b5;
	BorderLayout bl;

	public BorderTest(String title) {
		//���� Ŭ���� ������ ȣ��
		super(title);
		//this.setTitle("�������̾ƿ�");

		//������Ʈ, �����̳� �ʱ�ȭ
		b1=new Button("��ư1");
		b2=new Button("��ư2");
		b3=new Button("��ư3");
		b4=new Button("��ư4");
		b5=new Button("��ư5");

		//�Ӽ�����
		//bl = new BorderLayout();
		bl = new BorderLayout(50, 50);
		
		this.setLayout(bl);   //frame���κ��� ��ӹ����Ƿ� this ���
		this.add(b1, bl.CENTER);
		this.add("North", b2);
		this.add(b3, bl.PAGE_END);
		add(b4, bl.EAST);
		//this�� �����Ͽ��� ���� Ŭ�������� ������� �ʱ� ������
		//������ִ� Frame���� �ö󰣴�. ���� ���� ����.
		add(b5, bl.LINE_START);

		//������(�޼ҵ� ȣ��- ������ũ�� �� ���̱�)
		this.setSize(300,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderTest("�������̾ƿ�");    //new Frame ����
	}

}
