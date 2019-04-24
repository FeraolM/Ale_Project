package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

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

public class SampleController implements Initializable{
	
	int n = 4;
	
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
    	 	
        			
		  try {
		  
		  ResultSet as = DatabaseHelper.getInstance();
		  
		  as.next();
		  
			  		if (Lusername.equals( as.getString("username")) & Lpassword.equals(as.getString("password"))) {
			  			
			  				if (as.getBoolean("is_active") & as.getInt("type") == 1) {
			  					
			  					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
					  	    	
					  	    	Parent root1;
					  			try {
					  				((Node)event.getSource()).getScene().getWindow().hide();
					  				root1 = (Parent) fxmlLoader.load();
					  				Stage stage = new Stage();
					  		    	stage.setScene(new Scene(root1));  
					  		    	stage.show();
					  		    	 
					  			} catch (IOException e) {
					  				// TODO Auto-generated catch block
					  				e.printStackTrace();
					  			}
					  	
							}

			  	    			  			
					}
			  		
			  		else {
			  			
			  			
						System.out.println("Login error \n" + Lusername + Lpassword);
					}
			  	
		  }
		  
		  
		  
		  catch (Exception e) {
		  
		  e.printStackTrace();
		  
		  }
		 

    	
    }
    
}
		 
    
    



    


		  
  
		  
    
    

    

