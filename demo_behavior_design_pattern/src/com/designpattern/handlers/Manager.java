package com.designpattern.handlers;

import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Strategy Pattern
 * 
 * @author taila
 *
 */
public class Manager implements StrategyInterface {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();
	
	// Create interface
	private StrategyInterface strategyInterface;
	
	public void setStrategy(StrategyInterface inStrategyInterface) {
		consoleLogger.writeInfor("Setting Strategy Interface...");
		this.strategyInterface = inStrategyInterface;
	}

	@Override
	public void operation(int inNum1, int inNum2) {
		consoleLogger.writeInfor("Implementing Strategy Interface Operation Method...");
		this.strategyInterface.operation(inNum1, inNum2);
	}
}
