package com.designpattern.operation;

import com.designpattern.handlers.AlgorithmTemplate;
import com.designpattern.logger.ConsoleLogger;

/**
 * Apply Template Pattern
 * 
 * @author taila
 *
 */
public class InsertionSort extends AlgorithmTemplate {

	// Create logging
	private ConsoleLogger consoleLogger = new ConsoleLogger();

	private int[] numbers;

	public InsertionSort(int[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public void initialize() {
		consoleLogger.writeInfor("Initalizing insertion sort...");
	}

	@Override
	public void sorting() {

		int temp;
		int j;

		for (int i = 0; i < this.numbers.length; i++) {
			temp = this.numbers[i];
			j = i;

			while (j > 0 && numbers[j - 1] > temp) {
				numbers[j - 1] = numbers[j];
				j -= 1;
			}
			numbers[j] = temp;
		}
	}

	@Override
	public void printResult() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
