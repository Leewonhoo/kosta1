package com.kosta.j0816;

import javax.swing.JFrame;

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i+"first thread");
		}
	}//run
}

class MyThread2 extends JFrame implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(500);   //implment ���� ���� �ʿ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i+"second thread");
		}
	}
	
}

public class ThreadTest {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		MyThread2 mt2 = new MyThread2();
		
//		mt.run();      //��ȯ void    //ù��° �޼ҵ尡 ������ �ι�° �޼ҵ� ����
//		mt2.run();
		
		mt.start();    //��ȯ thread  //������ ������� ������ ȣ��(���� ����)
		Thread t = new Thread(mt2);
		t.start();
	}
}
