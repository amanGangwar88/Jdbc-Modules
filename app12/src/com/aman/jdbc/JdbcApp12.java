package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp12 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Class.forName("oracle.jdbc.OrcaleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			st=con.createStatement();
			rs=st.executeQuery("update emp set esal=esal-1000 where esal=10000");
			int rowcount=st.getUpdateCount();
			System.out.println("RowCount :"+rowcount);
		}catch (Exception e) {
		 e.printStackTrace();
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
