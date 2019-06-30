package application;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TextInputValidator {

	JFXTextField jfxTextField;

	public TextInputValidator(JFXTextField jfxTextField) {
		super();
		this.jfxTextField = jfxTextField;
		
		int a=+1;
		
	    System.out.println(String.valueOf(a)+" object created");
		
	  //  NumberValidator numberValidator = new NumberValidator();
		
	    NumberValidator numberValidator = new NumberValidator();
	    
		RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
		
		//jfxTextField.getValidators().add(requiredFieldValidator);
		
		jfxTextField.getValidators().add(requiredFieldValidator);
		
	//	jfxTextField.validate();
		

		if (jfxTextField.validate()) {
			
			jfxTextField.setStyle("-fx-text-fill:white;");	
			
			System.out.println("correct value added");
					
			
		}
		
		else {
			
			jfxTextField.setStyle("-fx-text-fill:red");
			
			System.out.println("incorrect value added");
		
			
			requiredFieldValidator.setMessage("Required");
			
		}
		
		jfxTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
				

				if (jfxTextField.validate()) {
					
					jfxTextField.setStyle("-fx-text-fill:white;");
				
					
					System.out.println("correct value added");
					
				
					
				}
				
				else {
					
					jfxTextField.setStyle("-fx-text-fill:red");
					
					System.out.println("incorrect value added");
					
					
					requiredFieldValidator.setMessage("Required");
					
				}
		

				
			}
			
			
		});
		
	}
	
	
	
	
}

 class numberValidator {
	
	 JFXTextField jfxTextField;

		public numberValidator(JFXTextField jfxTextField) {
			
			// TODO Auto-generated constructor stu
			super();
			this.jfxTextField = jfxTextField;
			
			int a=+1;
			
		    System.out.println(String.valueOf(a)+" object created");
			
		  //  NumberValidator numberValidator = new NumberValidator();
			
		    NumberValidator numberValidator = new NumberValidator();
		    
			RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
			
			//jfxTextField.getValidators().add(requiredFieldValidator);
			
			jfxTextField.getValidators().add(numberValidator);
			
		//	jfxTextField.validate();
			

			if (jfxTextField.validate()) {
				
				jfxTextField.setStyle("-fx-text-fill:white;");	
				
				System.out.println("correct value added");
						
				
			}
			
			else {
				
				jfxTextField.setStyle("-fx-text-fill:red");
				
				System.out.println("incorrect value added");
			
				
				numberValidator.setMessage("Number only");
				
			}
			
			jfxTextField.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					
					

					if (jfxTextField.validate()) {
						
						jfxTextField.setStyle("-fx-text-fill:white;");
					
						
						System.out.println("correct value added");
						
					
						
					}
					
					else {
						
						jfxTextField.setStyle("-fx-text-fill:red");
						
						System.out.println("incorrect value added");
						
						
						numberValidator.setMessage("Number Only");
						
					}
			

					
				}
				
				
			});
			
		}
	
	
}
