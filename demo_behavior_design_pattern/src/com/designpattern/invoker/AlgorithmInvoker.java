package com.designpattern.invoker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.designpattern.command.Command;
import com.designpattern.command.TaskSolver;
import com.designpattern.logger.ConsoleLogger;
import com.designpattern.receiver.Task;

/**
 * Apply Command Pattern 
 * Invoker
 * 
 * @author taila
 *
 */
public class AlgorithmInvoker {

	private ConsoleLogger consoleLogger = new ConsoleLogger();
	private BlockingQueue<Command> commands;

	public AlgorithmInvoker() {
		this.commands = new ArrayBlockingQueue<Command>(10);
	}

	public void produce() {

		try {
			for (int i = 0; i < 10; i++) {
				commands.put(new TaskSolver(new Task(i + 1)));
			}
		} catch (InterruptedException e) {
			consoleLogger.writeError("Can't produce task !", e);
		}

	}

	public void consume() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				commands.take().execute();
			}
		} catch (InterruptedException e) {
			consoleLogger.writeError("Can't produce task !", e);
		}
	}

}
