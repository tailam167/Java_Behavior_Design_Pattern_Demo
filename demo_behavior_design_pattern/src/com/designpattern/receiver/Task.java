package com.designpattern.receiver;

import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Command Pattern
 * Receiver
 * 
 * @author taila
 *
 */
public class Task {
	
	private ConsoleLogger consoleLogger = new ConsoleLogger();
	private int taskId;
	
	public Task(int taskId) {
		this.taskId = taskId;
	}
	
	public void resolveTask() {
		consoleLogger.writeNotify("Resolving task " + String.valueOf(taskId));
	}

	public int getTaskId() {
		return taskId;
	}
}
