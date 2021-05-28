package com.designpattern.handlers;

import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Iterator Pattern
 * 
 * @author taila
 *
 */
public class NameIterator implements IteratorInterface {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	private String[] nameStrings;
	private int index;

	public NameIterator(String[] nameStrings) {
		this.nameStrings = nameStrings;
	}

	@Override
	public boolean hasNext() {
		return index < this.nameStrings.length;
	}

	@Override
	public Object next() {
		if (hasNext()) {
			return this.nameStrings[index++];
		}
		return consoleLogger.writeWarning("Empty Data List !");
	}
}
