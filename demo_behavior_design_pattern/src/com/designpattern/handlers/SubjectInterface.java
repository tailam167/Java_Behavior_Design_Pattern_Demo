package com.designpattern.handlers;

/**
 * Apply Observer Pattern
 * 
 * @author taila
 *
 */
public interface SubjectInterface {
	public void addObserver(ObserverInterface observerInterface);
	public void removeObserver(ObserverInterface observerInterface);
	public void notifyAllObserver();
}
