package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.ui.Application;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {
	
		
		public final int SYSTEM_ADMINISTRATOR = 0;
		
		public final int KB_ADMINISTRATOR = 1;
		
		public final int RECORD_OFFICER = 2;
	
		@FXML
	    private JFXButton loginbtn; 

	    @FXML
	    private JFXTextField Luname;

	    @FXML
	    private JFXPasswordField Lpass;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	

		//FontAwesomeIconView fontAwesomeIconView = new FontAwesomeIconView(FontAwesomeIcon.ANGELLIST);  

	//	MaterialDesignIconView materialDesignIconView = new MaterialDesignIconView(MaterialDesignIcon.THUMB_UP); materialDesignIconView.setSize("4em");
		
	}
	
    @FXML
    void loginfn(ActionEvent event) {
    	
    	String Lusername,Lpassword;
    
    	
    	Lusername = Luname.getCharacters().toString();
    	Lpassword = Lpass.getCharacters().toString();
    	 	
    	if (Lusername.equals("") | Lusername.isEmpty() | Lpassword.equals("") | Lpassword.isEmpty()) {
			
    		
    		  System.out.println("Invalid Input");
		} 
    	
    	else {
			
        			
		  try {
		  
		  ResultSet as = DatabaseHelper.Login(Lusername);
	 
		  
		  while (as.next()) {
			
		  
			  		if (Lusername.equals( as.getString("username")) & Lpassword.equals(as.getString("password"))) {
			  			
			  		AccountHelper.sessionid =(as.getString("id"));
			  		
			  		System.out.println("user id number is "+as.getString("id"));
	  			
			  				if (as.getBoolean("is_active") & as.getInt("type") == SYSTEM_ADMINISTRATOR) { //System
			  					
			  					
			  					
			  					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
					  	    	
					  	    	Parent root1;
					  			try {
					  				((Node)event.getSource()).getScene().getWindow().hide();
					  				
					  				root1 = (Parent) fxmlLoader.load();
					  				Stage stage = new Stage();
					  				
					  				stage.setTitle("System Administrator");
					  				
					  				// stage.initStyle(StageStyle.TRANSPARENT);
					  			
					  				
					  		    	stage.setScene(new Scene(root1));  
					  		    	stage.show();
					  		    	 
					  			} catch (IOException e) {
					  				// TODO Auto-generated catch block
					  				e.printStackTrace();
					  			}
					  	
							}
			  				
			  				else if (as.getBoolean("is_active") & as.getInt("type") == KB_ADMINISTRATOR) {
			  					
			  					
			  					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Kbadmin.fxml"));
					  	    	
					  	    	
					  			try {
					  				((Node)event.getSource()).getScene().getWindow().hide();
					  				
					  			Parent	root1 = (Parent) fxmlLoader.load();
					  				Stage stage = new Stage();
					  				
					  				stage.setTitle("Kebele Administrator");
					  				
					  		    	stage.setScene(new Scene(root1));  
					  		    	stage.show();
					  		    	 
					  			} catch (IOException e) {
					  				// TODO Auto-generated catch block
					  				e.printStackTrace();
					  			}
								
							}
			  				
			  				else if (as.getBoolean("is_active") & as.getInt("type") == RECORD_OFFICER) {
			  					
			  					System.out.println(as.getInt("type"));
			  					
			  					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Kbrecordofficer.fxml"));
					  	    	
					  	    	
					  			try {
					  				
					  				((Node)event.getSource()).getScene().getWindow().hide();
					  				
					  				Parent root1 = (Parent) fxmlLoader.load();				  				
					  				
					  				Stage stage = new Stage();
					  				
					  				stage.setTitle("Record Officer");
					  				
					  		    	stage.setScene(new Scene(root1));  
					  		    	
					  		    	stage.show();
					  		    	 
					  			} catch (IOException e) {
					  				// TODO Auto-generated catch block
					  				e.printStackTrace();
					  			}
								
							}
			  				
			  				else {
								System.err.println("Error loading xml files");
								
								System.exit(0);
							}
			  				
			  	    			  			
					}
			  		
			  		else {

			  			String toastMsg = "Incorrect Password";
			  			int toastMsgTime = 2500; //3.5 seconds
			  			int fadeInTime = 200; //0.5 seconds
			  			int fadeOutTime= 200; //0.5 seconds
			  			
			  			Toast.makeText(Main.getStage(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
			  			
						System.out.println("Login error \n" + Lusername + Lpassword);
					}
			  
		  		}
		  }
		  
		  
		  
		  catch (Exception e) {
		  
		  e.printStackTrace();
		  
		
		  
		  }
		  
		  
    	}
		 

    	
    }
    
}
		 
    
    



    


		  
  
		  
    
    

    

