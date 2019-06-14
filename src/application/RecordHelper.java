package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecordHelper {
	
	//INSERT INTO house (id, family_head, mother_name, house_type, kebele, house_number, family_members, reg_date) VALUES 

	Statement statement;
	
	ResultSet resultSet;
	
	static String regdate  = "CURDATE()";
	
	public static int registerhouse(String familyhead,String mothername,String housetype,String kebele,String housenumber,String familymember) {
		
		try {
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
			String regquery  = "INSERT INTO house (amily_head, mother_name, house_type, kebele, house_number, family_members, reg_date) VALUES (" +
					"\""+familyhead+"\",\""+
					mothername+"\",\""+
					housetype+"\",\""+
					kebele+"\",\""+
					housenumber+"\",\""+
					familymember+"\","+
					regdate+
					");"
									
				;
			
		int rSet =	statement.executeUpdate(regquery);
		
		return rSet;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 3;
		
	}
	
public static ResultSet gethouse(String housenumber) {
		
		try {
			
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
			String regquery  = "SELECT * FROM `house` WHERE house_number = "+housenumber+";";
						
			
		    ResultSet rSet =	statement.executeQuery(regquery);
		
		return rSet;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
		
	}


}
