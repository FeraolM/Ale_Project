package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GenerateIdPreviewController implements Initializable {
	
	@FXML
	ImageView ivid;
	
	@FXML 
	Label lb1; 
	
	@FXML 
	JFXButton btnprint; 
	
	String asd;
	
	
	FileInputStream imag;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	public  void setid(String id) {
		
		this.asd = id;
		
		System.out.println("id called "+this.asd);
		
		
		
		
		try {
			
			imag = new FileInputStream(System.getProperty("user.dir")+"\\res\\profile.png");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		Image image = new Image(imag,250,250,false,false);
		
	this.ivid.setImage(image);
		
		this.lb1.setText("new label defined");
		
		
	}
	
	

}
