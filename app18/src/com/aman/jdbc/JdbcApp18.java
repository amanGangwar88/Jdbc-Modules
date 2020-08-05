package com.aman.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
 
public class JdbcApp18 {
	public static void main(String[] args) {
	 Connection con=null;
	 Statement st=null;
	 BufferedReader br=null;
	 try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		st =con.createStatement();
		br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter SQL query without ; or :");  
		String query=br.readLine();
		
		boolean b=st.execute(query);
		if(b==true) {
			ResultSet rs=st.getResultSet();
			ResultSetMetaData md=rs.getMetaData();
			int col_count=md.getColumnCount();
			for(int i=1; i<=col_count; i++) {
			System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("-----------------------------------------");
			while(rs.next()) {
				for(int i=1; i<=col_count; i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		}else {
			int rowcount =st.getUpdateCount();
			System.out.println("Record Manupulated : "+rowcount);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			br.close();
			con.close();
			st.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	}

}
