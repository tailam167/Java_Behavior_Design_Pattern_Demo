package com.designpattern.receiver;

import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Command Pattern
 * Receiver
 * 
 * @author taila
 *
 */
public class Light {
	
	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();
	
	public void turnOn() {
		consoleLogger.writeInfor("Light is on !");
	}
	
	public void turnOff() {
		consoleLogger.writeInfor("Light is off ! ");
	}
}
