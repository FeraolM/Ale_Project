package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecordHelper {
	
	//INSERT INTO house (id, family_head, mother_name, house_type, kebele, house_number, family_members, reg_date) VALUES 

	Statement statement;
	
	ResultSet resultSet;
	
	static String regdate  = "CURDATE()";
	
	public static int registerhouse(String familyhead,String mothername,String housetype,String kebele,String housenumber,String familymember) {
		
		try {
			Statement statement = DatabaseHelper.getConnection().createStatement();
			
			String regquery  = "INSERT INTO house (family_head, mother_name, house_type, kebele, house_number, family_members, reg_date) VALUES (" +
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

	public void generateMirageCertificate(String bfname,LocalDate bdateofbirth,String bbirth_place, String gfname,LocalDate gdate_of_birth,String gbirthplace,LocalDate mirage_date,String mirage_place ) {
		
		String lastid = null;
		
	String mquery =	"INSERT INTO `mirage`(`bfname`, `bbirth_place`, `bdate_of_birth`, `gfname`, `gdate_of_birth`, `gbirthplace`, `mirage_date`, `mirage_place`) VALUES "
		
				+ "(\""+bfname+"\","
				+ "\""+bbirth_place+"\","
				+ "\""+bdateofbirth+"\","
				+ "\""+gfname+"\","
				+ "\""+gdate_of_birth+"\","
				+ "\""+gbirthplace+"\","
				+ "\""+mirage_date+"\","
				+ "\""+mirage_place+"\");";
	
	try {
		
		
		Statement statement= DatabaseHelper.getConnection().createStatement();
		
		statement.executeUpdate(mquery);
			
		ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
		
		
		
				while (resultSet.next()) {
					
					lastid = resultSet.getString("LAST_INSERT_ID()");
					
				}
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
	
	
	
	
		System.out.println(mquery);
		
		FXMLLoader fxmlLoader = new FXMLLoader();
    	
    	fxmlLoader.setLocation(getClass().getResource("mirage.fxml"));
    	
    	try {
			fxmlLoader.load();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
    	MiragePreviewController generateIdPreviewController = fxmlLoader.getController();
    	
    	generateIdPreviewController.setid(lastid);
    	
       
		Parent root1 = fxmlLoader.getRoot();
		
		    Stage stage = new Stage();
		    
		    stage.setScene(new Scene(root1));  
		
		    stage.show();
		
		String toastMsg = "Generated Successfully " + lastid ;
			int toastMsgTime = 2500; //3.5 seconds
			int fadeInTime = 200; //0.5 seconds
			int fadeOutTime= 200; //0.5 seconds
			
			Toast.makeText(Main.getStage(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		
	}
	
	
	
public void generateDivorceCertificate(String bfname,LocalDate date,String place, String gfname ) {
		
		String lastid = null;
		
	String mquery =	"INSERT INTO `divorce`(`bfname`, `gfname`, `place`, `date`) VALUES "
		
				+ "(\""+bfname+"\","
				+ "\""+gfname+"\","				
				+ "\""+place+"\","			
				+ "\""+date+"\");";
	
	try {
		
		
		Statement statement= DatabaseHelper.getConnection().createStatement();
		
		statement.executeUpdate(mquery);
			
		ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
		
		
		
				while (resultSet.next()) {
					
					lastid = resultSet.getString("LAST_INSERT_ID()");
					
				}
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
	
	
	
	
		System.out.println(mquery);
		
		FXMLLoader fxmlLoader = new FXMLLoader();
    	
    	fxmlLoader.setLocation(getClass().getResource("divorce.fxml"));
    	
    	try {
			fxmlLoader.load();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
    	DivorcePreviewController generateIdPreviewController = fxmlLoader.getController();
    	
    	generateIdPreviewController.setid(lastid);
    	
       
		Parent root1 = fxmlLoader.getRoot();
		
		    Stage stage = new Stage();
		    
		    stage.setScene(new Scene(root1));  
		
		    stage.show();
		
		String toastMsg = "Generated Successfully " + lastid ;
			int toastMsgTime = 2500; //3.5 seconds
			int fadeInTime = 200; //0.5 seconds
			int fadeOutTime= 200; //0.5 seconds
			
			Toast.makeText(Main.getStage(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		
	}
	
	

public void generateDeathCertificate(String dname,LocalDate date,String place) {
	
	String lastid = null;
	
String mquery =	"INSERT INTO `death`(`fname`, `date_of_death`, `place_of_death`) VALUES "
	
			+ "(\""+dname+"\","
			+ "\""+date+"\","					
			+ "\""+place+"\");";

try {
	
	
	Statement statement= DatabaseHelper.getConnection().createStatement();
	
	statement.executeUpdate(mquery);
		
	ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
	
	
	
			while (resultSet.next()) {
				
				lastid = resultSet.getString("LAST_INSERT_ID()");
				
			}
			
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");




	System.out.println(mquery);
	
	FXMLLoader fxmlLoader = new FXMLLoader();
	
	fxmlLoader.setLocation(getClass().getResource("death.fxml"));
	
	try {
		fxmlLoader.load();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	DeathPreviewController generateIdPreviewController = fxmlLoader.getController();
	
	generateIdPreviewController.setid(lastid);
	
   
	Parent root1 = fxmlLoader.getRoot();
	
	    Stage stage = new Stage();
	    
	    stage.setScene(new Scene(root1));  
	
	    stage.show();
	
	String toastMsg = "Generated Successfully " + lastid ;
		int toastMsgTime = 2500; //3.5 seconds
		int fadeInTime = 200; //0.5 seconds
		int fadeOutTime= 200; //0.5 seconds
		
		Toast.makeText(Main.getStage(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
	
}


	
	


}
