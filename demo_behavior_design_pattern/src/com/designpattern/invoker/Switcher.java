package com.designpattern.invoker;

import java.util.ArrayList;
import java.util.List;

import com.designpattern.command.Command;

/**
 * Apply Command Pattern
 * Invoker
 * 
 * @author taila
 *
 */
public class Switcher {
	
	private List<Command> commands;

	public Switcher() {
		this.commands = new ArrayList<>();
	}
	
	public void addCommand(Command command) {
		this.commands.add(command);
	}
	
	public void executeCommand() {
		for (Command command : commands) {
			command.execute();
		}
	}

}
