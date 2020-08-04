package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp8 {

	public static void main(String[] args) {
		 try (
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp");
				 
			){
			 System.out.println("ENO\tENAME\tESAL\tEADDR");
			 System.out.println("--------------------------");
			 while(rs.next()) {
				 System.out.print(rs.getInt(1)+"\t");
				 System.out.print(rs.getString(2)+"\t");
				 System.out.print(rs.getFloat(3)+"\t");
				 System.out.println(rs.getString(4));		 
			 }
			
		} catch (Exception e) {
		 e.printStackTrace();
		}
	}

}
