package context;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBContext {
	public Connection getConnection() throws Exception {
		Class.forName ("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://remotemysql.com:3306/bFz28nfVdy";
        String user="bFz28nfVdy";
        String password="jQS9hXjuH7";
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
