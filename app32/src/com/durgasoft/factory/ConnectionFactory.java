package com.durgasoft.factory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
static FileInputStream fis;
static Connection con;
static {
	try {
		 fis=new FileInputStream("C:/Adv7/jdbc/app32/src/db.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String driver_Class=prop.getProperty("driver_Class");
		String driver_URL=prop.getProperty("driver_URL");
		 
		Class.forName(driver_Class);
		con=DriverManager.getConnection(driver_URL, prop);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public static Connection getConnection() {
	return con;
}
public static void cleanup() {
	try {
		fis.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();;
	}
}
}
