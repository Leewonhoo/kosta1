package com.kosta.person.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PersonUpdate extends JFrame{

	JLabel la_name, la_age, la_job;	
	public JTextField tf_name, tf_age, tf_job;
	public JButton bt_submit, bt_cancel;

	public PersonUpdate() {
		setTitle("수정폼"); 

		la_name = new JLabel("이름");  
		la_age = new JLabel("나이");  
		la_job = new JLabel("직업");  

		tf_name = new JTextField();
		tf_name.setEditable(false);
		tf_age = new JTextField();
		tf_job = new JTextField();

		bt_submit = new JButton("확인");
		bt_cancel = new JButton("취소");


		la_name.setBounds(30,30,40,30);
		la_age.setBounds(30,80,40,30);
		la_job.setBounds(30,130,40,30);      

		tf_name.setBounds(70,30,80,30);
		tf_age.setBounds(70,80,80,30);
		tf_job.setBounds(70,130,80,30);

		bt_submit.setBounds(30,190,60,30);
		bt_cancel.setBounds(100,190,60,30);

		setLayout(null);
		add(la_name);
		add(la_age);
		add(la_job);
		add(tf_name);      
		add(tf_age);      
		add(tf_job);      
		add(bt_submit);      
		add(bt_cancel);

		setBounds(300,200,200,300);
		setVisible(true);
	}

}
