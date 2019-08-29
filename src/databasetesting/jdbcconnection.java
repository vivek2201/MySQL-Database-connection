package databasetesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbcconnection {
	public static void main(String [] args) throws SQLException
	{
		//String host="localhost";
		//String port="3306";
		String connectionURL="jdbc:mysql://localhost:3306/qadb?autoReconnect=true&useSSL=false";// autoReconnect=true is using because mySQL connect is abort automatically
		
		Connection con=DriverManager.getConnection(connectionURL, "root", "revolutionit.com.au");
		
		Statement s=con.createStatement();
		//ResultSet rs=s.executeQuery("select id from employeeinfo where name='Sheetal';");
		ResultSet rs=s.executeQuery("select * from employeeinfo;");
		rs.next();
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("age"));
		
	}

}
//jdbc:mysql://"+localhost+":"+3306+"/demo";