package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp23 {

	public static void main(String[] args) {
	
		
		try (
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from emp");
			)
		{
			System.out.println("Employee Details in Forward Direction.");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDR"));
			}
			System.out.println("");
			System.out.println("Employee Details in Backward Direction.");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-----------------------");
			while(rs.previous()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDR"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
