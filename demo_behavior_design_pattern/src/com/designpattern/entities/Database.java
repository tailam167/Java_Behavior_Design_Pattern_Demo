package com.designpattern.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Apply Null Object Pattern
 * 
 * @author taila
 *
 */
public class Database {
	
	private List<String> customerNameList;

	public Database() {
		this.customerNameList = new ArrayList<>();
		this.customerNameList.add("John");
		this.customerNameList.add("Mike");
		this.customerNameList.add("Marcus");
		this.customerNameList.add("Tai Lam");
		this.customerNameList.add("Nghi To");
		this.customerNameList.add("Tommy");
		this.customerNameList.add("Ricky");
	}
	
	public boolean existCustomer(String customerName) {
		for (String name : customerNameList) {
			if (name.equals(customerName)) {
				return true;
			}
		}
		return false;
	}
	
}
