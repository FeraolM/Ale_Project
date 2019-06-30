package application;

import java.security.cert.Certificate;
import java.sql.*;
import java.time.LocalDate;

import org.apache.http.client.methods.HttpPost;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jdk.dynalink.beans.StaticClass;


public class AccountHelper {
	
	public static String sessionid = "0";
	
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
	
	
	
	public static ResultSet addResidence(String fullname,String mothername,String phonenumber,String Dateofbirth,String placeofbirth,String kebele,String wereda,String housenumber,String job,String emergencycontact,String emergencynumber,String gender,String photourl) {
	
		
	 
	            
		
		String givendate = "CURDATE()";
		
		String expiredate = "DATE_ADD(CURDATE(), INTERVAL 365*2 DAY)";
		
		//CURRENT_DATE
		
		int a;
		
		ResultSet resultSet = null;
		
		try {
		
		Statement statement= DatabaseHelper.getConnection().createStatement();
		
		
		//System.out.println("INSERT INTO users (username, password, type, is_active) VALUES (\"" + username+ "\",\""+password +"\" ,\""+type + "\" "+ "\"0\");");
					
		a = statement.executeUpdate("INSERT INTO resident (full_name, phone_number,mother_name,place_of_birth,date_of_birth,kebele,wereda,house_no,job,emergency_contact_name,emergency_contact_number,gender,given_date,expire_date,photo_url) VALUES (\"" + fullname+
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
				"\",\""+gender +
				"\","+givendate +
				","+expiredate +				
				",\"" +photourl +"\");");
		
		resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
	
		
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
				"\",\""+gender +
				"\","+givendate +
				"\","+expiredate +				
				"\",\"" +photourl +"\");");
		
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		return resultSet;
		
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
	
	
	public void updateusernamepassword() {
		
		
		
	}

	
	/*search user */
	
	public static ResultSet searchuser(String id) {
		
		Statement statement;
		
		try {
				
			
			statement = DatabaseHelper.getConnection().createStatement();
			
			resultSet = statement.executeQuery("SELECT * FROM `resident` WHERE id="+id);
			
			return resultSet;
			
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return resultSet;
	
	
}
	
	public static void changePassword(String password) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
			 statement.executeUpdate("UPDATE `users` SET `password`= \""+ password+"\""+" WHERE id ="+ AccountHelper.sessionid+";");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void toggleActive(String id,String value) {
		
		//UPDATE `users` SET is_active = 1 WHERE id = id
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
			statement.executeUpdate("UPDATE `users` SET is_active = \""+value+ "\" WHERE id ="+id+";");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static ResultSet getUser(String id) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT * FROM `resident` WHERE id = "+id);
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}
	
	
	public static ResultSet getBirth(String id) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT * FROM `birth` WHERE id = "+id);
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}
	
	
public static ResultSet getPopulation() {
		
		try {
		
			//SELECT COUNT(id) FROM resident
			
			//COUNT(id)
			
			
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT COUNT(id) FROM resident");
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}
	
public static ResultSet getDeath(String id) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT * FROM `death` WHERE id = "+id);
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}
	
public static ResultSet getDivorce(String id) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT * FROM `divorce` WHERE id = "+id);
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}
	
public static ResultSet getMirage(String id) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT * FROM `mirage` WHERE id = "+id);
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}
	
	
	
	/* Certificate Generation */
	

	
	public  static ResultSet birth(String cfname,String weight,LocalDate dateofbirth,String fathername,String mothername) {
		
		try {
			
			String child = "INSERT INTO `birth`( `fname`, `weight`, `date_of_birth`, `fatther_name`, `mother_name`) VALUES "
					+ "(\""+cfname+"\","
					+ "\""+weight+"\","
					+ "\""+dateofbirth+"\","
					+ "\""+fathername+"\","
					+"\""+mothername+"\")";
			
			Statement statement= DatabaseHelper.getConnection().createStatement();
			
			statement.executeUpdate(child);
			
			ResultSet sdResultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
			
			return sdResultSet;
			
			
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
		
		
		
	}
	
	
public static ResultSet getStatus(String id) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
		ResultSet sd = statement.executeQuery("SELECT * FROM `resident` WHERE id = "+id);
			
			return sd;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultSet;
		
	}


public static void renewId(String id,String olddate) {
	
	System.out.println("Old date "+olddate);
	
	try {
		
		

		
		LocalDate jhj = LocalDate.parse(olddate);
		
		jhj.plusDays(724);
		
		String givendate = "CURDATE()";
		
		
		String expiredate = "DATE_ADD(CURDATE(), INTERVAL 365*2 DAY)";
		
		//String sdgdgString= "UPDATE `resident` SET `active` =\"1\",`given_date`="+givendate+",`expire_date` ="+jhj+"WHERE id = "+id;
		
	//	System.out.println(sdgdgString);
		
		Statement statement = DatabaseHelper.getConnection().createStatement();
		
		statement.executeUpdate("UPDATE `resident` SET `active` = \"1\",`given_date`= "+givendate+",`expire_date` = "+expiredate+" WHERE id = "+id);
		
		//String kjhjkdString= "UPDATE `resident` SET `active` =\"1\",`given_date`="+givendate+",`expire_date` ="+jhj+"WHERE id = "+id;
		

		
		getStatus(id);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
}
