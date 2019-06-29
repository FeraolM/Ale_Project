package application;

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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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

}
