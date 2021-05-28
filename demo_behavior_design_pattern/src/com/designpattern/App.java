package com.designpattern;

import java.util.ArrayList;
import java.util.List;

import com.designpattern.command.TurnOffCommand;
import com.designpattern.command.TurnOnCommand;
import com.designpattern.entities.Chair;
import com.designpattern.entities.ShoppingCart;
import com.designpattern.entities.Table;
import com.designpattern.entities.WeatherObserver;
import com.designpattern.entities.WeatherStation;
import com.designpattern.handlers.AlgorithmTemplate;
import com.designpattern.handlers.CustomerFactory;
import com.designpattern.handlers.IteratorInterface;
import com.designpattern.handlers.Manager;
import com.designpattern.handlers.ShoppingCartVisitor;
import com.designpattern.handlers.ShoppingItem;
import com.designpattern.handlers.StrategyInterface;
import com.designpattern.invoker.AlgorithmInvoker;
import com.designpattern.invoker.Switcher;
import com.designpattern.logger.ConsoleLogger;
import com.designpattern.operation.Add;
import com.designpattern.operation.BubbleSort;
import com.designpattern.operation.Divided;
import com.designpattern.operation.InsertionSort;
import com.designpattern.operation.Minus;
import com.designpattern.operation.Multiply;
import com.designpattern.receiver.Light;
import com.designpattern.repository.NameRepository;

/**
 * Demo Apply Behavior Design Pattern
 * 
 * @author taila
 *
 */
public class App {

