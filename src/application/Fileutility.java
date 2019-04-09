package application;

import java.io.File;

public class Fileutility {
	 
	/*
	 * 
	 * public static void main(String[] args) { String extension =
	 * getFileExtension(new File("C:\\article\\mongodb-json.zip"));
	 * System.out.println("File Extension :- " + extension); extension =
	 * getFileExtension(new File("C:\\article\\eclipse.png"));
	 * System.out.println("File Extension :- " + extension); }
	 */
	 
	    public static String getFileExtension(File file) {
	        String extension = "";
	 
	        try {
	            if (file != null && file.exists()) {
	                String name = file.getName();
	                
	                System.out.println(name);
	                extension = name.substring(name.lastIndexOf("."));
	            }
	        } catch (Exception e) {
	            extension = "";
	        }
	 
	        return extension;
	 
	    }
	 
	
}



