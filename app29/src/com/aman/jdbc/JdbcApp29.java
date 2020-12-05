package com.aman.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcApp29 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null ;
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream("C:/Adv7/jdbc/app29/src/db.properties");
			Properties prop=new Properties();
			prop.load(fis);
			
			String driver_Class=prop.getProperty("driver_Class");
			String driver_URL=prop.getProperty("driver_URL");
			String db_User_Name=prop.getProperty("db_User_Name");
			String db_Password=prop.getProperty("db_Password");
			
			Class.forName(driver_Class);
			con=DriverManager.getConnection(driver_URL, db_User_Name, db_Password);
			st=con.createStatement();
			rs=st.executeQuery("select * from emp");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");
				System.out.println(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
