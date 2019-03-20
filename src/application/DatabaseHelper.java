package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
	
	static ResultSet resultSet;
	
		public static ResultSet getInstance () {
			
			try {
				
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kb_system_db", "root", "");
				
				Statement statement= connection.createStatement();
							
				resultSet = statement.executeQuery("SELECT * FROM users");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			return resultSet;
			
			
		}


	
		
}