package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventTest2 extends WindowAdapter{
	Frame f;
	
	public WindowEventTest2() {
		f = new Frame();
		
		f.setTitle("Frame Ã¢´Ý±â2");
		f.setSize(300, 300);
		f.setVisible(true);
		
		f.addWindowListener(this);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowEventTest2();
	}	
}
