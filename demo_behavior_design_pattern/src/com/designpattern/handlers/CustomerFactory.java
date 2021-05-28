package com.designpattern.handlers;

import com.designpattern.entities.Database;
import com.designpattern.entities.NullCustomer;
import com.designpattern.entities.RealCustomer;

/**
 * Apply Null Object Pattern
 * 
 * @author taila
 *
 */
public class CustomerFactory {

	private Database database;

	public CustomerFactory() {
		this.database = new Database();
	}

	public AbstractCustomer getSpecificCustomer(String customerName) {

		if (checkName(customerName)) {
			return new RealCustomer(customerName);
		}
		return new NullCustomer();
	}

	private boolean checkName(String customerName) {

		if (database.existCustomer(customerName)) {
			return true;
		}
		return false;
	}

}
