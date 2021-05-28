package com.designpattern.entities;

import java.util.ArrayList;
import java.util.List;

import com.designpattern.handlers.ObserverInterface;
import com.designpattern.handlers.SubjectInterface;
import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Observer Pattern
 * 
 * @author taila
 *
 */
public class WeatherStation implements SubjectInterface {
	
	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();
	
	// Create parameters
	private int pressure;
	private int temperature;
	private int humidity;
	private List<ObserverInterface> observerList;
	
	public WeatherStation() {
		this.observerList = new ArrayList<>();
	}

	@Override
	public void addObserver(ObserverInterface observerInterface) {
		this.observerList.add(observerInterface);
		consoleLogger.writeNotify("Added observer !");
	}

	@Override
	public void removeObserver(ObserverInterface observerInterface) {
		this.observerList.remove(observerInterface);
		consoleLogger.writeNotify("Removed observer !");
	}

	@Override
	public void notifyAllObserver() {
		for (ObserverInterface observerInterface : this.observerList) {
			observerInterface.update(pressure, temperature, humidity);
		}
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
		consoleLogger.writeInfor("Pressure is updated !");
		notifyAllObserver();
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		consoleLogger.writeInfor("Temperature is updated !");
		notifyAllObserver();
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
		consoleLogger.writeInfor("Humidity is updated !");
		notifyAllObserver();
	}
}
