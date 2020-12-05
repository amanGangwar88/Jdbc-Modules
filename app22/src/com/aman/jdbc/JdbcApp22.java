package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp22 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
		     st=con.createStatement();
		     rs=st.executeQuery("select * from emp");
		     
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
		}finally {
			try {
				st.close();
				con.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
