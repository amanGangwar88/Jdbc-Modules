package com.durgasoft.factory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
 static Connection con;
 static FileInputStream fis;
 
 static {
	 try {
		 fis=new FileInputStream("C:/Adv7/jdbc/app31/src/db.properties");
		 Properties prop=new Properties();
		 prop.load(fis);
		 String driver_Class=prop.getProperty("driver_Class");
		 String driver_URL=prop.getProperty("driver_URL");
		 
		 String db_User_Name=prop.getProperty("db_User_Name");
		 String db_Password=prop.getProperty("db_Password");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection(driver_URL, db_User_Name, db_Password);
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
 public static Connection getConnection() {
	 return con;
 }
 public static void cleanUp() {
 	try {
 		fis.close();
			con.close();
		} catch (Exception e) {
	        e.printStackTrace();
		}
 }
}
