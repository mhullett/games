package edu.cis232.dataBaseLab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Players {

	public static void main(String[] args) {
		final String DB_URL = "jdbc:hsqldb:file:BoardGames/Games;create=true;";

		Scanner kb = new Scanner(System.in);

		try {
			System.out.println("Enter the number of players. ");
			int players = kb.nextInt();
			Connection conn = DriverManager.getConnection(DB_URL);
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM GAMES WHERE MAXPLAYERS >= "+players+";";
			
			ResultSet result = stmt.executeQuery(sql);
			
			//String sql ="SELECT  "
			System.out.println("Games found:" );
			System.out.println("------------");
			
			while (result.next()){
				System.out.printf("%s %n",result.getString("name"),result.getString("averageTime"));
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
