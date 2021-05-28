package com.designpattern.command;

import com.designpattern.logger.ConsoleLogger;
import com.designpattern.receiver.Task;

/**
 * Apply Command Pattern
 * Command
 * 
 * @author taila
 *
 */
public class TaskSolver implements Command {

	private ConsoleLogger consoleLogger = new ConsoleLogger();
	private Task task;

	public TaskSolver(Task task) {
		this.task = task;
	}

	@Override
	public void execute() {
		this.task.resolveTask();
		consoleLogger.writeInfor("Resolved task " + String.valueOf(task.getTaskId()) + "!!");
	}

}
