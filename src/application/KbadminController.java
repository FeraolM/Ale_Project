package application;

import java.awt.Button;

import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.kordamp.ikonli.javafx.FontIcon;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.gluonhq.impl.charm.a.b.b.h;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import sun.awt.image.URLImageSource;




public class KbadminController implements Initializable {
	
	@FXML
	private StackPane stkpane;
	
	 JFXSnackbarLayout sb_create_residence_status;
	
	@FXML
	private AnchorPane anch;

    @FXML
    private JFXTextField etfullname;

    @FXML
    private JFXTextField etmothername;

    @FXML
    private JFXTextField etphonenumber;

    @FXML
    private JFXTextField et_place_of_birth;

    @FXML
    private JFXTextField etkebele;

    @FXML
    private JFXButton crtbtn;

    @FXML
    private JFXSnackbar snackbar;

    @FXML
    private ImageView imgview;

    @FXML
    private JFXButton choosephotobtn;
    

	 File selectedFile;
	 
	 File usrphotopth;
	 
	public static boolean IS_PHOTO_SELECTED = false;

    @FXML
    private DatePicker dpdateofbirth;

    @FXML
    private JFXTextField etwereda;

    @FXML
    private JFXTextField ethousenumber;

    @FXML
    private JFXTextField etjob;

    @FXML
    private JFXTextField etemergencynumber;

    @FXML
    private JFXTextField etemergencycontact;
    
    @FXML
    private JFXDialog dgalert;

	
	
    @FXML
    private ListView<String> lv1;
    
    @FXML
    private JFXListView<Label> lv2;
    
    static String currentDirectory = System.getProperty("user.dir");
	 
	 static String accountimagesdirectory = "\\account_images";
    
    ObservableList<String> listview;
    
	
	
	public void start(Stage primaryStage) {
		try {
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("Kbadmin.fxml"));
	
			Scene scene = new Scene(root,400,300);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	 static Image imggImagev;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//File sFile = new File(currentDirectory+"\\res\\profile.png");
		

		addlist();
	}
	
	
    @FXML
    void selectphoto(ActionEvent event) {
    	
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
    void createresidence(ActionEvent event) {
    	
    	try {
    	
    	String fname = etfullname.getCharacters().toString();
    	
    	String mothername = etmothername.getCharacters().toString(); 
    	
    	String dateofbirth = dpdateofbirth.getValue().toString();
    	
    	String placeofbirth = et_place_of_birth.getCharacters().toString();
    	
    	String kebele = etkebele.getCharacters().toString();
    	
    	String wereda = etwereda.getCharacters().toString();
    	
    	String housenumber = ethousenumber.getCharacters().toString();
    	
    	String phonenumber = etphonenumber.getCharacters().toString();
    	
    	String job = etjob.getCharacters().toString();
    	
    	String emergencycontact = etemergencycontact.getCharacters().toString();
    	
    	String emergencynumber = etemergencynumber.getCharacters().toString();
    	
    	String tobetseted[] = {fname,mothername,dateofbirth,placeofbirth,kebele,wereda,housenumber,phonenumber,job,emergencycontact,emergencynumber};
    	
    	//Test.check(tobetseted);
    	
    	System.out.println(fname + mothername+ "\n"
    			+dateofbirth+ " \n"
    			+placeofbirth+ " \n"
    			+dateofbirth+ " \n"
    			+kebele+ " \n"
    			+wereda+ " \n"
    			+housenumber+ " \n"
    			+phonenumber+ " \n"
    			+job+ " \n"
    			+emergencycontact+ " \n"
    			+emergencynumber+ " \n"
    			+ "urllllll"+ " \n");
    	
    	
    	if (fname.isEmpty() | fname.trim().length() == 0) {
    		
    		System.out.println("emoty");
			
		}
    	
    	
    	
    	
    	System.out.println("clicked create button");
    	
    	JFXDialogLayout dialogLayout = new JFXDialogLayout();
    	
    	String photourl = General.makepathfordbforresidence(selectedFile);
		  
		AccountHelper.addResidence(fname, mothername, phonenumber, dateofbirth, placeofbirth, kebele, wereda, housenumber, job, emergencycontact, emergencynumber, photourl);  
    	
		AccountHelper.get_last_inserted_residence();
    	
		 General.savefileresidenceimage(selectedFile, usrphotopth, imgview,snackbar,sb_create_residence_status);
		  
		  
		 
		  
		  dialogLayout.getStyleClass().add("dglayout");
		  
		  
		  JFXButton button = new JFXButton("Okay");
		  
		  JFXButton jfoenixButton = new JFXButton("JFoenix Button");
		  JFXButton abutton = new JFXButton("Raised Button".toUpperCase());
		  
	 abutton.setStyle("-fx-background-color: rgb(255,0,0);"
	 		+ " -fx-font-size: 14px;"
	 		+ "-jfx-button-type: RAISED;"
	 		+ "-fx-text-fill: WHITE;");
		  
		  button.getStyleClass().add("button-raised");
		
		
		  
		  JFXDialog dialog = new JFXDialog(stkpane,dialogLayout,JFXDialog.DialogTransition.BOTTOM);
		  
		  button.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseevent)-> {
			  
			  
			  dialog.close();
			  
			  
		  });
		  
		  Text ghText = new Text("Welcome ghdfsghjklhgfj");
		  
		  	ghText.setStyle("-fx-background-color: rgb(255,0,0);");
		  	
		  dialogLayout.setBody(ghText);
		  
		  dialogLayout.setActions(button,abutton);
		  
		 button.setStyle("  .button-raised{\r\n" + 
		 		"		      -fx-padding: 0.7em 0.57em;\r\n" + 
		 		"		      -fx-font-size: 14px;\r\n" + 
		 		"		      -jfx-button-type: RAISED;\r\n" + 
		 		"		      -fx-background-color: rgb(77,102,204);\r\n" + 
		 		"		      -fx-pref-width: 70;\r\n" + 
		 		"		      -fx-text-fill: WHITE;\r\n" + 
		 		"		  }"
		 		+ ""
		 		+ ".button-raised:hover{\r\n" + 
		 		"    -fx-background-color: #fff;\r\n" + 
		 		"    -fx-border-color: derive(-fx-color-1, -20%);\r\n" + 
		 		"    -fx-text-fill: white;\r\n" + 
		 		"}");
		  
		  dialog.show();
	
    	
    	
    	} catch (Exception e) {
    		
    		
    			
		}
    	
  	  
		  
			
		  
	
		 
