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

import org.omg.CORBA.PUBLIC_MEMBER;

import com.gluonhq.impl.charm.a.b.b.h;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import sun.awt.image.URLImageSource;




public class KbadminController implements Initializable {
	
	@FXML
    private AnchorPane anch;

    @FXML
    private JFXTextField etusername;

    @FXML
    private JFXTextField etpassword;

    @FXML
    private JFXTextField etpassword1;

    @FXML
    private JFXTextField etpassword11;

    @FXML
    private JFXTextField etpassword111;

    @FXML
    private JFXRadioButton kbadminrd;

    @FXML
    private ToggleGroup admintype;

    @FXML
    private JFXRadioButton recadminrd;

    @FXML
    private JFXButton crtbtn;

    @FXML
    private JFXSnackbar snackbar;

    @FXML
    private ImageView imgview;

    @FXML
    private JFXButton choosephotobtn;

    @FXML
    private JFXTextField etusername1;

    @FXML
    private JFXTextField etusername11;

    @FXML
    private JFXTextField etpassword12;

    @FXML
    private JFXTextField etpassword121;

    @FXML
    private JFXTextField etpassword1211;

    @FXML
    private ListView<String> lv1;
    
    @FXML
    private JFXListView<Label> lv2;
    
    static String currentDirectory = System.getProperty("user.dir");
	 
	 static String accountimagesdirectory = "\\account_images";
    
    ObservableList<String> listview;
    
	
	
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Kbadmin.fxml"));
	
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




		
	
		
	
	

