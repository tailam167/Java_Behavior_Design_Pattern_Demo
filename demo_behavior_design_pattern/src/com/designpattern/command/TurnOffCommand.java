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
public class TurnOffCommand implements Command {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	private Light light;

	public TurnOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		this.light.turnOff();
		consoleLogger.writeNotify("Turn Off Command is completed");
	}

}
