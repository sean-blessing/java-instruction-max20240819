package db;

import java.sql.*;
import java.util.ArrayList;

import model.Movie;

public class MovieDB {
//    private static Connection getConnection() throws SQLException {
//        String dbUrl = "jdbc:sqlite:movies.sqlite";
//        Connection connection = DriverManager.getConnection(dbUrl);
//        return connection;
//    }
	private static Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/bmdb2";
		String username = "bmdb_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		return connection;
	}
    public static ArrayList<Movie> getAll() {
        String sql = "SELECT * "
                   + "FROM Movie ORDER BY Id ASC";
        var movies = new ArrayList<Movie>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	int id = rs.getInt("Id");
                String title = rs.getString("Title");
                int year = rs.getInt("Year");
                String rating = rs.getString("Rating");
                String director = rs.getString("Director");

                Movie m = new Movie(id, title, year, rating, director);
                movies.add(m);
            }
            return movies;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

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

    public static boolean add(Movie m) {
        String sql = "INSERT INTO Movie (Title, Year, Rating, Director) "
                   + "VALUES (?, ?, ?, ?)";
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

}
