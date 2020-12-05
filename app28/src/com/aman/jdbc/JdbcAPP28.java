package com.aman.jdbc;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcAPP28 {

	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		 BufferedReader br=null;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select * from emp");
			 while(rs.next()) {
				 int eno=rs.getInt("ENO");
				 float esal=rs.getFloat("ESAL");
				 if(esal>9000) {
					 rs.deleteRow();
			         System.out.println("Employee "+eno+" Is Deleted Successfully.");
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
				 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
