package com.kosta.j0816;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tvcontribution extends JFrame{
	JLabel la1, la2;
	
	public Tvcontribution() {
		la1 = new JLabel();
		la2 = new JLabel();
		
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Account acc = new Account();
		
		Customer[] c = new Customer[5];
		for(int i=0; i<5; i++) {
			c[i]=new Customer(acc);
			c[i].start();
		}
		
		try {
			for(int i=0; i<c.length; i++) {
				c[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ÃÑ ¾×¼ö : "+acc.getAccount());
	}
}
