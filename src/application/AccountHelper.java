package application;

import java.sql.*;

import org.apache.http.client.methods.HttpPost;


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
	
	public static void addResidence(String fullname,String mothername,String phonenumber,String Dateofbirth,String placeofbirth,String kebele,String wereda,String housenumber,String job,String emergencycontact,String emergencynumber,String photourl) {
	
		String givendate = "CURDATE()";
		String expiredate = "DATE_ADD(CURDATE(), INTERVAL 365*2 DAY)";
		
		//CURRENT_DATE
		
		int a;
		
		try {
		
		Statement statement= DatabaseHelper.getConnection().createStatement();
		
		
		//System.out.println("INSERT INTO users (username, password, type, is_active) VALUES (\"" + username+ "\",\""+password +"\" ,\""+type + "\" "+ "\"0\");");
					
		a = statement.executeUpdate("INSERT INTO resident (full_name, phone_number,mother_name,place_of_birth,date_of_birth,kebele,wereda,house_no,job,emergency_contact_name,emergency_contact_number,given_date,expire_date,photo_url) VALUES (\"" + fullname+
				"\",\""+phonenumber +
				"\",\""+mothername +
				"\",\""+placeofbirth +
				"\",\""+Dateofbirth +
				"\",\""+kebele +
				"\",\""+wereda +
				"\",\""+housenumber +
				"\",\""+job +
				"\",\""+emergencycontact +
				"\",\""+emergencynumber +
				"\","+givendate +
				","+expiredate +				
				",\"" +photourl +"\");");
		
		System.out.println("INSERT INTO resident (full_name, phone_number,mother_name,place_of_birth,date_of_birth,kebele,wereda,house_no,job,emergency_contact_name,emergency_contact_number,given_date,expire_date,photo_url) VALUES (\"" + fullname+
				"\",\""+phonenumber +
				"\",\""+mothername +
				"\",\""+placeofbirth +
				"\",\""+Dateofbirth +
				"\",\""+kebele +
				"\",\""+wereda +
				"\",\""+housenumber +
				"\",\""+job +
				"\",\""+emergencycontact +
				"\",\""+emergencynumber +
				"\","+givendate +
				"\","+expiredate +				
				"\",\"" +photourl +"\");");
		
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
	//full_name, phone_number,mother_name,place_of_birth,date_of_birth,kebele,wereda,house_no,job,emergency_contact_name,emergency_contact_number,given_date,photo_url
		
		
	}
	
	public static int  get_last_inserted_residence() {
		
		ResultSet linsid = DatabaseHelper.getlastinsertedid();
		
		
		try {
			
			while (linsid.next()) {
				
			System.out.println("last inserted id is:- "+linsid.getString("id"));		
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		

		
		
		
		return 0;
		
	}

}
