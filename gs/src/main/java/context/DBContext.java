package context;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBContext {
	public Connection getConnection() throws Exception {
		Class.forName ("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/Wish?useSSL=false";
        String user="root";
        String password="01122001";
        return (Connection) DriverManager.getConnection(url, user, password);
	} 
	public static void main(String[] args) 
	{
		try
	    {
	    	System.out.println(new DBContext().getConnection());
	    }
	    catch (Exception e)
	    {
	    }
	}
}
