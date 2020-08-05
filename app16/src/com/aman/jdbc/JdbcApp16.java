package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp16 {

	public static void main(String[] args) {
		 try(
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		    Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery("select * from emp");
           ) {
		       ResultSetMetaData md=rs.getMetaData();
		       int column_count=md.getColumnCount();
		       for(int i=1; i<=column_count; i++) {
		    	   System.out.println("Column name:"+md.getColumnName(i));
	                 System.out.println("Column Type :"+md.getColumnTypeName(i));
	                 System.out.println("Column Size :"+md.getColumnDisplaySize(i));
	                 System.out.println("--------------------------------------");
		       }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
