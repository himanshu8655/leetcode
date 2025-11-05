package com.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Stock {

	private AtomicInteger quantity;
	private String name;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Stock(int quantity, String name) {
		this.quantity = new AtomicInteger(quantity);
		this.name = name;
	}


	public int getQuantity() {
		return this.quantity.get();
	}
	
	public boolean buyStock(int quantity) {
		int oldVal, newVal;
		do {
			oldVal = this.quantity.get();
			newVal = oldVal - quantity;
			if(newVal<0)
				return false;
		}
		while(!this.quantity.compareAndSet(oldVal, newVal));
		
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
