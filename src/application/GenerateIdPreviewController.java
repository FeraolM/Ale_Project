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

	ResultSet lastidString;

	public void setid(String id) {

		String idString = null, fname = null, mothername = null, placeofbirth = null, dateofbirth = null, gender = null,
				kebele = null, wereda = null, housenumber = null, job = null, emergecname = null, emergnumber = null,
				givendate = null, expirydate = null,
				photourl = null;

		this.asd = id;

		System.out.println("id called " + this.asd);

		// imag = new
		// FileInputStream(System.getProperty("user.dir")+"\\res\\profile.png");

		lastidString = AccountHelper.getUser(this.asd);

		File file = new File(System.getProperty("user.dir") + "\\res\\id\\id.png");

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

				idString = lastidString.getString("id");

				fname = lastidString.getString("full_name");

				mothername = lastidString.getString("mother_name");
				
				placeofbirth = lastidString.getString("place_of_birth");
				
				dateofbirth = lastidString.getString("date_of_birth");
				
				 gender = lastidString.getString("gender");
				 
				 kebele = lastidString.getString("kebele");
				 
				 wereda = lastidString.getString("wereda");
				 
				 housenumber = lastidString.getString("house_no");
				 
				 job = lastidString.getString("job");
				 
				 emergecname = lastidString.getString("emergency_contact_name");
				 
				 emergnumber = lastidString.getString("emergency_contact_number");
				 
				 expirydate = lastidString.getString("expire_date");
				 
				 givendate = lastidString.getString("given_date");
				 
				 photourl = lastidString.getString("photo_url");
				 
				 

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Graphics g = image.getGraphics();

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);

		Font myFont = new Font("Courier New", 0, 15);

		g2.setFont(myFont);

		// g2.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

		g2.drawString(id, 60, 27);

		g2.drawString(fname, 140, 219); // full name

		g2.drawString(mothername, 145, 262); // mother name
		
		  g2.drawString(placeofbirth,145, 302); // place of birth
		  
		  g2.drawString(dateofbirth,145, 335); // date of birth
		  
		  g2.drawString(gender,145, 364); // gender
		  
		  g2.drawString(kebele,450, 80); // kebele
		  
		  g2.drawString(wereda,450, 112); // gender
		  
		  g2.drawString(housenumber, 508, 155);
		  
		  g2.drawString(job, 425, 180);
		  
		  g2.drawString(emergecname, 588, 210);
		  
		  g2.drawString(emergnumber, 600, 245);
		  
		  try {
			  
			  File fileas = new File(System.getProperty("user.dir") + "\\res\\id\\id.png");
			  
			  BufferedImage imagen = new BufferedImage(135,200 , BufferedImage.TYPE_INT_ARGB);
			  
			imagen = ImageIO.read(new File(System.getProperty("user.dir") + photourl));
			
	
		
			 g2.drawImage(imagen, 51, 51, null);
		 	 
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 

		// ivid.setImage(g2);

		Image card = SwingFXUtils.toFXImage(image, null);

		this.ivid.setImage(card);

		this.lb1.setText("new label defined");

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

}
