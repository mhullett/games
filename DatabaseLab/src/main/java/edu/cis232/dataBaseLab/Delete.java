package edu.cis232.dataBaseLab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		String prodNum;
		String answer;

		final String DB_URL = "jdbc:hsqldb:file:BoardGames/Games;create=true;";

		Scanner kb = new Scanner(System.in);

		try {
			Connection conn = DriverManager.getConnection(DB_URL);

			System.out.println("Enter the product number to remove. ");
			prodNum = kb.nextLine();
			removeProduct(prodNum, conn);
			//testMe(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void removeProduct(String prodNumber, Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = String.format("DELETE FROM GAMES WHERE ID = '%s';",prodNumber);
		stmt.executeUpdate(query);
	}
//	public static void testMe(Connection conn) throws SQLException{
//		Statement stmt = conn.createStatement();
//		String query = "SELECT * FROM GAMES;";
//		ResultSet result = stmt.executeQuery(query);
//		
//		for(int i=1;result.next();i++){
//			System.out.printf("%s,%s,%d,%d,%d,%d",
//					result.getString(i),result.getString(i+1),result.getInt(i+2),result.getInt(i+3),
//					result.getInt(i+4),result.getInt(i+5));
//		}
//		
//		
//	}
}
