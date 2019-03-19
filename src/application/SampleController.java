package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleController implements Initializable{
	
	int n = 4;
	@FXML
    private JFXButton btnlog;

	@FXML
    private JFXTextField txtfile;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
	}
	
    @FXML
    void loginfn(ActionEvent event) {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
    	Parent root1;
		try {
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
	    	stage.setScene(new Scene(root1));  
	    	stage.show();
	    	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    		
		
		  try {
		  
		  ResultSet as = DatabaseHelper.getInstance("SELECT * FROM users");
		  
		  while (as.next()){
		  
		  System.out.println(as.getString("username"));
		  
		  if (as.getBoolean(5)) {
		  
			  
			
	
		  }
		  
		  else {
			  
			  
		  }
		  
		  }
		  
		  }
	
		  
		  catch (Exception e) {
		  
		  e.printStackTrace();
		  
		
		  
		  }
		 
        
    
    }
    


}
    


		  
  
		  
    
    

    

