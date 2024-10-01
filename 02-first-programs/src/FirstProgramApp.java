import java.util.Scanner;

public class FirstProgramApp {

	public static void main(String[] args) {
		System.out.println("Welcome to my first Java program!");
		
		// This is a one line comment
		
		/*
		 * This
		 * is
		 * a
		 * multi-line
		 * comment
		 */
		
		// primitive data types int and double
		int a = 5;
		int b = 9;
		int sum = a + b;
		System.out.println("Sum is: "+ sum);
		//System.out.println($"Sum is: {sum}");
		
		// double for decimal values (not decimal)
		double price = 19.99;
		
		
		int c = 9/5;
		int r = 9 % 5;
		System.out.println("c = "+c+", r = "+r);
		
		String name = "Bob Marley";
		System.out.println("Full name is "+name);
		
		// p. 57 - getting input from the user
		// Scanner == Console.WriteLine
		Scanner sc = new Scanner(System.in);
		System.out.print("Hi, what's your name? ");
		name = sc.nextLine();
		
		System.out.print("Enter a whole number: ");
		int nbr2 = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter another whole number: ");
		int nbr3 = sc.nextInt();
		
		sc.nextLine();
		
		String choice = "y";
		System.out.print("Continue (y/n)? ");
		String resp = sc.nextLine();
		
		if (choice == resp) {
			System.out.println("choice and resp are the same");
		}
		
		if (choice.equalsIgnoreCase(resp)) {
			System.out.println("equals method - same");
		}
		
		String choice2 = "y";
		
		if (choice==choice2) {
			System.out.println("choice==choice2");
		}
		
		
		System.out.println("Bye");
		
		System.out.println("\nWhile loop demo...");
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Continue? ");
			choice = sc.nextLine();
		}
		

	}

}
