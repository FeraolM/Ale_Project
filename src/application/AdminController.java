package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class AdminController implements Initializable {
	
	 String username,password,toogleGroupValue;
	
	 JFXSnackbarLayout aSnackbarLayout;
	
	 File selectedFile;
	 
	 File usrphotopth;
	 
	public static boolean IS_PHOTO_SELECTED = false;
	
    @FXML
    private AnchorPane anch;
	
    @FXML
    private  JFXTextField etusername;

    @FXML
    private  JFXTextField etpassword;
	
    @FXML
    private  JFXRadioButton sysadminrd;

    @FXML
    private  ToggleGroup admintype;

    @FXML
    private  JFXRadioButton kbadminrd;

    @FXML
    private JFXRadioButton recadminrd;

    @FXML
    private JFXRadioButton custrd;
    
    @FXML
    private JFXButton crtbtn;
    
    @FXML
   private JFXSnackbar snackbar;
    
    @FXML
    private ImageView imgview;
    

    @FXML
    private JFXButton choosephotobtn;
    
    
  static  AdminController minstance;

    
    @FXML
    void chooseimage(ActionEvent event) {
    	
    	  FileChooser fileChooser = new FileChooser();
		 
		  fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image files","*.jpg","*.png"));
		 
		  selectedFile = fileChooser.showOpenDialog(null);
		 
		  usrphotopth = selectedFile.getAbsoluteFile();	
				
			
			try {
				
				if (selectedFile.exists()) {
					
					FileInputStream imag = new FileInputStream(selectedFile.getAbsolutePath());				
					
					Image image = new Image(imag,250,250,false,false);

					imgview.setImage(image);
					
					IS_PHOTO_SELECTED =true;
					
				}
				
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			

    }

    @FXML
    void createAccount(ActionEvent event) {
    	   	
    	  username= etusername.getCharacters().toString();
		  
		  password = etpassword.getCharacters().toString();
		  		  
		  RadioButton selectedRadioButton = (RadioButton) admintype.getSelectedToggle();
		  	  
		  toogleGroupValue = selectedRadioButton.getText();
		  
		  
		  if (username.isEmpty() | username == null | password.isEmpty() | password == null | !IS_PHOTO_SELECTED ) {
			  
			  
				General.showSnackbar(snackbar, aSnackbarLayout, "Username/Password cannot be empty", General.snackbarError);
			  	
		  }
		  
		  else {
		  
				  switch (toogleGroupValue) {
				  
				  case "System Admin":
				  
				  DatabaseHelper.Adduser(username, password,0,General.makepathfordb(selectedFile));
				  
				  etpassword.setText(""); etusername.setText(""); imgview.setImage(null);
				  
				  General.savefile(selectedFile, usrphotopth, imgview,snackbar,aSnackbarLayout);
				  
				  
				  break;
				  
				  case "Record Officer":
				  
				  DatabaseHelper.Adduser(username, password,1,General.makepathfordb(selectedFile));
				  
				  etpassword.setText(""); etusername.setText(""); imgview.setImage(null);
				  
				  General.savefile(selectedFile, usrphotopth, imgview,snackbar,aSnackbarLayout);
				  
				  break;
				  
				  case "Keble Admin":
				  
				  DatabaseHelper.Adduser(username, password,2,General.makepathfordb(selectedFile));
				  
				  etpassword.setText(""); etusername.setText("");
				  
				  General.savefile(selectedFile, usrphotopth, imgview,snackbar,aSnackbarLayout);
				  
				  break;
				  
				  case "Customer":
				  
				  DatabaseHelper.Adduser(username, password,3,General.makepathfordb(selectedFile));
				  
				  etpassword.setText(""); etusername.setText("");
				  
				  General.savefile(selectedFile, usrphotopth, imgview,snackbar,aSnackbarLayout);
				  
				  break;
				  
				  default:
				  
				  break; }
		  
		  }
    	
				 
    			

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}
	
		
	
	
}




