package com.designpattern.handlers;

/**
 * Apply Observer Pattern
 * 
 * @author taila
 *
 */
public interface ObserverInterface {
	public void update(int pressure, int temperature, int humidity);
}
