package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcApp9 {

	public static void main(String[] args) {
	 ResultSet rs=null;
	 Connection con=null;
	 Statement st=null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");	
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		st=con.createStatement();
		boolean b=st.execute("select * from emp");
		System.out.println(b);
		rs=st.getResultSet();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------");
		while(rs.next()) {
			System.out.print(rs.getInt("ENO")+"\t"+rs.getString("ENAME")+"\t"+rs.getFloat("ESAL")+"\t");
			System.out.println(rs.getString("EADDR"));
		}
	} catch (Exception e) {
		 e.printStackTrace();
	}finally {
		try {
			con.close();
			st.close();
			rs.close();
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	}

}
