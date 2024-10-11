package ui;

import util.Console;

public class StringTemplatesApp {

	public static void main(String[] args) {
		Console.printLine("Hello and welcome to String Templates");
		
		String name = Console.getRequiredString("Enter name: ");
		int nbr = Console.getInt("Number of notifications?: ");
		
		// was a preview feature in JDK21, removed in 23
		//String message = STR."Hello, {name}! You have new messages.";
		//StringTemplate st = StringTemplate.of("Hello ${name}");
		//String message = `Hello ${name}`;
		
		// ultimately, StringTemplate was removed in JDK23!!!
		
		
		Console.printLine("Bye");

	}

}
