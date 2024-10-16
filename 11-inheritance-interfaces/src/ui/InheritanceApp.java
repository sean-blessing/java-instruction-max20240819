package ui;

import model.Cat;
import model.Dog;
import util.Console;

public class InheritanceApp {
	
	public static void main(String[] args) {
		Console.printLine("Welcome to the inheritance app!");
		
		Cat cat1 = new Cat("Rufus", 2007, 'm', false, 'o');
		Console.printLine(cat1.toString());
		
		Dog dog1 = new Dog("Fido", 2021, 'f', false, true);
		Console.printLine(dog1.toString());
		Console.printLine("What I can do: "+dog1.whatICanDo());
		
		Console.printLine("Bye");
	}

}
