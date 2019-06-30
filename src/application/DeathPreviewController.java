package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.jfoenix.controls.JFXButton;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.coobird.thumbnailator.Thumbnails;

public class DeathPreviewController implements Initializable {

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

	ResultSet lastidString;

	public void setid(String id) {

		String dname = null;
		String place= null;
		String dateofdeath = null;

		this.asd = id;

		System.out.println("id called " + this.asd);

		// imag = new
		// FileInputStream(System.getProperty("user.dir")+"\\res\\profile.png");

		lastidString = AccountHelper.getDeath(this.asd);

		File file = new File(System.getProperty("user.dir") + "\\res\\certificate\\death.png");
		
		if (file.exists()) {
			
			System.out.println("Birth certificate found");
			
		}

		BufferedImage image = null;

		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// BufferedImage buffered = General.to

		// image = new Image(imag,250,250,false,false);

//		BufferedImage bufferedImage = new BufferedImage(366,376,BufferedImage.TYPE_INT_BGR);

		/*
		 * InputStream inputStream = new FileInputStream("ssdg");
		 * 
		 * BufferedImage bufferedImage2 = (BufferedImage)image;
		 */

		try {

			while (lastidString.next()) {

				
				dname = lastidString.getString("fname");
							
				dateofdeath = lastidString.getString("date_of_death");
				
				place = lastidString.getString("place_of_death");
				
		
				 
				
				 
				 

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Graphics g = image.getGraphics();

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);

		Font myFont = new Font("Courier New", 0, 25);

		g2.setFont(myFont);

		// g2.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

		g2.drawString(id, 220, 130);

		g2.drawString(dname, 45, 270);
		
		g2.drawString(dateofdeath, 120, 343);
		
		g2.drawString(place, 78, 400);
		
		  
		 
	
		  
		 

		// ivid.setImage(g2);

		Image card = SwingFXUtils.toFXImage(image, null);

		this.ivid.setImage(card);

		this.lb1.setText("Id Generated");

	//
		
		/*
		 * btnprint.setText("Print Now");
		 * 
		 * btnprint.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) {
		 * System.out.println("Hello World!"); } });
		 */
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		
		
		  try {
			  
			return Thumbnails.of(img).size(newW, newH).asBufferedImage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
		}

}
