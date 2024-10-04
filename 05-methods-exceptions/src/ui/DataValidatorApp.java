package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataValidatorApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		printWelcome();

		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {

//		System.out.print("Enter a whole number (exception handling): ");
//		try {
//			int nbr1 = sc.nextInt();
//		}
//		catch (InputMismatchException ime) {
//			System.out.println("Invalid whole number");
//			// clear bad input
//			sc.nextLine();
//		}
			int nbr1 = getInt("Enter whole number: ");
			System.out.println("nbr1 = " + nbr1);

//		System.out.print("Enter a double (data validation): ");
//		if (sc.hasNextDouble()) {
//			double d1 = sc.nextDouble();
//		}
//		else {
//			System.out.println("Invalid double");
//			// clear bad input
//			sc.nextLine();
//		}

			double dbl1 = getDouble("Enter double number: ");
			System.out.println("dbl1 = " + dbl1);
			choice = getString("Try again (y/n)? ", "y", "n");
		}
		System.out.println("Bye");
	}

	private static void printWelcome() {
		System.out.println("Welcome to data validation");
	}

	private static int getInt(String prompt) {
		boolean success = false;
		int nbr = 0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				nbr = sc.nextInt();
				success = true;
			} else {
				System.out.println("Invalid whole number.");
			}
			sc.nextLine();
		}

		return nbr;
	}

	private static double getDouble(String prompt) {
		boolean success = false;
		double nbr = 0.0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				nbr = sc.nextDouble();
				success = true;
			} else {
				System.out.println("Invalid double number.");
			}
			sc.nextLine();
		}

		return nbr;
	}

	// validate String entry against two acceptable values
	private static String getString(String prompt, String s1, String s2) {
		String str = "";
		boolean success = false;
		while (!success) {
			System.out.print(prompt);
			str = sc.nextLine();
			if (str.length() == 0) {
				System.out.println("Entry is required. Try again.");
			} else if (!str.equalsIgnoreCase(s1) && !str.equalsIgnoreCase(s2)) {
				System.out.println("Entry must be '" + s1 + "' or '" + s2 + "'. Try again");
			} else {
				success = true;
			}
		}

		return str;
	}

}
