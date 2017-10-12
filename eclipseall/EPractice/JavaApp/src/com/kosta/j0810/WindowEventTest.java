package com.kosta.j0810;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventTest extends Frame implements WindowListener{
	
	public WindowEventTest() {
		setTitle("Frame Ã¢´Ý±â");
		setSize(300, 300);
		setVisible(true);
		
		this.addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new WindowEventTest();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
}
