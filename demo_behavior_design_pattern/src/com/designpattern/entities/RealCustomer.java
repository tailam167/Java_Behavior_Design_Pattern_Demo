package com.designpattern.entities;

import com.designpattern.handlers.AbstractCustomer;

/**
 * Apply Null Object Pattern
 * 
 * @author taila
 *
 */
public class RealCustomer extends AbstractCustomer {

	private String customerName;

	public RealCustomer(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String getCustomer() {
		return this.customerName;
	}

}
