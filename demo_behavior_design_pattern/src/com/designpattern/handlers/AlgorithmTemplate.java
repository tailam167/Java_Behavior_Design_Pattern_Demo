package com.designpattern.handlers;

/**
 * Apply Template Pattern
 * 
 * @author taila
 *
 */
public abstract class AlgorithmTemplate {
	
	public abstract void initialize();
	
	public abstract void sorting();
	
	public abstract void printResult();
	
	public void sort() {
		initialize();
		sorting();
		printResult();
	}
}
