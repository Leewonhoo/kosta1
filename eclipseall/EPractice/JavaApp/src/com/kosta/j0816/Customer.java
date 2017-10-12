package com.kosta.j0816;

public class Customer extends Thread{
	Account acc;
	
	public Customer(Account acc) {
		this.acc = acc;
	}
	public void run() {
		try {
		for(int i=1; i<200; i++) {
			acc.deposit(1000);
			System.out.println(getName()+" "+i +" 현재 금액 : "+acc.getAccount());
			Thread.sleep(100);
			if(acc.getAccount()>=500000)
				break;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
