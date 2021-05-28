package com.designpattern.handlers;

import com.designpattern.entities.Chair;
import com.designpattern.entities.Table;

/**
 * Apply Visitor Pattern
 * 
 * @author taila
 *
 */
public interface ShoppingCartVisitor {
	public double visit(Table table);
	public double visit(Chair chair);
}
