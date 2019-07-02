package application;


import java.awt.Button;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.sun.glass.ui.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sun.plugin2.message.StartAppletAckMessage;
public class AdminController implements Initializable {
	
	 String username,password,toogleGroupValue;
	
	 JFXSnackbarLayout aSnackbarLayout;
	
	 File selectedFile;
	 
	 File usrphotopth;
	 
	public static boolean IS_PHOTO_SELECTED = false;
	
    @FXML
    public static AnchorPane anch;
    
    @FXML
    public static StackPane stkpane;
	
    @FXML
    private  JFXTextField etusername;

    @FXML
    private  JFXPasswordField etpassword;
	
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
    
    @FXML
    private JFXPasswordField etupdaetPasswordField;
    
    @FXML
    private ListView<javafx.scene.control.Label> lv1;
    
    
  static  AdminController minstance;
  
  @FXML
  private TableView<AdminUsers> table_info;
  
  @FXML
  private TableColumn<AdminUsers,String> colid;

  @FXML
  private TableColumn<AdminUsers,String> colname;

  @FXML
  private TableColumn<AdminUsers,String> coltype;

  @FXML
  private TableColumn<AdminUsers,String> colactive;
  
  @FXML
  private TableColumn<AdminUsers,String> colbutton;
  
 public static ObservableList<AdminUsers> table_data;
 
   
 
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
				  
				  General.showSnackbar(snackbar, aSnackbarLayout, "User Created Succesfully", General.snackbarError);
				  
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
		
		  JFXListView<javafx.scene.control.Label> list = new JFXListView<javafx.scene.control.Label>();
		
		
		initTable();
		
		loadData();
		
	}
	
	
	private void initTable() {
		
		initCols();
		
	}
	
	private void initCols() {
		
		colid.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		colname.setCellValueFactory(new PropertyValueFactory<>("username"));
		
		coltype.setCellValueFactory(new PropertyValueFactory<>("Type"));
		
		colactive.setCellValueFactory(new PropertyValueFactory<>("Active"));
		
		colbutton.setCellValueFactory(new PropertyValueFactory<>("update"));
		
		editableCols();
		
	}
	
	private void editableCols() {
		
		colid.setCellFactory(TextFieldTableCell.forTableColumn());
	
		colid.setOnEditCommit(e->{
			
				e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
			
			
		});
		
		
		colname.setCellFactory(TextFieldTableCell.forTableColumn());
		
		colname.setOnEditCommit(e->{
			
				e.getTableView().getItems().get(e.getTablePosition().getRow()).setUsername(e.getNewValue());
			
			
		});
		
		coltype.setCellFactory(TextFieldTableCell.forTableColumn());
		
		coltype.setOnEditCommit(e->{
			
				e.getTableView().getItems().get(e.getTablePosition().getRow()).setType(e.getNewValue());
			
			
		});
		
	table_info.setEditable(true);
	
	}
	
		
	private void loadData() {
		
		
	 table_data = FXCollections.observableArrayList();
		
		try {
			
			String typeString = "unknown";
			
			ResultSet aResultSet = DatabaseHelper.getAllAdminUsers();
			
			while (aResultSet.next()) {
				
				System.out.println("Usertype resultset "+aResultSet.getString("type"));
				
				if (aResultSet.getString("type").equals("0")) {
					
					typeString = "System Administrator";
					
				}
				
				else if (aResultSet.getString("type").equals("1")) {
					
					typeString = "Kebele Administrator";
				}
				
				else if (aResultSet.getString("type").equals("2")) {
					
					typeString = "Record Officer";
				}
				
				else {
					
					typeString = "Unknown Type";
				}
				
				table_data.add(new AdminUsers(aResultSet.getString("id"),
						aResultSet.getString("username"),					
						typeString,
						aResultSet.getString("is_active"),
						new JFXToggleButton(),
						aResultSet.getString("is_active")));
				
				
			
				
			}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		table_info.setItems(table_data);
	}
	
	
	  
    @FXML
    void logout(ActionEvent event) {

    	
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
	    	
	    	
			try {
				
				((Node)event.getSource()).getScene().getWindow().hide();
						
				
			    Parent	root1 = (Parent) fxmlLoader.load();
			    
			    AccountHelper.sessionid = "0";
			    
				Stage stage = new Stage();
				
				stage.setTitle("Login");
				
		    	stage.setScene(new Scene(root1));  
		    	stage.show();
		    	
			} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    
    @FXML
    void updateaccountpassword(ActionEvent event) {
    
		   
		   String password = etupdaetPasswordField.getCharacters().toString();
		   
		  
		   AccountHelper.changePassword(password);
		   
		   String toastMsg = "Password Changed Successfully";
  			int toastMsgTime = 2500; //3.5 seconds
  			int fadeInTime = 200; //0.5 seconds
  			int fadeOutTime= 200; //0.5 seconds
  			
  			Toast.makeText(Main.getStage(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		   
		   System.out.println("Cliked Update button");
    	

    }
	
}




