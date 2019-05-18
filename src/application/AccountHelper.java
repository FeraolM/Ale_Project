package application;

import java.sql.*;


public class AccountHelper {
	
	static ResultSet resultSet;
	
	public static ResultSet getAllKbadminUser( ) {
		
		
		
		Statement statement;
		try {
			
			statement = DatabaseHelper.getConnection().createStatement();
			
			resultSet = statement.executeQuery("SELECT * FROM `users` WHERE type = 0 OR type = 1 OR type = 2");
			
			return resultSet;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
		
		
	}

}
