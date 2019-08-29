package databasetesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



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
		
		//intergration the database with selenium code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PriyaS\\eclipse-workspace\\databasetesting\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("name"));//sending the username through the database
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("id"));//sending the password through database
		
		//System.out.println(rs.getString("id"));
		//System.out.println(rs.getString("name"));
		//System.out.println(rs.getString("age"));
		
	}

}
//jdbc:mysql://"+localhost+":"+3306+"/demo";