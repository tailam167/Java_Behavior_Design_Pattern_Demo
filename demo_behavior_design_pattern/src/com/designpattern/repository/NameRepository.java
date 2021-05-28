package com.designpattern.repository;

import com.designpattern.handlers.IteratorInterface;
import com.designpattern.handlers.NameIterator;

/**
 * Apply Iterator Pattern
 * 
 * @author taila
 *
 */
public class NameRepository {
	
	private String[] nameStrings = {"Adam", "Joe", "John", "Tai Lam", "Nghi To"};
	
	public IteratorInterface getIterator() {
		return new NameIterator(nameStrings);
	}
}
