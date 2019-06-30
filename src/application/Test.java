package application;

import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	
	
	public static void main(String[] args) {
		
		String selectlastidString = "SELECT LAST_INSERT_ID();";
		
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
		
		String recString  = "INSERT INTO house (family_head, mother_name, house_type, kebele, house_number, family_members, reg_date) VALUES (" +
				"\""+"fh"+"\",\""+
				"mn"+"\",\""+
				"hosetyoe"+"\",\""+
				"kebele"+"\",\""+
				"housenumber"+"\",\""+
				"familymember"+"\","+
				"currdate()"+
				");"
				
				
			;
		
		String password = "abiti";
		
		AccountHelper.sessionid = "2";
		
		String uodatesdf = "UPDATE `users` SET `password`= \""+ password+"\""+" WHERE id ="+ AccountHelper.sessionid+";";
		
		String toggleString = "UPDATE `users` SET is_active = \"1\" WHERE id = id;";
		
		System.out.println(toggleString);
		
		String gethouseString = "SELECT * FROM `house` WHERE house_number = "+ "15";
		
		String reString = "0";
		
		if (reString.equals("1")) {
			
			System.out.println("trutuhghhj");
		}
		
		
		
		String akjsdhgfkjlgdjk = "INSERT INTO `mirage`(`bfname`, `bbirth_place`, `bdate_of_birth`, `gfname`, `gdate_of_birth`, `gbirthplace`, `mirage_date`) VALUES "
				
				+ "(\""+"Alula"+"\","
				+ "\""+"Welo"+"\","
				+ "\""+"Welo"+"\","
				+ "\""+"Welo"+"\","
				+ "\""+"Welo"+"\","
				+ "\""+"Welo"+"\","
				+ "\""+"Welo"+"\");";
		
		
		String child = "INSERT INTO `birth`( `fname`, `weight`, `date_of_birth`, `fatther_name`, `mother_name`) VALUES "
				+ "(\""+"saf\","
				+ "\""+"\","
				+ "\""+"\","
				+ "\""+"\","
				+"\""+"ssdfd"+"\")";
		
		
		System.out.println(child);
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
