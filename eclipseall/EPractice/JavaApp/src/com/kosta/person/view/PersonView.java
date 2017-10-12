package com.kosta.person.view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosta.person.model.PersonModel;

public class PersonView extends JFrame{

	public JTable table;
	JScrollPane scroll;
	public JButton bt_add, bt_na, bt_findALL, bt_up, bt_del, bt_exit;
	JPanel southp;

	public DefaultTableModel dtm;

	public PersonView() {
		setTitle("메인뷰");

		Object data[][]=new Object[0][4];
		String []columnNames = {"번호","이름","나이","직업"};
		dtm= new DefaultTableModel(data, columnNames);
		table = new JTable(dtm);		
		scroll = new JScrollPane(table); //스크롤바 지원하는 JTable

		bt_add = new JButton("추가");
		bt_na = new JButton("이름검색");
		bt_findALL = new JButton("전체검색");
		bt_up = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_exit = new JButton("종료");

		southp = new JPanel();
		southp.add(bt_add);
		southp.add(bt_na);
		southp.add(bt_findALL);
		southp.add(bt_up);
		southp.add(bt_del);
		southp.add(bt_exit);

		add(scroll);//add("Center",scroll);//(table);
		add("South",southp);

		setBounds(300,200,500,400);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void message(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	public String inmessage(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	public int conmessage(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}
}
