package application;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.gluonhq.impl.charm.a.b.b.l;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.control.TableColumnSortTypeWrapper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class KbrecordofficerController implements Initializable {
	
	   @FXML
	    private StackPane stkpane;
	   
	    @FXML
	    private JFXTextField tf_house_number_field;

	    @FXML
	    private JFXTextArea ta_family_members;

	    @FXML
	    private JFXTextField tf_family_head;

	    @FXML
	    private JFXTextField tf_mother_name;

	    @FXML
	    private JFXTextField Tf_kebele;

	    @FXML
	    private JFXTextField Tf_house_number;

	    @FXML
	    private JFXComboBox<String> cb_house_type;
	    
	    @FXML
	    private ComboBox<String> fxcombo;
	    
	    @FXML
	    private JFXButton btn_search;
	

    @FXML
    private JFXComboBox<String> House_type;

    
    @FXML
    private JFXTextArea textarea1;


    @FXML
    private JFXTextField etfullname;

    @FXML
    private JFXTextField etmothername;

    @FXML
    private JFXButton crtbtn;

    @FXML
    private JFXSnackbar snackbar;

    @FXML
    private ImageView imgview;

    @FXML
    private JFXTextField etkebele;

    @FXML
    private JFXTextField ethousenumber;

    @FXML
    private JFXDialog dgalert;

    @FXML
    private JFXSnackbar sb_create_residence_status;
    
    
    
    
    @FXML
    private JFXTextField etbfname;
    
    @FXML
    private JFXTextField etbbirthplace;
    
    @FXML
    private JFXDatePicker bdateofbirth;
    
    

    @FXML
    private JFXTextField etgfname;
    
    @FXML
    private JFXTextField etgbirthplace;
    
    @FXML
    private JFXDatePicker gdateofbirth;
    
    

    @FXML
    private JFXTextField etplaceofmirage;
    
    @FXML
    private JFXDatePicker dateofmirage;
    
   /*Birth certificate*/
    
    
    
    @FXML
    private JFXTextField etchname;
    
    @FXML
    private JFXTextField etfaname;
    
    @FXML
    private JFXTextField etmname;
    
    @FXML
    private JFXTextField etweight;
    
    @FXML
    private JFXDatePicker cdateofbirth;
    
    
   /*Divorce certificate*/
    
    
    
    @FXML
    private JFXTextField bfname;
    
    @FXML
    private JFXTextField gfname;
    
    @FXML
    private JFXTextField placeofdivorce;
 
    @FXML
    private JFXDatePicker dateofdivorce;
    
    
    
    
    
    
    
    
    
    
    


    @FXML
    private JFXListView<?> lv2;

    ObservableList<String> typelist = FXCollections.observableArrayList("Kebele","Private");
    
    ObservableList<String> tt = FXCollections.observableArrayList();
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		House_type.setItems(typelist);
		
	}
	/*
	 * @Override public void initialize(URL arg0, ResourceBundle arg1) { // TODO
	 * Auto-generated method stub
	 * 
	 * House_type.setItems(typelist);
	 * 
	 * }
	 */
	

    @FXML
    void combochanged(ActionEvent event) {
    	
    	System.out.println(House_type.getValue());

    }

    
    @FXML
    void RegisterHouse(ActionEvent event) {
    	
    String familyhead = etfullname.getCharacters().toString();
    
    String mothername = etmothername.getCharacters().toString();
    
    String housetype = House_type.getValue();
    
    String kebele = etkebele.getCharacters().toString();
    
    String familymember = textarea1.getText();
    
    String housenumber = ethousenumber.getCharacters().toString();
    
    
   int result =  RecordHelper.registerhouse(familyhead, mothername, housetype, kebele, housenumber, familymember);

   	System.out.println("result "+ String.valueOf(result));
   
    }
    
    
    @FXML
    void searchhouse(ActionEvent event) {
    	
    	String housenumber = tf_house_number_field.getCharacters().toString();
    	
    	ResultSet ressSet = RecordHelper.gethouse(housenumber);
    	
    	try {
    		
			while (ressSet.next()) {
				
				tf_family_head.setText(ressSet.getString("family_head"));
				
				tf_mother_name.setText(ressSet.getString("mother_name"));
				
				Tf_kebele.setText(ressSet.getString("kebele"));
				
				Tf_house_number.setText(ressSet.getString("house_number"));
				
				ta_family_members.setText(ressSet.getString("family_members"));
				
				tt.addAll(ressSet.getString("house_type"));
				
				fxcombo.setItems(tt);
				
				cb_house_type.setItems(tt);
								
				cb_house_type.setValue(ressSet.getString("house_type"));
				
				fxcombo.setValue(ressSet.getString("house_type"));
				
			//	System.out.println(ressSet.getString("house_type"));			
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    
    
    @FXML
    void GenerateMirageCertificate(ActionEvent event) {
    	
    	String bfname = etbfname.getCharacters().toString();
    	
    	String bbirthplace = etbbirthplace.getCharacters().toString();
    	
    	LocalDate bdateofbirthh = bdateofbirth.getValue();
    	
    	String gfname = etgfname.getCharacters().toString();
    	
    	String gbirthplace = etgbirthplace.getCharacters().toString();
    	
    	LocalDate gdateofbirthh = gdateofbirth.getValue();
    	
    	LocalDate miragedate = dateofmirage.getValue();
    	
    	String mirageplace = etplaceofmirage.getCharacters().toString();
    	
    	RecordHelper recordHelper = new RecordHelper();
    	
    	recordHelper.generateMirageCertificate(bfname,bdateofbirthh, bbirthplace, gfname, gdateofbirthh, gbirthplace, miragedate, mirageplace);

    }
    
    @FXML
    void generatebirthcertificate(ActionEvent event) {
    	
    	
    	String cfname = etchname.getCharacters().toString();
    	
    	String fathername = etfaname.getCharacters().toString();
    	
    	String mothername = etmname.getCharacters().toString();
    	
    	String weight = etweight.getCharacters().toString();
    	
    	LocalDate dateofbirth = cdateofbirth.getValue();
    	
    ResultSet sd =	AccountHelper.birth(cfname, weight, dateofbirth, fathername, mothername);
    	
    	try {
    		
			while (sd.next()) {
				
			
				loadBirthid(sd.getString("LAST_INSERT_ID()"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    
public void loadBirthid(String id) {
		
		System.out.println("id generate for "+id);
		
		FXMLLoader fxmlLoader = new FXMLLoader();
    	
    	fxmlLoader.setLocation(getClass().getResource("birth.fxml"));
    	
    	try {
    		
			fxmlLoader.load();
			
			birthPreviewController generateIdPreviewController = fxmlLoader.getController();
	    	
	    	generateIdPreviewController.setid(id);
	    	
		       
			Parent root1 = fxmlLoader.getRoot();
			
			    Stage stage = new Stage();
			    
			    stage.setScene(new Scene(root1));  
			
			    stage.show();
			    
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	
		
	}	


public void loadMirageid(String id) {
	
	System.out.println("id generate for "+id);
	
	FXMLLoader fxmlLoader = new FXMLLoader();
	
	fxmlLoader.setLocation(getClass().getResource("mirage.fxml"));
	
	try {
		
		fxmlLoader.load();
		
		MiragePreviewController generateIdPreviewController = fxmlLoader.getController();
    	
    	generateIdPreviewController.setid(id);
    	
	       
		Parent root1 = fxmlLoader.getRoot();
		
		    Stage stage = new Stage();
		    
		    stage.setScene(new Scene(root1));  
		
		    stage.show();
		    
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	
}


		@FXML
		void GenerateDivorceCertificate(ActionEvent event) {
			
			String sdf = bfname.getCharacters().toString();
			
			String gname = gfname.getCharacters().toString();
			
			String divorceplace = placeofdivorce.getCharacters().toString();
			
			LocalDate dateofdivorcesd = dateofdivorce.getValue();
		
			RecordHelper recordHelper = new RecordHelper();
			
			System.out.println(sdf+gname);
	    	
	    	recordHelper.generateDivorceCertificate(sdf, dateofdivorcesd, divorceplace, gname);
	    	
	    	

			
		
		}

}
