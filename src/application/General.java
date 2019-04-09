package application;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.StreamSupport;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import javafx.scene.image.ImageView;

public class General {
	
	public static final int snackbarError = 0;
	
	public static final int snackbarSuccess = 1;
	
	 static String currentDirectory = System.getProperty("user.dir");
	 
	 static String accountimagesdirectory = "\\account_images";
	 
	 
	 
	 	public static void createaccountimagedirectory() {
	 		
	 		 File firFile = new File(currentDirectory+ accountimagesdirectory);
			 
			 	if (firFile.exists()) {
			 		
			 		System.out.println("Directory " + accountimagesdirectory + " already exist");
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
	
	public static String makepathfordb(File locationstring) {
	
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

		
}
	


