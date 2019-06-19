package application;

import java.awt.Button;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXToggleButton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class AdminUsers {

	String id,username,type,active;
	
	JFXToggleButton update;

	public AdminUsers(String id, String username, String type, String active, JFXToggleButton update,String selectedvalue) {
		this.id = id;
		this.username = username;
		this.type = type;
		this.active = active;
		this.update = update;
	
		
	//	System.out.println(String.valueOf(Boolean.valueOf(inttoboolean(selectedvalue))) + selectedvalue);
	
		update.setSelected(inttoboolean(selectedvalue));
				
		update.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				
				 for (AdminUsers users:AdminController.table_data) {
					 
					 if (users.getUpdate() == update) {
						
						 System.out.println("changed value " +  String.valueOf(users.getId() + getUsername()));
						
						 JFXDialog dialog = new JFXDialog(AdminController.stkpane,new Label("skdhgkj"),JFXDialog.DialogTransition.CENTER);
						 dialog.setContent(new Label("Content"));
						dialog.show(AdminController.stkpane);
						
						
					}
					 
					 
				 }
					 
					 
				
				
			}
			
			
		});
		
	}

	

	public JFXToggleButton getUpdate() {
		
		return update;
	}



	public void setUpdate(JFXToggleButton update) {
		this.update = update;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	
	public boolean inttoboolean(String valueString) {
		
		if (valueString.equals("1")) {
			
			return true;
			
		}
		
		else {
			
			return false;
		}
		
		
		
	}
	
	

	
	
}
