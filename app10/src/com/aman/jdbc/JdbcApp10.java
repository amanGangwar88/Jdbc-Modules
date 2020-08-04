package com.aman.jdbc;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp10 {

	public static void main(String[] args) {
	// ResultSet rs=null;
	 Connection con=null;
	 Statement st=null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");	
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		st=con.createStatement();
		boolean b=st.execute("update emp set esal = esal + 500 where esal<10000");
		System.out.println(b);
	 int rowcount=st.getUpdateCount();
		}
	catch (Exception e) {
		 e.printStackTrace();
	}finally {
		try {
			con.close();
			st.close();
			//rs.close();
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	}

}
