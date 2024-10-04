package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import db.MovieDB;
import model.Movie;
import util.Console;

public class BmdbTesterApp {

	public static void main(String[] args) {
		List<String> ratings = new ArrayList<>(Arrays.asList("G", "PG", "PG-13", "R", "NC-17"));

		Console.printLine("Welcome to the BMDB Console Tester!\n");

		listMovies();

		// Add Movie
		Console.printLine("\nAdd a Movie:");
		int id = Console.getInt("Id: ");
		String title = Console.getRequiredString("Title: ");
		int year = Console.getInt("Year: ");
		String rating = Console.getString("Rating: ", ratings);
		String director = Console.getRequiredString("Director: ");
		Movie m = new Movie(id, title, year, rating, director);
		if (MovieDB.add(m)) {
			Console.printLine("Movie added.");
		} else {
			Console.printLine("Error adding movie.");
		}

		// Get Movie By Id
		Console.printLine("\nGet a Movie:");
		id = Console.getInt("Movie Id: ");
		m = MovieDB.get(id);
		if (m != null) {
			Console.printLine(m.toString());
		} else {
			Console.printLine("No movie found for id: " + id);
		}

		// Delete Movie
		Console.printLine("\nDelete a Movie:");
		id = Console.getInt("Movie Id: ");
		m = MovieDB.get(id);
		if (m != null) {
			if (MovieDB.delete(id)) {
				Console.printLine("Movie deleted.");
			} else {
				Console.printLine("Error deleting movie.");
			}
		} else {
			Console.printLine("No movie found for id: " + id + ". Cannot delete.");
		}
		
		// Get All
		listMovies();

		Console.printLine("Bye");

	}

	private static void listMovies() {
		Console.printLine("List of Movies:");
		List<Movie> movies = new ArrayList<>();
		movies = MovieDB.getAll();
		for (Movie m : movies) {
			Console.printLine(m.toString());
		}
	}

}
