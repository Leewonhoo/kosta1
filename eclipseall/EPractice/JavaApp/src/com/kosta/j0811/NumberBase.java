package com.kosta.j0811;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NumberBase extends JFrame implements ActionListener{
	JPanel p1, p2, p3, p4;
	JTextField tf;
	JButton bnew, bclr, ban, bout;
	JLabel la2;
	JTextArea ta;
	JScrollPane sp;     //��ũ�ѹ� ǥ��
	int count=1;
	boolean tfstate=true;

	static Vector<Integer> v= new Vector<Integer>();;
	int[] su;

	public NumberBase() {
		su = new int[3];
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		tf = new JTextField(10);
		bnew = new JButton("������");
		bclr = new JButton("�����");
		ban = new JButton("����");
		bout = new JButton("������");
		la2 = new JLabel("�Է�");
		ta = new JTextArea();

		p1.setLayout(new BorderLayout(5, 5));
		p2.setLayout(new GridLayout(5, 1, 0, 20));
		p4.setLayout(new BorderLayout(10, 10));
		p4.setBackground(Color.ORANGE);
		p1.setBackground(Color.ORANGE);
		p2.setBackground(Color.ORANGE);
		p3.setBackground(Color.ORANGE);

		ta.setText("<---- ���� �߱� ���� ---->");

		sp = new JScrollPane(ta);
		p1.add("Center", sp);
		p1.add("South", p3);
		p2.add(bnew);
		p2.add(bclr);
		p2.add(ban);
		p2.add(bout);
		p3.add(la2);
		p3.add(tf);

		p4.add("North", new JLabel(" "));
		p4.add("Center", p1);
		p4.add("East", p2);
		p4.add("West", new JLabel(" "));

		add("Center", p4);

		setTitle("���� �߱� ����");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ta.setEnabled(false);
		Input();
	}

	private void Input() {
		bnew.addActionListener(this);
		bclr.addActionListener(this);
		ban.addActionListener(this);
		bout.addActionListener(this);
		tf.addActionListener(this);

		tf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(tfstate==false)
					JOptionPane.showMessageDialog(tf, "�����ӹ�ư�� ��������");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==bnew) {
			count=1;
			start();
			tfstate=true;
			tf.setEnabled(true);
			tf.requestFocus();
		}else if(e.getSource()==bclr) {
			ta.removeAll();
			ta.setText("<---- ���� �߱� ���� ---->");
		}else if(e.getSource()==ban) {
			ta.append("\n������ "+v.get(0)+v.get(1)+v.get(2)+"�Դϴ�.");
			ta.append("\n�� �� ����ϼ���~~~");
			//			start();
		}else if(e.getSource()==bout) {
			System.exit(0);
		}else if(e.getSource()==tf) {
			int ss=0, bb=0;			
			String in = tf.getText();

			in.matches("[\\d]{3}");    //���� �Ǻ��� �ڸ��� �˻�
			samesumcheck(in);          //���� �Ǻ��� �ڸ��� �˻�, su�� ���� ����

			for(int i=0; i<v.size(); i++) {
				for(int j=0; j<su.length; j++) {
					if(v.get(i)==su[j]) {
						if(i==j) {
							ss++;
							break;
						}
						else {
							bb++;
							break;
						}
					}
				}
			}

			if(ss==3) {
				ta.append("\n"+count+": ["+su[0]+su[1]+su[2]+"] �� "+ss+"S "+bb+"B");
				ta.append("\n�����մϴ�. ���߼̽��ϴ�.");
				JOptionPane.showMessageDialog(this, "�����մϴ�. �������� �����ϼ���.");
				tfstate=false;
				tf.setEnabled(false);
			}else
				ta.append("\n"+count+": ["+su[0]+su[1]+su[2]+"] �� "+ss+"S "+bb+"B");
			count++;
			tf.setText("");
		}
	}

	private static void start() {
		v.removeAllElements();
		v.add(0, (int) (Math.random()*10));
		do {
			v.add(1, (int) (Math.random()*10));
		}while(v.get(0)==v.get(1));
		do {
			v.add(2, (int) (Math.random()*10));
		}while((v.get(0)==v.get(2))||(v.get(1)==v.get(2)));
	}

	private void samesumcheck(String in) {
		for(int i=0; i<in.length(); i++) {
			try {
				String cut = in.trim().substring(i, (i+1));
				su[i]=Integer.parseInt(cut);
				//su[i] = Integer.parseInt(in.trim().charAt(i)-48);
			}
			catch(Exception aa) {
				aa.getMessage();
				JOptionPane.showMessageDialog(this, "3�ڸ� ������ �Է��ϼ���.");
				tf.setText("");
				return;
			}
		}

		if(su[0]==su[1]) {
			JOptionPane.showMessageDialog(this, "�ߺ� : 1, 2 : "+su[0]+" "+su[1]);
			return;
		}else if(su[0]==su[2]) {
			JOptionPane.showMessageDialog(this, "�ߺ� : 1, 3 : "+su[0]+" "+su[2]);
			return;
		}else if(su[2]==su[1]) {
			JOptionPane.showMessageDialog(this, "�ߺ� : 2, 3 : "+su[1]+" "+su[2]);
			return;
		}else {}
	}

	public static void main(String[] args) {
		start();
		new NumberBase();
	}

}
