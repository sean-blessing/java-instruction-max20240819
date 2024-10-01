import java.text.NumberFormat;

public class MathApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the math app!");
		
		// p. 101 rounding
		double result = 1.667;
		result = Math.round(result);
		System.out.println("result rounded: "+result);
		
		double x = 10.315;
		System.out.println("Rounded to 2 decimal places...");
		x = (double)Math.round(x * 100) / 100;
		System.out.println(x);
		System.out.println("Rounded to 1 decimal place...");
		x = (double)Math.round(x * 10) / 10;
		System.out.println(x);
		
		System.out.println("sqrt, max, min, random");
		result = Math.pow(5, 5);
		System.out.println(result);
		double squareRoot = Math.sqrt(20.25);
		System.out.println(squareRoot);
		
		x = 67;
		int y = 23;
		
		System.out.println("Max = "+Math.max(x, y));
		
		System.out.println("10 random #s:");
		for (int i=0; i < 10; i++) {
			System.out.println(Math.random());
		}
		System.out.println("10 random die rolls:");
		for (int i=0; i < 10; i++) {
			int dieRoll = (int)(Math.random() * 6) + 1;
			System.out.println(dieRoll);
		}
		
		System.out.println("Currency formatting...");
		// p. 103
		double price = 11.575;
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		System.out.println("price formatted: "+currencyFormatter.format(price));
		
		double interestRate = .0788236;
		NumberFormat pctFormatter = NumberFormat.getPercentInstance();
		pctFormatter.setMaximumFractionDigits(3);
		System.out.println("interestRate 3 decimal places: "
				+pctFormatter.format(interestRate));
		
		String name = "Joel";
		int age = 39;
		System.out.printf("%s is %d years old.%n", name, age);
		
		double price1 = 99999.99;
		double price2 = 888.88;
		String label = "Price:";
		
		System.out.printf("%f%n", price1);
		System.out.printf("%,.2f%n", price1);
		System.out.printf("%-10s%,10.2f%n", label, price1);
		System.out.printf("%-10s%,10.2f%n", label, price2);
		
		
		System.out.println("Bye");

	}

}
