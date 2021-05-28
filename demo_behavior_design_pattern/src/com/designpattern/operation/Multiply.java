package com.designpattern.operation;

import com.designpattern.handlers.StrategyInterface;
import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Strategy Pattern
 * 
 * @author taila
 *
 */
public class Multiply implements StrategyInterface {

	private ConsoleLogger consoleLogger = new ConsoleLogger();

	@Override
	public void operation(int inNum1, int inNum2) {
		consoleLogger.writeInfor("Calculating Multiply Operation...");
		consoleLogger.writeNotify(String.valueOf(consoleLogger.writeResult(inNum1 * inNum2)));
	}

}
