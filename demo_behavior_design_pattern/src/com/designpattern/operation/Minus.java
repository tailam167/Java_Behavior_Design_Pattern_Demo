package com.designpattern.operation;

import com.designpattern.handlers.StrategyInterface;
import com.designpattern.logger.ConsoleLogger;

/**
 * 
 * 
 * @author taila
 *
 */
public class Minus implements StrategyInterface {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	@Override
	public void operation(int inNum1, int inNum2) {
		consoleLogger.writeInfor("Calculating Minus Operation...");
		consoleLogger.writeNotify(String.valueOf(consoleLogger.writeResult(inNum1 - inNum2)));
	}

}
