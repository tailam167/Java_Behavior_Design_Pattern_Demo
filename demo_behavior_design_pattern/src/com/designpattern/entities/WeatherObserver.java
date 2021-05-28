package com.designpattern.entities;

import com.designpattern.handlers.ObserverInterface;
import com.designpattern.handlers.SubjectInterface;
import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Observer Pattern
 * 
 * @author taila
 *
 */
public class WeatherObserver implements ObserverInterface {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	// Create parameters
	private int pressure;
	private int temperature;
	private int humidity;
	private SubjectInterface subjectInterface;

	public WeatherObserver(SubjectInterface subjectInterface) {
		this.subjectInterface = subjectInterface;
		this.subjectInterface.addObserver(this);
	}

	@Override
	public void update(int pressure, int temperature, int humidity) {
		this.pressure = pressure;
		this.temperature = temperature;
		this.humidity = humidity;
		showData();
	}

	public void showData() {
		consoleLogger.writeNotify(
				"Pressure: " + this.pressure + " Temperature: " + this.temperature + " Humidity: " + this.humidity);
	}

}
