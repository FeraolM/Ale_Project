package application;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.StreamSupport;

public class DatabaseHelper {
	
	static ResultSet resultSet;
	
	static Connection DatabaseHelperinstance;
	
		public static Connection getConnection () {
			
			if (DatabaseHelperinstance == null) {
				
				try {
					
					DatabaseHelperinstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/kb_system_db", "root", "");
			
					return DatabaseHelperinstance;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
					
				
				return DatabaseHelperinstance;
			
		
		}
	
		public static ResultSet getInstance () {
			
			try {
				
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kb_system_db", "root", "");
				
				Statement statement= connection.createStatement();
							
				resultSet = statement.executeQuery("SELECT * FROM users");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			return resultSet;
			
			
		}
			public static int Adduser (String username, String password, int type,String location) {
				
				int a = 0;
			
						
						try {
							
							
							
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kb_system_db", "root", "");
							
							Statement statement= connection.createStatement();	
							
							//System.out.println("INSERT INTO users (username, password, type, is_active) VALUES (\"" + username+ "\",\""+password +"\" ,\""+type + "\" "+ "\"0\");");
										
							a = statement.executeUpdate("INSERT INTO users (username, password, type, is_active,photo_location) VALUES (\"" + username+ "\",\""+password +"\" ,\""+type + "\" "+ ",\"1\",\"" + location +"\");");
							
							System.out.println(String.valueOf(a));
							
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
								
						return a;
						
						
					}
			
			
			public static ResultSet Login (String username) {
				
				ResultSet loginrs = null; 
				
				
				
				try {
					
				
					
					Connection connection = DatabaseHelper.getConnection();
					
					Statement statement= connection.createStatement();	
					
					//System.out.println("INSERT INTO users (username, password, type, is_active) VALUES (\"" + username+ "\",\""+password +"\" ,\""+type + "\" "+ "\"0\");");
					
					
					loginrs = statement.executeQuery("SELECT * FROM users WHERE username=\""+username+"\"");
					
			/*
			 * while (a.next()) {
			 * 
			 * System.out.println(a.getString("username") + a.getString("id"));
			 * 
			 * }
			 */
					
				//	System.out.println(String.valueOf(a));
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				return loginrs ;
				
				
			}


			 public static String[] splitPath(String pathString) {
			      Path path = Paths.get(pathString);
			      return StreamSupport.stream(path.spliterator(), false).map(Path::toString)
			                          .toArray(String[]::new);
			  }
			 
			 
			 public static ResultSet getAllAdminUsers () {
					
					ResultSet loginrs = null; 
					
					
					
					try {
						
					
						
						Connection connection = DatabaseHelper.getConnection();
						
						Statement statement= connection.createStatement();	
						
						//System.out.println("INSERT INTO users (username, password, type, is_active) VALUES (\"" + username+ "\",\""+password +"\" ,\""+type + "\" "+ "\"0\");");
						
						
						loginrs = statement.executeQuery("SELECT * FROM users");
						
				/*
				 * while (a.next()) {
				 * 
				 * System.out.println(a.getString("username") + a.getString("id"));
				 * 
				 * }
				 */
						
					//	System.out.println(String.valueOf(a));
						
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
					return loginrs ;
					
					
				}
		
}