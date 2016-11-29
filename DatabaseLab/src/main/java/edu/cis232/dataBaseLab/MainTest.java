package edu.cis232.dataBaseLab;

import java.sql.*;

public class MainTest {
	public static void main(String[] args) throws Exception {
		
		final String DB_URL = "jdbc:hsqldb:file:BoardGames/Games;create=true;";

		try {
			
			Connection conn = DriverManager.getConnection(DB_URL);

			// If the DB already exists, drop the tables.
			dropTables(conn);

			// Build the Games table.
			buildGames(conn);

			// Close the connection.
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	public static void dropTables(Connection conn) {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			try {
				// Drop the UnpaidOrder table.
				stmt.execute("DROP TABLE Games");
				System.out.println("Games table dropped.");
			} catch (SQLException ex) {
				
			}

			
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	//create table and populate
	public static void buildGames(Connection conn) {
		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// Create the table.
			stmt.execute("CREATE TABLE Games (" 
			+ "Name CHAR(25), " 
			+ "Publisher CHAR(10), " 
			+ "MinPlayers INTEGER, "
			+ "MaxPlayers INTEGER, " 
			+ "AverageTime INTEGER, " 
			+ "ID INTEGER NOT NULL PRIMARY KEY, " 
			+ ")");

			stmt.execute("INSERT INTO Games VALUES ( " 
			+ "'Eels and Escalators ', " 
			+ " 'Company1', " 
			+ " 2, " 
			+ " 4, "
			+ " 15, " 
			+ " 000065 " 
			+ ")");

			stmt.execute("INSERT INTO Games VALUES ( " 
			+ "'Monopoly', "
			+ "'Company2',"		
			+ " 2, " 
			+ "8," 
			+ "120,"
			+"004010"
			+ ")");
			
			stmt.execute("INSERT INTO Games VALUES ( "
			+"'Sorry',"
			+"'Company1',"
			+"2,"
			+"4,"
			+"15, "
			+"004410"
			+")");
			
			stmt.execute("INSERT INTO Games VALUES ( "
			+"'Scrabble',"
			+"'Company2',"
			+"2,"
			+"4,"
			+"60, "
			+"000041"
			+")");
			
			stmt.execute("INSERT INTO Games VALUES ( "
			+"'Mouse Trap',"
			+"'Company3',"
			+"2,"
			+"4,"
			+"15, "
			+"160401"
			+")");



			System.out.println("Games table created.");
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	
}
