import java.sql.*;

import javax.swing.JOptionPane;
public class SqliteConnection2 {
	public static Connection ConnectDb()
	 {
		  try {
			  Class.forName("org.sqlite.JDBC");
			  Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shubhra Jha\\eclipse-workspace\\DAAPROJECT 006\\StudentRecords.db");
			  	 JOptionPane.showMessageDialog(null, "Database Connected");
			     Class.forName("org.sqlite.JDBC");
		          
			  	return conn;		 
		  }
		  catch(Exception e)
		  {
			  JOptionPane.showMessageDialog(null, e);
			  return null;
		  }
	 }
}
