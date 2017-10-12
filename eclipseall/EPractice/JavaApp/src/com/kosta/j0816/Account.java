package com.kosta.j0816;

public class Account {
	private int total;
	
	public synchronized void deposit(int account) {
		total+=account;
	}
	
	public int getAccount() {
		return total;
	}
	
}
