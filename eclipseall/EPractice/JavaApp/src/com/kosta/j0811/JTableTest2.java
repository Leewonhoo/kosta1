package com.kosta.j0811;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest2 extends JFrame implements ActionListener{
	
	JFrame f;
	JPanel p1, p2;
	JTable ta;
	JScrollPane sp;
	JButton bt_add, bt_del, bt_up, bt_sel, bt_end;
	DefaultTableModel dtm;
	
	InputFrom form;
	
	int no =1;
	
	public JTableTest2() {
		f=this;
		form = new InputFrom();
		p1 = new JPanel();
		p2 = new JPanel();
		bt_add = new JButton("�߰�");
		bt_del = new JButton("����");
		bt_up = new JButton("����");
		bt_sel = new JButton("�˻�");
		bt_end = new JButton("����");

		Object data[][] = new Object[0][4];
		String []columnNames = {"��ȣ","�̸�","����","����"};
		dtm = new DefaultTableModel(data, columnNames);
		ta = new JTable(dtm);
		
		sp = new JScrollPane(ta);
				
		p1.setLayout(null);
		sp.setBounds(10,10,450,300);
		
		p1.add(sp);
		p2.add(bt_add);
		p2.add(bt_sel);
		p2.add(bt_up);
		p2.add(bt_del);
		p2.add(bt_end);
		add("Center", p1);
		add("South", p2);
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		eventUp();
	}
	
	private void eventUp() {
		//JTable ���κ�
		bt_add.addActionListener(this);
		bt_sel.addActionListener(this);
		bt_up.addActionListener(this);
		bt_del.addActionListener(this);
		bt_end.addActionListener(this);
		
		//InputForm �̺�Ʈ
		form.bt1.addActionListener(this);
		form.bt2.addActionListener(this);
		form.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//������ class�̱� ������ this ��� �Ұ���
				f.setVisible(true);
				form.setVisible(false);
			}
		});
	}
	
	public static void main(String[] args) {
		new JTableTest2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==bt_add) {
			this.setVisible(false);
			form.setVisible(true);
		}else if(ob==bt_sel) {
			
		}else if(ob==bt_del) {
			int ch = JOptionPane.showConfirmDialog(this, "����?");
			if(ch==0) {
				int row = ta.getSelectedRow();
				if(row==-1)
					JOptionPane.showMessageDialog(this, "�������ּ���");
				else
					dtm.removeRow(row);
			}else if(ch==1) {
				JOptionPane.showMessageDialog(this, "���� �ź�");
			}else {
				JOptionPane.showMessageDialog(this, "���");
			}
		}else if(ob==bt_up) {
			
		}else if(ob==bt_end) {
			System.exit(0);
		}else if(ob==form.bt1) {
			String name = form.tf1.getText();
			int age = Integer.parseInt(form.tf2.getText());
			String job = form.tf3.getText();
			Object[] rowData = {no++, name, age, job};
			dtm.addRow(rowData);
			setVisible(true);
			form.setVisible(false);
		}else if(ob==form.bt2) {
			
		}
	}

}
