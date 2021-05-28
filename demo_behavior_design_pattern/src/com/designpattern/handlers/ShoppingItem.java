package com.designpattern.handlers;

/**
 * Apply Visitor Pattern
 * 
 * @author taila
 *
 */
public interface ShoppingItem {
	public double accept(ShoppingCartVisitor visitor);
}
