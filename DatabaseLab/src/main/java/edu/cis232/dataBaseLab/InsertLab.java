package edu.cis232.dataBaseLab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertLab {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("This program adds board games into the Board Game Database. ");
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the Name. ");
		String Name = kb.nextLine();
		System.out.println("Enter The publisher. ");
		String Publisher = kb.nextLine();
		System.out.println("Enter the Min number of players. ");
		String MinPlayers = kb.nextLine();
		System.out.println("Enter the Max number of players. ");
		String MaxPlayers = kb.nextLine();
		System.out.println("Enter the Average play time. ");
		String AverageTime = kb.nextLine();
		System.out.println("Enter the game ID. ");
		String ID = kb.nextLine();
		
		final String DB_URL = "jdbc:hsqldb:file:BoardGames/Games";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sql = "INSERT INTO GAMES"
				+ "(Name, Publisher, MinPlayers, MaxPlayers, AverageTime,ID)" 
				+ " Values "
				+"(?,?,?,?,?,?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, Name);
		stmt.setString(2, Publisher);
		stmt.setInt(3, Integer.parseInt(MinPlayers));
		stmt.setInt(4, Integer.parseInt(MaxPlayers));
		stmt.setInt(5, Integer.parseInt(AverageTime));
		stmt.setInt(6, Integer.parseInt(ID));
		
		stmt.executeUpdate();
		
		conn.close();
		
		System.out.println("Inserted Game. ");

	}
	
}
