package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import db.MovieDB;
import model.Movie;
import util.Console;

public class BmdbTesterApp {

	public static void main(String[] args) {
		Console.printLine("Welcome to the BMDB Tester App!");

		Console.printLine("List all movies:");
		Console.printLine("================");
		listMovies();
		
		Console.printLine("Add a movie:");
		Console.printLine("================");
		String title = Console.getRequiredString("Title: ");
		int year = Console.getInt("Year: ");
		String rating = Console.getRequiredString("Rating: ");
		String director = Console.getRequiredString("Director: ");
		Movie m = new Movie(title, year, rating, director);
		if (MovieDB.add(m)) {
			Console.printLine("Movie added.");
		}
		else {
			Console.printLine("Error adding movie.");
		}
		
		Console.printLine("List all movies:");
		Console.printLine("================");
		listMovies();
		
		Console.printLine("Get a movie by id:");
		Console.printLine("================");
		int id = Console.getInt("Movie Id: ");
		m = MovieDB.get(id);
		if (m != null) {
			Console.printLine(m.toString());
		} else {
			Console.printLine("No movie found for id: " + id);
		}

		Console.printLine("Delete movie by id:");
		Console.printLine("================");
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

		Console.printLine("List all movies:");
		Console.printLine("================");
		listMovies();
		
	
		Console.printLine("Bye");
	}

	private static void listMovies() {
		List<Movie> movies = MovieDB.getAll();
		for (Movie m: movies) {
			Console.printLine(m.toString());
		}
	}

}
