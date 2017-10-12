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
				Thread.sleep(500);   //implment 사용시 선언 필요
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
		
//		mt.run();      //반환 void    //첫번째 메소드가 끝나야 두번째 메소드 실행
//		mt2.run();
		
		mt.start();    //반환 thread  //스레드 방식으로 스레드 호출(동시 실행)
		Thread t = new Thread(mt2);
		t.start();
	}
}
