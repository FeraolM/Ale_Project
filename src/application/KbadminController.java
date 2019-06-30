package application;

import java.awt.Button;

import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.kordamp.ikonli.javafx.FontIcon;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.gluonhq.impl.charm.a.b.b.h;
import com.gluonhq.impl.charm.a.b.b.p;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.base.ValidatorBase;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;

import javafx.animation.KeyValue;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import javafx.scene.paint.Paint;
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
    private JFXTextField etgender;

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
    private JFXTextField etusername;

    @FXML
    private JFXPasswordField etpassword;	
	
    @FXML
    private ListView<String> lv1;
    
    @FXML
    private JFXListView<Label> lv2;
    
    @FXML
    private JFXComboBox<String> cmgender;
    
    
    
    
    
    /*search user fields*/
    
    @FXML
    private JFXTextField srgender;

    @FXML
    private JFXTextField srfullname;

    @FXML
    private JFXTextField srid;
    
    @FXML
    private JFXTextField srmothername;

    @FXML
    private JFXTextField srphonenumber;

    @FXML
    private JFXTextField sr_place_of_birth;

    @FXML
    private JFXTextField srkebele;
    
    @FXML
    private DatePicker srdateofbirth;

    @FXML
    private JFXTextField srgivendate;
    
    @FXML
    private JFXTextField srexpirydate;
    
    @FXML
    private JFXTextField srwereda;

    @FXML
    private JFXTextField srhousenumber;

    @FXML
    private JFXTextField srjob;

    @FXML
    private JFXTextField sremergencynumber;

    @FXML
    private JFXTextField sremergencycontact;
     
    @FXML
    private ImageView imgvphoto;
    
    @FXML
    private FontIcon search;
    
    @FXML
    private FontIcon status;
    
    
    
    /*renew id*/
    
    
    @FXML
    private JFXTextField etidfieField;
    
    @FXML
    private Label givendateLabel;
    
    @FXML
    private Label expirydateLabel;
    
    @FXML
    private FontIcon statusFontIcon;
    
    
    @FXML
    private JFXButton renewButton;
    
    
    
    
    
    
    
    
    
    
    
    
    
    static String currentDirectory = System.getProperty("user.dir");
	 
	 static String accountimagesdirectory = "\\account_images";
    
    ObservableList<String> listview;

    ObservableList<TextInputValidator> inputTextFields;
    
    ObservableList<numberValidator> numberinputTextFields;
    
    ObservableList<String> typelist ;
    
	private Object[] JFXTextField;
    
	
	
	public void start(Stage primaryStage) {
		try {
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("Kbadmin.fxml"));
	
			Scene scene = new Scene(root,400,300);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			renewButton.setDisable(true);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	 static Image imggImagev;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		typelist = FXCollections.observableArrayList("Kebele","Private");
		
		renewButton.setDisable(true);
		
		//cmgender.setItems(typelist);
		// TODO Auto-generated method stub
		
		//File sFile = new File(currentDirectory+"\\res\\profile.png");
		

 	//JFXTextField[] numinputfields = {etemergencynumber,etkebele,etphonenumber};
 	
 	JFXTextField[] textFields = {etemergencynumber,ethousenumber, etemergencycontact,etfullname,etgender,etjob,etmothername,etwereda,et_place_of_birth,etkebele,etphonenumber,etemergencynumber};

 	JFXTextField[] numberFields = {etemergencycontact,etkebele,etphonenumber,ethousenumber};
 	
 
 	
    //	General.is_inputs_valid(numinputfields,crtbtn);
    	
    //	General.is_textinputs_valid(textFields, crtbtn);
int i;		
 	
 	for (i = 0; i < textFields.length-1; i++) {
			
		 inputTextFields = FXCollections.observableArrayList();
		 
		 inputTextFields.add(new TextInputValidator(textFields[i]));
		
 	}
 	
 	for (int x = 0; x < numberFields.length-1; x++) {
 		
 		numberinputTextFields = FXCollections.observableArrayList();
 		
 		numberinputTextFields = FXCollections.observableArrayList();
 		
 		numberinputTextFields.add(new numberValidator(numberFields[x]));
 		
 		
	}
		
		addlist();
	}
	
    @FXML
    void updateaccountpassword(ActionEvent event) {
    
		   
		   String password = etpassword.getCharacters().toString();
		   
		  
		   AccountHelper.changePassword(password);
		   
		   System.out.println("Cliked Update button");
    	

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
    void createresidence(ActionEvent event) throws IOException {

    	
    	try {
    		
    	String idString = null;
    	
    	String fname = etfullname.getCharacters().toString();
    	
    	String mothername = etmothername.getCharacters().toString(); 
    	
    	String dateofbirth = dpdateofbirth.getValue().toString();
    	
    	String placeofbirth = et_place_of_birth.getCharacters().toString();
    	
    	String kebele = etkebele.getCharacters().toString();
    	
    	String wereda = etwereda.getCharacters().toString();
    	
    	String housenumber = ethousenumber.getCharacters().toString();
    	
    	String gender = etgender.getCharacters().toString();
    	
    	String phonenumber = etphonenumber.getCharacters().toString();
    	
    	String job = etjob.getCharacters().toString();
    	
    	String emergencycontact = etemergencycontact.getCharacters().toString();
    	
    	String emergencynumber = etemergencynumber.getCharacters().toString();
    	
    	String tobetseted[] = {fname,mothername,dateofbirth,placeofbirth,kebele,wereda,housenumber,phonenumber,job,emergencycontact,emergencynumber,gender};
    	
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
    			+gender+ " \n"
    			+ "urllllll"+ " \n");
    	
    	
    	if (fname.isEmpty() | fname.trim().length() == 0) {
    		
    		System.out.println("emoty");
			
		}
    	   		
    	
    	System.out.println("clicked create button");
    	
    	JFXDialogLayout dialogLayout = new JFXDialogLayout();
    	
    	// General.showDialogue(stkpane, dialogLayout);
    	
    	String photourl = General.makepathfordbforresidence(selectedFile);
		  
	   ResultSet lsressSet =AccountHelper.addResidence(fname, mothername, phonenumber, dateofbirth, placeofbirth, kebele, wereda, housenumber, job, emergencycontact, emergencynumber,gender,photourl);  
    	
	   while (lsressSet.next()) {
		
		   idString = lsressSet.getString("LAST_INSERT_ID()");
		   
		 //  System.out.println(lsressSet.getString("LAST_INSERT_ID()"));
		   
		   
		
	}
	   
		//AccountHelper.get_last_inserted_residence();
    	
		 General.savefileresidenceimage(idString,selectedFile, usrphotopth, imgview,snackbar,sb_create_residence_status);
		 
		 
		 		  
			/**/
    	
    	
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
				
				
				//lv2.getItems().add(jLabel);
			
			
			
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
	

	    @FXML
	    void logout(ActionEvent event) {
	
		  System.out.println("Logout");
		  Platform.exit();
	        System.exit(0);

	    }
	    
	    @FXML
	    void searchuser(ActionEvent event) {
	    	
	    	String hString = General.currentDirectory;
	    	
	    	String id = srid.getCharacters().toString();
	    	
	    	ResultSet sdResultSet = AccountHelper.searchuser(id);
	    	
	    		try {
	    			
					while (sdResultSet.next()) {
						
						
					System.out.println(sdResultSet.getString("full_name"));
					
						srfullname.setText(sdResultSet.getString("full_name"));
						
						srmothername.setText(sdResultSet.getString("mother_name"));
						
						srphonenumber.setText(sdResultSet.getString("phone_number"));
						
						sr_place_of_birth.setText(sdResultSet.getString("place_of_birth"));
						
						srgender.setText(sdResultSet.getString("gender"));
						
						srwereda.setText(sdResultSet.getString("wereda"));
						
						srkebele.setText(sdResultSet.getString("kebele"));
						
						srhousenumber.setText(sdResultSet.getString("house_no"));
						
						srjob.setText(sdResultSet.getString("job"));
						
						srdateofbirth.setValue(LocalDate.parse((sdResultSet.getString("date_of_birth"))));
						
						srgivendate.setText(sdResultSet.getString("given_date"));
						
						srexpirydate.setText(sdResultSet.getString("expire_date"));
						
						sremergencycontact.setText(sdResultSet.getString("emergency_contact_name"));
						
						sremergencynumber.setText(sdResultSet.getString("emergency_contact_number"));
						
						String fdString = currentDirectory+sdResultSet.getString("photo_url");
						
						String saString = sdResultSet.getString("active");
						
						System.out.println(saString);
						
						if (saString.equals("1")) {
							
							status.setIconColor(Paint.valueOf("black"));
							status.setIconLiteral("fa-check-square-o");
							
						}
						
						else {
							
							status.setIconColor(Paint.valueOf("red"));
							
							status.setIconSize(25);
							
						//	status.setStyle("-fx-text-fill:red;");
							
							status.setIconLiteral("fa-times-circle-o");
						
						}
						
						
						
						FileInputStream imag;
						try {
							
							imag = new FileInputStream(fdString);
							
							Image image = new Image(imag,250,250,false,false);

							imgvphoto.setImage(image);
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
						
					
						
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    
	    	
	    	
		/*
		 * String fname = etfullname.getCharacters().toString();
		 * 
		 * String mothername = etmothername.getCharacters().toString();
		 * 
		 * String dateofbirth = dpdateofbirth.getValue().toString();
		 * 
		 * String placeofbirth = et_place_of_birth.getCharacters().toString();
		 * 
		 * String kebele = etkebele.getCharacters().toString();
		 * 
		 * String wereda = etwereda.getCharacters().toString();
		 * 
		 * String housenumber = ethousenumber.getCharacters().toString();
		 * 
		 * String gender = etgender.getCharacters().toString();
		 * 
		 * String phonenumber = etphonenumber.getCharacters().toString();
		 * 
		 * String job = etjob.getCharacters().toString();
		 * 
		 * String emergencycontact = etemergencycontact.getCharacters().toString();
		 * 
		 * String emergencynumber = etemergencynumber.getCharacters().toString();
		 */
			
		}
	    
	    
	    @FXML
	    void renewid(ActionEvent event) {
	    	
	  
			
	    	
	    	String idString = etidfieField.getCharacters().toString();
	    	
	    	String	expirydateStringasfsf = expirydateLabel.getText();
	    	
	    	AccountHelper.renewId(idString,expirydateStringasfsf);
	    	
	    	getidstatus(event);
	    	
	    	General general = new General();
			
			general.loadPreviewid(idString);
	    	

	    }
	    
	    @FXML
	    void getidstatus(ActionEvent event) {
	    	
	    	String idString = etidfieField.getCharacters().toString();
	    	
	    	String staString = null;
	    	
	    	String expirydateString = null;
	    	
	    	String givendateString = null;
	    	
	    	boolean booleanBind = idString.isEmpty();
	    	
	    	
	    	
	    	
	    	ResultSet aSet = AccountHelper.getStatus(idString);
	    	
	    	try {
	    		
	    		while (aSet.next()) {
	    			
	    			staString = aSet.getString("active");
	    			
	    			expirydateString = aSet.getString("expire_date");
	    			
	    			givendateString = aSet.getString("given_date");    			
					
				}
	    		
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
			    	if (staString.equals("1")) {
						
			    		statusFontIcon.setIconLiteral("fa-check-square-o");
			    		
			    		renewButton.setDisable(true);
			    		
			    		
					}
			    	
			    	else {
			    		
						statusFontIcon.setIconLiteral("fa-close");
						
						
						
						renewButton.setDisable(false);
					}
			    	
			   givendateLabel.setText(givendateString);
			   
			   expirydateLabel.setText(expirydateString);
	    	
	    	

	    }
	
	
}




		
	
		
	
	

