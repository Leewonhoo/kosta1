package com.kosta.j0811;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingDialogTest extends JFrame implements ActionListener{

	JButton bt1, bt2, bt3;

	public SwingDialogTest() {
		bt1 = new JButton("message");
		bt2 = new JButton("input");
		bt3 = new JButton("confirm");

		setLayout(new FlowLayout());

		add(bt1);
		add(bt2);
		add(bt3);

		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}

	public static void main(String[] args) {
		new SwingDialogTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			JOptionPane.showMessageDialog(this, "메시지Dialog");
		}else if(e.getSource()==bt2) {
			String result = JOptionPane.showInputDialog(this, "입력Dialog");
			System.out.println("결과 : "+ result);
			if(result!=null && result.trim().length()>0)
				JOptionPane.showMessageDialog(this, result);
		}else if(e.getSource()==bt3) {
			int result = JOptionPane.showConfirmDialog(this, "확인Dialog");
			System.out.println(result);
			if(result==0) {
				JOptionPane.showMessageDialog(this, "예~~~~");
			}else if(result==1) {
				JOptionPane.showMessageDialog(this, "아니오~~~");
			}else {
				JOptionPane.showMessageDialog(this, "취소~~~~~");
			}
		}
	}

}
