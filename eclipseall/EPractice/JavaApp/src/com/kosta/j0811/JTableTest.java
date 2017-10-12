package com.kosta.j0811;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
	
	JPanel p1;
	JTable ta;
	String[][] infor;
	JScrollPane sp;
	
	public JTableTest() {
		infor = new String[5][5];
		p1 = new JPanel();
		
		/*ta = new JTable(10,10);
		  information();
		
		for(int i=0; i<infor.length; i++) {
			for (int j = 0; j < infor[i].length; j++) {
				ta.setValueAt(infor[i][j], i, j);
			}
		}*/
		
		Object[][] rowData = { {"a",1}, {"b",2}, {"c",3}};
		String[] columnNames = {"abc","num"};
		ta = new JTable(rowData, columnNames);
			
		sp = new JScrollPane(ta);
				
		p1.setLayout(null);
		sp.setBounds(10,10,300,200);
		
		p1.add(sp);
		add(p1);
		
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
	
	public static void main(String[] args) {
		new JTableTest();
	}

}
