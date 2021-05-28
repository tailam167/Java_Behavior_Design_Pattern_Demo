package com.designpattern.entities;

import com.designpattern.handlers.AbstractCustomer;

/**
 * Apply Null Object Pattern
 * 
 * @author taila
 *
 */
public class NullCustomer extends AbstractCustomer {

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public String getCustomer() {
		return "No customer found in the database !";
	}
	
}
