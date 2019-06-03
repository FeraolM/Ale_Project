package application;
	
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
	
			Scene scene = new Scene(root,493,363);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Application Started");
		
		/*
		 * Test.testsdf();
		 * 
		 * Test.testsdf();
		 */
		
		Connection amsdsfConnection  = DatabaseHelper.getConnection();
		
	try {
		
		Statement aStatement = amsdsfConnection.createStatement();
		
		ResultSet aResultSet = DatabaseHelper.getAllAdminUsers();
		
		while (aResultSet.next()) {
			
		System.out.println(aResultSet.getString("username"));
			
		}
			
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		launch(args);
	
		
	}
}
