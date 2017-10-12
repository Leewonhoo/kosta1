package com.kosta.j0816;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame implements Runnable{

	JPanel p1, p2;
	JTable ta;
	String[][] infor;
	JScrollPane sp;
	JLabel la1;
	Calendar cal;

	int year;
	int month;
	int day;
	int hour;
	int min;
	int sec;
	String time;

	public JTableTest() {
		infor = new String[5][5];
		p1 = new JPanel();
		p2 = new JPanel();
		la1 = new JLabel("Hi");

		Object[][] rowData = { {"a",1}, {"b",2}, {"c",3}};
		String[] columnNames = {"abc","num"};
		ta = new JTable(rowData, columnNames);
		
		Thread t = new Thread(this);
		t.start();

		sp = new JScrollPane(ta);

		p1.setLayout(null);
		sp.setBounds(10,10,450,300);

		p1.add(sp);
		p2.add(la1);
		add("Center", p1);
		add("North", p2);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void information() {
		for(int i=0; i<infor.length; i++) {
			for(int j=0; j<infor[i].length; j++) {
				infor[i][j]="a";
			}
		}
	}
	
	public void run() {
		while(true) {
			cal = new GregorianCalendar();
			year = cal.get(cal.YEAR);
			month = cal.get(cal.MONTH)+1;
			day = cal.get(cal.DATE);
			hour = cal.get(cal.HOUR);
			min = cal.get(cal.MINUTE);
			sec = cal.get(cal.SECOND);
			time = year+"년 "+month+"월 "+day+"일 "+hour+"시 "+min+"분 "+sec+"초";
			la1.setText(time);
		}
	}

	public static void main(String[] args) {
		new JTableTest();
	}

}
