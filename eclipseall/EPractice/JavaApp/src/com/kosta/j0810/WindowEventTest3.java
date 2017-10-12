package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventTest3 extends Frame{
	
	public WindowEventTest3() {
		setTitle("Frame Ã¢´Ý±â3");
		setSize(300, 300);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new WindowEventTest3();
	}
	
}
