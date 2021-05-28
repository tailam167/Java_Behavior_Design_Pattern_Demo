package com.designpattern.command;

import com.designpattern.logger.ConsoleLogger;
import com.designpattern.receiver.Light;

/**
 * Apply Command Pattern
 * Command
 * 
 * @author taila
 *
 */
public class TurnOnCommand implements Command {
	
	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();
	
	private Light light;

	public TurnOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.turnOn();
		consoleLogger.writeNotify("Turn On Command is completed");
	}

}
