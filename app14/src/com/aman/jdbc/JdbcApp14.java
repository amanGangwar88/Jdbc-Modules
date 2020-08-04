package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp14 {

	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		try {
			//Class.forName("oracle.jdbc.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		    st=con.createStatement();
		    int rowcount=st.executeUpdate("select * from emp");
				rs=st.getResultSet();
				System.out.println("ENO\tENAME\tESAL\tEADDR");
				System.out.println("-----------------------------------");
				while(rs.next()) {
					 System.out.print(rs.getInt(1)+"\t");
					 System.out.print(rs.getString(2)+"\t");
					 System.out.print(rs.getFloat(3)+"\t");
					 System.out.println(rs.getString(4));		
				}  
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						rs.close();
						st.close();
						con.close();
					} catch (Exception e) {
					 e.printStackTrace();
					}
				}
			}
		
	}
