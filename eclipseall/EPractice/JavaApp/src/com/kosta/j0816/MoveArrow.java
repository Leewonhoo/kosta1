package com.kosta.j0816;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveArrow extends JFrame implements ActionListener, Runnable{
	JLabel la;
	ImageIcon ii;
	JButton bt_s, bt_p;
	int x, y;
	boolean aa;

	public MoveArrow() {
		aa=true;
		ii = new ImageIcon("image/right.gif");
		la = new JLabel(ii);
		bt_s = new JButton("시작");
		bt_p = new JButton("중지");

		setLayout(null);
		add(la);
		add(bt_s);
		add(bt_p);
		la.setBounds(0, 0, 50, 50);
		bt_s.setBounds(260, 500, 70, 50);
		bt_p.setBounds(340, 500, 70, 50);
		setBounds(300, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bt_s.addActionListener(this);
		bt_p.addActionListener(this);
	}

	@Override
	public void run() {
		try {
//			while(aa) {
//				Thread.sleep(500);
//				x+=50;
//				if(x>=700) {
//					x=0;
//					y+=50;
//					la.setLocation(x, y);
//				}else if(y>=550) {
//					aa=false;
//				}else
//					la.setLocation(x, y);
//			}
			while(aa) {
				Thread.sleep(20);
				x+=4;
				if(x>=630) {
					while(aa) {
						if(y<450) {
						Thread.sleep(20);
						y+=4;
						la.setLocation(x, y);
						}
					}
				}else
					la.setLocation(x, y);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		if(e.getSource()==bt_s) {
			aa=true;
			t.start();
			//new Thread(this).start();
		}else if(e.getSource()==bt_p) {
			//new Thread(this).interrupt();
//			t.interrupt();
			aa=false;
		}
	}

	public static void main(String[] args) {
		new MoveArrow();
	}

}
