package com.designpattern.entities;

import com.designpattern.handlers.ShoppingCartVisitor;

/**
 * Apply Visitor Pattern
 * 
 * @author taila
 *
 */
public class ShoppingCart implements ShoppingCartVisitor {

	@Override
	public double visit(Table table) {
		return table.getPrice();
	}

	@Override
	public double visit(Chair chair) {
		return chair.getPrice();
	}

}
