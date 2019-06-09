package application;

import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	
	
	public static void main(String[] args) {
		
		String expiredate = "DATE_ADD(CURDATE(), INTERVAL 31 DAY)";
		
		String sjdkfhjds = "INSERT INTO resident (full_name, phone_number,mother_name,place_of_birth,date_of_birth,kebele,wereda,house_no,job,emergency_contact_name,emergency_contact_number,given_date,expire_date,photo_url) VALUES (\"" + "Tesfaye kassahun"+
				"\",\""+"0963101440" +
				"\",\""+"zenebech " +
				"\",\""+"wachemo" +
				"\",\""+"5/5/1999" +
				"\",\""+"asfsf" +
				"\",\""+"sdgfsdg" +
				"\",\""+"sdgsdg" +
				"\",\""+"sdgdg" +
				"\",\""+"dgdfg" +
				"\",\""+"dfgdfg" +
				"\","+"dfgdfh" +
				","+expiredate +				
				"\",\"" +"hjkgsdjfgsj" +"\");";
		
		System.out.println(sjdkfhjds);
	}

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

	public static void check(String[] tobetseted) {
		// TODO Auto-generated method stub
		
		System.out.println(String.valueOf(tobetseted.length));
		
	}
}
