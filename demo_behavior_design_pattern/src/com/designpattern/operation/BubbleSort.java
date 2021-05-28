package com.designpattern.operation;

import com.designpattern.handlers.AlgorithmTemplate;
import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Template Pattern
 * 
 * @author taila
 *
 */
public class BubbleSort extends AlgorithmTemplate {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	private int[] numbers;

	public BubbleSort(int[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public void initialize() {
		consoleLogger.writeInfor("Initalizing bubble sort...");
	}

	@Override
	public void sorting() {

		int n = this.numbers.length;
		int temp;
		while (n != 0) {
			temp = 0;

			for (int i = 1; i < n; i++) {
				if (numbers[i - 1] > numbers[i]) {
					int swap = numbers[i - 1];
					numbers[i - 1] = numbers[i];
					numbers[i] = swap;
					temp = i;
				}
			}
			n = temp;
		}

	}

	@Override
	public void printResult() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
