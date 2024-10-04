package ui;

import java.text.NumberFormat;
import java.util.Scanner;

public class ControlStructuresApp {

	public static void main(String[] args) {
		System.out.println("Welcome to chapter 4");

		Scanner sc = new Scanner(System.in);

		System.out.println("Traffic light");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("What's the light color? ");
			String color = sc.nextLine();
			if (color.equalsIgnoreCase("red")) {
				System.out.println("Stop");
			} else if (color.equalsIgnoreCase("yellow")) {
				System.out.println("Slow down");
			} else if (color.equalsIgnoreCase("green")) {
				System.out.println("Go");
			} else {
				System.out.println("invalid color");
			}
			System.out.print("Go again? ");
			choice = sc.nextLine();
		}
		
		System.out.println("\nCommand Menu:");
		System.out.println("1 - Attack");
		System.out.println("2 - Block");
		System.out.println("3 - Run Away!");
		System.out.print("Command: ");
		String command = sc.nextLine();
		
		switch (command) {
			case "1":
				System.out.println("Arrrrgh!!!! ");
				break;
			case "2":
				System.out.println("Blocked the hit ");
				break;
			case "3":
				System.out.println("Ahhhh... run away! ");
				break;
			default:
				System.out.println("invalid command");
				break;
		}
		
		System.out.println("switch statement fall-through...");
		System.out.print("Day of week? (1-7) ");
		int dow = sc.nextInt();
		switch (dow) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("Weekday");
				break;
			case 6:
			case 7:
				System.out.println("Weekend.. woohoo!");
				break;
		}
		
		System.out.println("\nfor loops..");
		System.out.println("standard loop, count from 0 to 100...");
		for (int i=0; i<=10; i++) {
			System.out.println("i: "+i);
		}

		System.out.println("count from 0 to 100, by 5...");
		for (int i=0; i<=100; i+=5) {
			System.out.println("i: "+i);
		}		System.out.println("Bye");
		
		System.out.println("3 to 99, backwards, by 3...");
		for (int i=99; i>=3; i-=3) {
			System.out.println("i: "+i);
		}
		
		System.out.println("percentages... 1.0% to 5.0%, by .25");
		NumberFormat pFormat = NumberFormat.getPercentInstance();
		pFormat.setMinimumFractionDigits(2);
		for (double d = 1.0; d <= 5.0; d+=.25) {
			double pct = d/100;
			System.out.println("d: "+d+", pct = "+pct+", pct formatted: "+pFormat.format(pct));
		}

	}

}
