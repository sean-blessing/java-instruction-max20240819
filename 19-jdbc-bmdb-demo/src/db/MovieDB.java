package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Movie;

public class MovieDB {
	
	private static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb";
		String username = "bmdb_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;
	}
	
	// get all movies
	public static List<Movie> getAll() {
		String sql = "SELECT * FROM Movie";
		List<Movie> movies = new ArrayList<>();
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id  = rs.getInt(1);
				String title = rs.getString(2);
				int year = rs.getInt(3);
				String rating = rs.getString(4);
				String director = rs.getString(5);
				Movie m = new Movie(id, title, year, rating, director);
				movies.add(m);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.err.println(e);
			movies = null;
		}
		return movies;
	}
	
	// add a movie
	public static boolean add(Movie m) {
		String sql = "INSERT INTO Movie (Title, Year, Rating, Director)"
				+ " VALUES (?, ?, ?, ?)";
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, m.getTitle());
			ps.setInt(2, m.getYear());
			ps.setString(3, m.getRating());
			ps.setString(4, m.getDirector());
			ps.executeUpdate();
			return true;
		}
		catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	// get a movie by id
    public static Movie get(int id) {
        String sql = "SELECT * "
                   + "FROM Movie "
                   + "WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                int year = rs.getInt(3);
                String rating = rs.getString(4);
                String director = rs.getString(5);
                Movie m = new Movie(id, title, year, rating, director);
                return m;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	// update a movie (* coded but not used in the app)
    public static boolean update(Movie m) {
        String sql = "UPDATE Movie SET "
                   + "  Title = ?, "
                   + "  Year = ?, "
                   + "  Rating = ?, "
                   + "  Director = ? "
                   + "WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, m.getTitle());
            ps.setInt(2, m.getYear());
            ps.setString(3, m.getRating());
            ps.setString(4, m.getDirector());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
	
	// delete a movie by id
    public static boolean delete(int id) {
        String sql = "DELETE FROM Movie "
                   + "WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

}
