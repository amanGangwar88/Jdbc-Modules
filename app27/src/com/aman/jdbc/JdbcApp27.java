package com.aman.jdbc;

 
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp27 {

	public static void main(String[] args) {
        Connection con =null;
        Statement st=null;
        ResultSet rs=null;
        BufferedReader br=null;
        
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select* from emp");
			while(rs.next()) {
				float esal=rs.getFloat("ESAL");
				if(esal<15000) {
					esal=esal-500;
					rs.updateFloat(3, esal);
					rs.updateRow();
					System.out.println("Employee "+rs.getInt("ENO")+" Update Successfully");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
				br.close();
			} catch (Exception e2) {
				
			}
		}
			
	}

}