	public static void main(String[] args) {

		// Create Logging
		ConsoleLogger consoleLogger = new ConsoleLogger();

		/**
		 * Apply Strategy Pattern: Could take what varies and encapsulate it, and it
		 * will not affect the rest of our code. Should make code more flexible, can
		 * alter or extend the parts that vary without affecting those that does not.
		 * Program to an interface / super-type not an implementation, Abstract
		 * super-class would be perfect too. Good to separate behaviors from
		 * implementation: easier to reuse it, can add new behavior without modifying
		 * any of our existing behavior classes. Favor composition over inheritance
		 * (composition means has a relationship) and (inheritance is a relationship).
		 * Could encapsulate stuffs into their own set of classes. Could change behavior
		 * at runtime with interfaces --> composition is used in several design patterns
		 */
		StrategyInterface strategyInterface = new Add();
		strategyInterface.operation(1600, 07);
		System.out.println("Add Operation completed !");

		StrategyInterface strategyInterface2 = new Multiply();
		strategyInterface2.operation(0101, 9);
		System.out.println("Multiply Operation completed !");

		Manager manager = new Manager();
		manager.setStrategy(new Minus());
		manager.operation(909, 167);
		System.out.println("Minus Operation completed !");

		Manager manager2 = new Manager();
		manager2.setStrategy(new Divided());
		manager2.operation(909, 167);
		System.out.println("Divided Operation completed !");

		/**
		 * Apply Observer Pattern: Defines a one-to-way dependency --> if one object
		 * changes state all of its dependents are notified automatically It'll make
		 * loose coupling. Objects can interact but having little knowledge of each
		 * other. Subjects will know about an observer is that it implements a certain
		 * interface. Could add observers whenever we want to implement the Observer
		 * Interface. Avoid to modify the subject to add new type of observers. Could
		 * independently reuse subjects or observers. Could change the subject or
		 * observer independently. Help to build flexible systems that can handle change
		 * because the interdependency between objects are minimal --> Use loose coupled
		 * design between objects that interacts
		 * 
		 */
		WeatherStation weatherStation = new WeatherStation();
		WeatherObserver weatherObserver = new WeatherObserver(weatherStation);
		weatherStation.setHumidity(167);
		weatherStation.setPressure(909);
		weatherStation.setTemperature(169);
		System.out.println("SUMMARY:");
		weatherObserver.showData();

		/**
		 * Apply Command Pattern: Could encapsulate method invocation, it encapsulated a
		 * request as an object. It have 4 components: command, receiver, invoker and
		 * client. Command will know about receiver and invokers a method of the
		 * receiver, values for parameters of the receiver method are stored in the
		 * command. Receiver does work itself. Invokers knows how to execute a command
		 * and optionally does bookkeeping about the command execution, it just know
		 * about command interface. Client decides which commands to execute at which
		 * points, to execute command --> It passes command object to the invoker object
		 * 
		 */

		// Create new invoker
		Switcher switcher = new Switcher();

		// Create new receiver
		Light light = new Light();

		// Create new commands
		TurnOnCommand turnOnCommand = new TurnOnCommand(light);
		TurnOffCommand turnOffCommand = new TurnOffCommand(light);

		// Invoker add new command for executing
		switcher.addCommand(turnOnCommand);
		System.out.println("Invoker Switcher added Turn On Command");

		// Invoker add new command for executing
		switcher.addCommand(turnOffCommand);
		System.out.println("Invoker Switcher added Turn Off Command");

		// Execute Commands
		switcher.executeCommand();

		// Create object Algorithm (invoker)
		final AlgorithmInvoker algorithm = new AlgorithmInvoker();
		System.out.println("Created algorithm object !");

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				algorithm.produce();
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				algorithm.consume();
			}
		});

		thread1.start();
		System.out.println("Thread 1 run completely");
		thread2.start();
		System.out.println("Thread 2 run completely");

		/**
		 * Apply Iterator Pattern: very commonly used design pattern in Java. Used to
		 * get a way to access the elements of a collection object in sequential manner
		 * without any need to know its underlying representation
		 */
		NameRepository nameRepository = new NameRepository();
		for (IteratorInterface iteratorInterface = nameRepository.getIterator(); iteratorInterface.hasNext();) {
			String nameString = (String) iteratorInterface.next();
			consoleLogger.writeInfor(nameString);
		}

		/**
		 * Apply Template Pattern: An abstract class exposes defined way / template to
		 * execute its methods, its subclasses can override the method implementation as
		 * per need but the invocation is to be in the same way as defined by an
		 * abstract class
		 */
		int[] numbers = { 3, 12, 5, 8, 16, 31, 9, -2, 54 };

		AlgorithmTemplate bubbleSortAlgorithm = new BubbleSort(numbers);
		bubbleSortAlgorithm.sort();

		AlgorithmTemplate insertionSortAlgorithm = new InsertionSort(numbers);
		insertionSortAlgorithm.sort();

		/**
		 * Apply Null Object Pattern: States that references may be null. This pattern
		 * can be very elaborate to deal with null references. Have to check whether a
		 * reference is null or not --> call methods on null objects. Avoid Null
		 * References (example: return empty List instead of Null, dealing with Binary
		 * Tree). Should create an abstract class specifying various operations to be
		 * done. Concrete classes extending this class and a null object class providing
		 * do nothing implementation of this class. Can be used where we need to check
		 * null value.
		 */
		CustomerFactory customerFactory = new CustomerFactory();
		consoleLogger.writeInfor(String.valueOf(customerFactory.getSpecificCustomer("Tai Lam").getCustomer()));
		consoleLogger.writeInfor(String.valueOf(customerFactory.getSpecificCustomer("Shen").getCustomer()));

		/**
		 * Apply Visitor Pattern: way of separating an algorithm from an object
		 * structure on which it operates. A practical result of the separation is the
		 * ability to our new operations to existing objects structures without
		 * modifying those structures. Could solve the open / closed principle with this
		 * design pattern as well. Could extract common operations into a unique class
		 */
		List<ShoppingItem> itemList = new ArrayList<>();
		itemList.add(new Table("Black Desk", 200));
		itemList.add(new Chair("Red Chair", 50));
		itemList.add(new Table("White Desk", 230));
		itemList.add(new Chair("Yellow Chair", 70));

		double totalPrice = 0;
		ShoppingCartVisitor shoppingCart = new ShoppingCart();

		for (ShoppingItem shoppingItem : itemList) {
			totalPrice += shoppingItem.accept(shoppingCart);
		}

		System.out.println("Total: " + totalPrice);

	}
}
