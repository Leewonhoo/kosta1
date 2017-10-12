package com.kosta.j0816;

class Thread1 extends Thread{
	public Thread1(String name) {
		super(name);
	}
	
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				sleep(500);
				System.out.println(getName()+" "+getPriority());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class ThreadTest2 {
	public static void main(String[] args) {		
		Thread t1 = new Thread1("hi");
		Thread t2 = new Thread1("hello");
		Thread t3 = new Thread1("ho");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
