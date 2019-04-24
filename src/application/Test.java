package application;

import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void testsdf () {
		
		
			try {
			
			Statement statement= DatabaseHelper.getConnection().createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
			
				while (resultSet.next()) {
					
		System.out.println(resultSet.getString("username"));
					
				}
			
			}
			
			catch (Exception e) {
				// TODO: handle exception
			}
		
	}
}
