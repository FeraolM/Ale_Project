package application;
import java.lang.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.stream.StreamSupport;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.sun.media.sound.EmergencySoundbank;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class General {
	
	public static final int snackbarError = 0;
	
	public static final int snackbarSuccess = 1;
	
	 static String currentDirectory = System.getProperty("user.dir");
	 
	 static String accountimagesdirectory = "\\account_images";
	 
	 static String residencedirectory = "\\residence_images";
	 
	 
	 	public static void createaccountimagedirectory() {
	 		
	 		 File firFile = new File(currentDirectory+ accountimagesdirectory);
			 
			 	if (firFile.exists()) {
			 		
			 		System.out.println("Directory " + accountimagesdirectory + " already exist");
				}
			 	
			 	else {
			 		
					firFile.mkdir();
				}
			
		}
	 	
	 	public static void createresidenceimageDirectory() {
	 		
	 		 File firFile = new File(currentDirectory+ residencedirectory);
			 
			 	if (firFile.exists()) {
			 		
			 		System.out.println("Directory " + residencedirectory + " already exist");
				}
			 	
			 	else {
			 		
					firFile.mkdir();
				}
			
		}
	 	
			 
		public static void savefile(File selectedfile,File usrphotopth, ImageView imageView,JFXSnackbar snackbar,JFXSnackbarLayout aSnackbarLayout) {
			 	
				createaccountimagedirectory();
				
				 File newphotoFile = new File (currentDirectory + accountimagesdirectory + "\\"+selectedfile.getName());
				 			 
				 String photofilename = selectedfile.getName();
				
				 String photofileextension = Fileutility.getFileExtension(selectedfile);
				 
				 String newphotofilename;
				 
				 File newphotofilewithpath = null;
				 
				try {
					
					newphotofilename = currentDirectory + accountimagesdirectory + "\\"+ General.hashfileasd(selectedfile) + photofileextension;
					
					newphotofilewithpath  = new File(newphotofilename);
					 
					if (newphotofilewithpath.exists()) {
						
						General.showSnackbar(snackbar, aSnackbarLayout, "Image Already Exists", General.snackbarError);
						
					}
					
					else {
						
						try {
							
							
							System.out.println(usrphotopth.toString() + "\n" + newphotoFile.getAbsolutePath().toString() + General.hashfileasd(selectedfile));
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
										
					 
						try {
																		
							Files.copy(usrphotopth.toPath(),newphotofilewithpath.toPath());
							
							aSnackbarLayout = new JFXSnackbarLayout("sfgdgdg");
							
							aSnackbarLayout.setStyle("-fx-background-color: #fff;"
													+ "-fx-background-radius: 15px;"
													+ " -fx-border-radius: 20px;"
													+ "-fx-pref-height : 10;"
													+ "-fx-padding:0;");
							
							aSnackbarLayout.setToast("User created successfully");
							
							
							
							 snackbar.fireEvent(new SnackbarEvent(aSnackbarLayout ));	
							
							
							
							
						} catch (IOException e) {
							
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
						
					}
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
							 
					
				
			
		}
		
		
		public static void savefileresidenceimage(String id,File selectedfile,File usrphotopth, ImageView imageView,JFXSnackbar snackbar,JFXSnackbarLayout aSnackbarLayout) {
		 	
			createresidenceimageDirectory();
			
			 File newphotoFile = new File (currentDirectory + residencedirectory + "\\"+selectedfile.getName());
			 			 
			 String photofilename = selectedfile.getName();
			
			 String photofileextension = Fileutility.getFileExtension(selectedfile);
			 
			 String newphotofilename;
			 
			 File newphotofilewithpath = null;
			try {
				
				newphotofilename = currentDirectory + residencedirectory + "\\"+ General.hashfileasd(selectedfile) + photofileextension;
				
				newphotofilewithpath  = new File(newphotofilename);
				 
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
						 
				try {
					
					
					System.out.println(usrphotopth.toString() + "\n" + newphotoFile.getAbsolutePath().toString() + General.hashfileasd(selectedfile));
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			 
				try {
																
					Files.copy(usrphotopth.toPath(),newphotofilewithpath.toPath());
					
					General general = new General();
					
					general.loadPreviewid(id);
					
					aSnackbarLayout = new JFXSnackbarLayout("sfgdgdg");
					
					aSnackbarLayout.setStyle("-fx-background-color: #fff;"
											+ "-fx-background-radius: 15px;"
											+ " -fx-border-radius: 20px;"
											+ "-fx-pref-height : 10;"
											+ "-fx-padding:0;");
					
					aSnackbarLayout.setToast("User created successfully");
					
					
					
					 snackbar.fireEvent(new SnackbarEvent(aSnackbarLayout ));	
					
					
					
					
				} catch (IOException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			
		
	}
		



/*UI*/
		
		
	public void loadPreviewid(String id) {
		
		System.out.println("id generate for "+id);
		
FXMLLoader fxmlLoader = new FXMLLoader();
    	
    	fxmlLoader.setLocation(getClass().getResource("previewid.fxml"));
    	
    	try {
    		
			fxmlLoader.load();
			
			GenerateIdPreviewController generateIdPreviewController = fxmlLoader.getController();
	    	
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
	
	
	
		
		
	public static void showSnackbar(JFXSnackbar snackbar,JFXSnackbarLayout aSnackbarLayout,String message,int type) {
		
			switch (type) {
			case 0:
				
				aSnackbarLayout = new JFXSnackbarLayout("sfgdgdg");
				
				aSnackbarLayout.setStyle("-fx-background-color: #f00;"
										+ "-fx-background-radius: 15px;"
										+ " -fx-border-radius: 20px;"
										+ "-fx-pref-height : 10;"
										+ "-fx-padding:0;");
				
				aSnackbarLayout.setToast(message);
				
				
				
				 snackbar.fireEvent(new SnackbarEvent(aSnackbarLayout ));	
				
				
				break;
			case 1:
				
				aSnackbarLayout = new JFXSnackbarLayout("sfgdgdg");
				
				aSnackbarLayout.setStyle("-fx-background-color: #fff;"
										+ "-fx-background-radius: 15px;"
										+ " -fx-border-radius: 20px;"
										+ "-fx-pref-height : 10;"
										+ "-fx-padding:0;");
				
				aSnackbarLayout.setToast(message);
				
				
				
				 snackbar.fireEvent(new SnackbarEvent(aSnackbarLayout ));	
				
				
				break;

			default:
				break;
			}
			
			
			
			
		
		
	}
	
	/* file */
	
	public static String makepathfordb(File locationstring) { //create path for the kebele administrator
	
				String accdirectory = "\\\\account_images\\\\";
			 	
			 	String photofileextension = Fileutility.getFileExtension(locationstring);
				 
				 String newphotofilename = null;
		
				 File newphotofilewithpath = null;
				try {
					
					newphotofilename = accdirectory + General.hashfileasd(locationstring) + photofileextension;
					
					System.out.println("general 207 " + newphotofilename);
					 
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			 	
			 	
		 	
			 System.out.println("New directory line 199" + newphotofilename);
		 	
			return newphotofilename;
	}
	
	public static String makepathfordbforresidence(File locationstring) { //create path for the residence
		
		String accdirectory = "\\\\residence_images\\\\";
	 	
	 	String photofileextension = Fileutility.getFileExtension(locationstring);
		 
		 String newphotofilename = null;

		 File newphotofilewithpath = null;
		try {
			
			newphotofilename = accdirectory + General.hashfileasd(locationstring) + photofileextension;
			
			System.out.println("general 207 " + newphotofilename);
			 
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	 	
	 	
 	
	 System.out.println("New directory line 199" + newphotofilename);
 	
	return newphotofilename;
}
	
	 public static String[] splitPath(String pathString) {
	      Path path = Paths.get(pathString);
	      return StreamSupport.stream(path.spliterator(), false).map(Path::toString)
	                          .toArray(String[]::new);
	  }
	 		    

		      
		        
		        
	 public static String hashfileasd (File selectedFile) throws IOException {
		 
		  MessageDigest md;
		  
		  String hex = null;
		try {
			
			md = MessageDigest.getInstance("SHA-256");
			
			   hex = checksum(selectedFile, md);
			   
		        
		        System.out.println("hex value "+hex);
		        
		        
		        
		        
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //SHA, MD2, MD5, SHA-256, SHA-384...
		
		return hex;
		
	        
	     
	 }
		        
		        
		    

		    public static String checksum(File filepath, MessageDigest md) throws IOException {

		        // file hashing with DigestInputStream
		        try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath.getAbsolutePath()), md)) {
		        	
		            while (dis.read() != -1) ; //empty loop to clear the data
		            
		            md = dis.getMessageDigest();
		        }

		        // bytes to hex
		        StringBuilder result = new StringBuilder();
		        for (byte b : md.digest()) {
		            result.append(String.format("%02x", b));
		        }
		        return result.toString();

		    }
		    
		    
		    
/******* Validity check *****/
	
	    	
		    
		    
		    public boolean isblank(String as[]) {
		    		    
		    		
		    	
		    	
		    	  //  return (strvalue == null) || (strvalue.trim().length() == 0 || strvalue.isEmpty());
		    	
		    	return true;
			}
		    
		    
static int ifield;	

static int ffield;


public static boolean is_inputs_valid(JFXTextField[] inputfieFields, JFXButton button) {

	    button.setVisible(false);
	    
	    NumberValidator numberValidator = new NumberValidator();
		
		RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
		
		
		
	    for (ifield = 0; ifield < inputfieFields.length-1; ifield++) {
	    	

			inputfieFields[ifield].getValidators().add(numberValidator);
			
			inputfieFields[ifield].getValidators().add(requiredFieldValidator);
		
			inputfieFields[ifield].validate();
			

			if (inputfieFields[ifield].validate()) {
				
				inputfieFields[ifield].setStyle("-fx-text-fill:white;");	
				
				System.out.println("correct value added");
				
				button.setVisible(true);
				
				
			}
			
			else {
				
				inputfieFields[ifield].setStyle("-fx-text-fill:red");
				
				System.out.println("incorrect value added");
				
				button.setVisible(false);
				
				requiredFieldValidator.setMessage("Required");
				
			}
			
			inputfieFields[ifield].textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					
					

					if (inputfieFields[ifield].validate()) {
						
						inputfieFields[ifield].setStyle("-fx-text-fill:white;");
					
						
						System.out.println("correct value added");
						
						button.setVisible(true);
						
						
					}
					
					else {
						
						inputfieFields[ifield].setStyle("-fx-text-fill:red");
						
						System.out.println("incorrect value added");
						
						button.setVisible(false);
						
						requiredFieldValidator.setMessage("Required");
						
					}
			

					
				}
				
				
			});
			
		}
		
		
		
	
	
		/*
		 * inputfieFields[1].getValidators().add(numberValidator);
		 * 
		 * inputfieFields[1].getValidators().add(requiredFieldValidator);
		 * 
		 * inputfieFields[1].validate();
		 * 
		 * 
		 * if (inputfieFields[1].validate()) {
		 * 
		 * inputfieFields[1].setStyle("-fx-text-fill:white;");
		 * 
		 * System.out.println("correct value added");
		 * 
		 * button.setVisible(true);
		 * 
		 * 
		 * }
		 * 
		 * else {
		 * 
		 * inputfieFields[1].setStyle("-fx-text-fill:red");
		 * 
		 * 
		 * button.setVisible(false);
		 * 
		 * requiredFieldValidator.setMessage("Required");
		 * 
		 * }
		 * 
		 * inputfieFields[1].textProperty().addListener(new ChangeListener<String>() {
		 * 
		 * @Override public void changed(ObservableValue<? extends String> observable,
		 * String oldValue, String newValue) { // TODO Auto-generated method stub
		 * 
		 * 
		 * 
		 * if (inputfieFields[1].validate()) {
		 * 
		 * inputfieFields[1].setStyle("-fx-text-fill:white;");
		 * 
		 * 
		 * System.out.println("correct value added");
		 * 
		 * button.setVisible(true);
		 * 
		 * requiredFieldValidator.setMessage("Required"); }
		 * 
		 * else {
		 * 
		 * inputfieFields[1].setStyle("-fx-text-fill:red");
		 * 
		 * System.out.println("incorrect value added");
		 * 
		 * button.setVisible(false);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * });
		 */
	
	
	
		
	
	
	return false;
	
}
		    

public static boolean is_textinputs_valid(JFXTextField[] inputfieFields, JFXButton button) {

    button.setVisible(false);
	
	RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
	
	
	
    for (ffield = 0; ffield < inputfieFields.length; ffield++) {

		inputfieFields[ffield].getValidators().add(requiredFieldValidator);
		

		if (inputfieFields[ffield].validate()) {
				
			System.out.println("correct value added ii");
			
			button.setVisible(true);
			

			
		}
		
		else {
		
			
			System.out.println("incorrect value added oo");
			
			button.setVisible(false);
			
			requiredFieldValidator.setMessage("Required");
			
		}
		
		inputfieFields[ffield].textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
				

				if (inputfieFields[ffield].validate()) {
					
					inputfieFields[ffield].setStyle("-fx-text-fill:white");
				
					System.out.println(String.valueOf(ffield)+" the value");
					
					System.out.println("correct value added " + inputfieFields[ifield].getStyle()+ inputfieFields[ffield].getId()
					);
					
					button.setVisible(true);
					
					requiredFieldValidator.setMessage("");
					
					
				}
				
				else {
					
					inputfieFields[ffield].setStyle("-fx-text-fill:red");
					
					System.out.println("incorrect value added");
					
					
					
					button.setVisible(false);
					
					requiredFieldValidator.setMessage("Required");
					
				}
		

				
			}
			
			
		});
		
	}
	
		


return false;

}
	    
	    
		    
		    
/* Alert jfualogue */
		    
		    
		    public static void showDialogue(StackPane stkpane,JFXDialogLayout dialogLayout) {
		    	
		    	
		    	System.out.println("dialogue called");
		    	

		
		   dialogLayout.getStyleClass().add("dglayout");
		  
		  
		  JFXButton button = new JFXButton("Ok");
		  
		  JFXButton jfoenixButton = new JFXButton("JFoenix Button"); JFXButton abutton
		  = new JFXButton("".toUpperCase());
		  
		  abutton.setStyle("-fx-background-color: rgb(255,0,0);" +
		  " -fx-font-size: 14px;" + "-jfx-button-type: RAISED;" +
		  "-fx-text-fill: WHITE;");
		  
		  button.getStyleClass().add("button-raised");
		  
		  
		  
		  JFXDialog dialog = new
		  JFXDialog(stkpane,dialogLayout,JFXDialog.DialogTransition.BOTTOM);
		  
		  button.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseevent)-> {
		  
		  
		  dialog.close();
		  
		  
		  });
		  
		  Text ghText = new Text("Residence Added Succesfully");
		  
		  ghText.setStyle("-fx-background-color: rgb(255,0,0);");
		  
		  dialogLayout.setBody(ghText);
		  
		  dialogLayout.setActions(button,abutton);
		  
		  button.setStyle("  .button-raised{\r\n" +
		  "		      -fx-padding: 0.7em 0.57em;\r\n" +
		  "		      -fx-font-size: 14px;\r\n" +
		  "		      -jfx-button-type: RAISED;\r\n" +
		  "		      -fx-background-color: rgb(77,102,204);\r\n" +
		  "		      -fx-pref-width: 70;\r\n" +
		  "		      -fx-text-fill: WHITE;\r\n" + "		  }" + "" +
		  ".button-raised:hover{\r\n" + "    -fx-background-color: #fff;\r\n" +
		  "    -fx-border-color: derive(-fx-color-1, -20%);\r\n" +
		  "    -fx-text-fill: white;\r\n" + "}");
		  
		  dialog.show();
		 
				 
				
			}
		    

		    public static BufferedImage toBufferedImage(Image img)
		    {
		        if (img instanceof BufferedImage)
		        {
		            return (BufferedImage) img;
		        }

		        // Create a buffered image with transparency
		        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		        // Draw the image on to the buffered image
		        Graphics2D bGr = bimage.createGraphics();
		        bGr.drawImage(img, 0, 0, null);
		        bGr.dispose();

		        // Return the buffered image
		        return bimage;
		    }
		    
		
}
	


