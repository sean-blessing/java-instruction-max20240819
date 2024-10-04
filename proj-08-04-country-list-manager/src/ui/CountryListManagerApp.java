package ui;

import java.util.*;

import util.Console;

public class CountryListManagerApp {
	private static List<String> countries;

	public static void main(String[] args) {
		Console.printLine("Welcome to the Country List Manager App!");
		countries = new ArrayList<>();
		Console.printLine("");
		printCommandMenu();
		
		int command = 0;
		while (command != 3) {
			command = Console.getInt("Enter menu number: ", 1, 3);
			switch (command) {
				case 1:
					listCountries();
					break;
				case 2:
					addCountry();
					break;
				case 3:
					break;
			}
		}
		
		Console.printLine("Bye");

	}
	
	private static void addCountry() {
		Console.printLine("\nAdd a Country");
		Console.printLine("===============");
		String country = Console.getRequiredString("Enter country: ");
		countries.add(country);
		Console.printLine("This country has been added.");
	}

	private static void listCountries() {
		Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);
		Console.printLine("\nList of Countries:");
		Console.printLine("====================");
		if (countries.size() == 0) {
			Console.printLine("\nNo countries in list.\n");
		}
		else {
			//for (String country: countries) {
			for (int i=0; i < countries.size(); i++) {
				Console.printLine(countries.get(i));
			}
			Console.printLine("");
		}
	}

	private static void printCommandMenu() {
		Console.printLine("COMMAND MENU:");
		Console.printLine("1 - List countries");
		Console.printLine("2 - Add a country");
		Console.printLine("3 - Exit");
	}

}
