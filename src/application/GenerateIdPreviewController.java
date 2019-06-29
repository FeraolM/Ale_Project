package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
		
		BufferedImage bufferedImage = new BufferedImage(366,376,BufferedImage.TYPE_INT_BGR);
	     
		InputStream inputStream = new FileInputStream("ssdg");
		
		BufferedImage bufferedImage2 = new BufferedInputStream(inputStream);

		
		
		Graphics g = bufferedImage.getGraphics();
	
		
		 
		 Graphics2D g2 = (Graphics2D) g;
		 
		 g2.setColor(java.awt.Color.black);
		 
		 g2.setColor(Color.BLACK);
		 
		 Font myFont = new Font ("Courier New", 1 , 25);
		 
		 g2.setFont(myFont);
		 
		// g2.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		
		 
	 g2.drawString("SP-"+hashids.decode(hash)[0], 135, 335); //qr image number name
		 
		
	 
	 ivid.setImage(g2);
		
	this.ivid.setImage(image);
		
		this.lb1.setText("new label defined");
		
		
	}
	
	

}
