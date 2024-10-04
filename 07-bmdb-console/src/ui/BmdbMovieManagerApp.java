package ui;

import java.util.*;

import model.Movie;
import util.Console;

public class BmdbMovieManagerApp {

	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<>();
		List<String> ratings = new ArrayList<>(Arrays.asList("G", "PG", "PG-13", "R", "NC-17"));
		Console.printLine("Welcome to the BMDB Movie Manager Application!");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// Prompt a user for the fields of a movie: id, title, year, rating, director
			Console.printLine("Enter a movie:");
			int id = Console.getInt("Id: ");
			String title = Console.getRequiredString("Title: ");
			int year = Console.getInt("Year: ");
			String rating = Console.getString("Rating: ",ratings);
			String director = Console.getRequiredString("Director: ");
			
			// Create an instance of Movie, store it in a List
			Movie m = new Movie(id, title, year, rating.toUpperCase(), director);
			movies.add(m);
			// Print list of movies
			Console.printLine("\nMovies:");
			for (Movie movie: movies) {
				Console.printLine(movie.toString());
			}
			choice = Console.getString("Another movie? (y/n)", new ArrayList<>(Arrays.asList("y", "n")));
		}
		System.out.println("Bye");
	}

}