		/*
		 * Alert alert = new Alert(AlertType.ERROR, "Error");
		 * 
		 * alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); alert.show();
		 */
    	
    	

    }
	
	HBox hBox;
	
	Button button;
	
	public void addlist() {
		
		Button asButton = new Button("saf");
		
		hBox = new HBox(10);
		
		button = new Button("vshdfkjg");
		
		ResultSet allustResultSet  = AccountHelper.getAllKbadminUser();
	try {
		
		
		while (allustResultSet.next()) {
			
			
			
			Label jLabel =  new Label(allustResultSet.getString("username") + "  "+ allustResultSet.getString("Type"));
			
			
			//	hBox.getChildren().addAll(button);
				
				try {
					
		    		imag = new FileInputStream(currentDirectory+"//res//profile.png");
		    		
		    		asButton = new Button("Check");
		    		
		    		imggImagev = new Image(imag,20,20,true,true);
		    		
				    	} catch (FileNotFoundException e) {
				    		// TODO Auto-generated catch block
				    		e.printStackTrace();
				   }
				
				jLabel.setGraphic(new ImageView(imggImagev));
				
				
				lv2.getItems().add(jLabel);
			
			
			
			//listview = FXCollections.observableArrayList("Axsparagus", "Beans", "Broccoli", "Cabbage" , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom" , "Pepper", "Radish", "Shallot", "Spinach", "Swede" , "Turnip");
			
		}
		
	} catch (SQLException e1) {
		
		// TODO Auto-generated catch block
		
		e1.printStackTrace();
	}	
		
		for (int i = 0; i <5; i++) {
		
			
			
    	
		}
		
		System.out.println("Add list called\n"+ " current directory "+currentDirectory);
		
		
		
	
	};
		
	/*	lv2.setItems(listview);
		
		lv1.setItems(listview);*/
		
	   
	  
	 //   for (int i = 1; i < 5; i++) lv2.getItems().add(new Label("Item " + i));

	
	static FileInputStream imag;
	


	
	
}




		
	
		
	
	

