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
		bt_add = new JButton("추가");
		bt_del = new JButton("삭제");
		bt_up = new JButton("수정");
		bt_sel = new JButton("검색");
		bt_end = new JButton("종료");

		Object data[][] = new Object[0][4];
		String []columnNames = {"번호","이름","나이","직업"};
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
		//JTable 메인뷰
		bt_add.addActionListener(this);
		bt_sel.addActionListener(this);
		bt_up.addActionListener(this);
		bt_del.addActionListener(this);
		bt_end.addActionListener(this);
		
		//InputForm 이벤트
		form.bt1.addActionListener(this);
		form.bt2.addActionListener(this);
		form.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//무명의 class이기 때문에 this 사용 불가능
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
			int ch = JOptionPane.showConfirmDialog(this, "삭제?");
			if(ch==0) {
				int row = ta.getSelectedRow();
				if(row==-1)
					JOptionPane.showMessageDialog(this, "선택해주세요");
				else
					dtm.removeRow(row);
			}else if(ch==1) {
				JOptionPane.showMessageDialog(this, "삭제 거부");
			}else {
				JOptionPane.showMessageDialog(this, "취소");
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
