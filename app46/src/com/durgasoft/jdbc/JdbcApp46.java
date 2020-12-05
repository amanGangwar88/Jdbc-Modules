package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.sql.PooledConnection;

import com.mysql.cj.jdbc.MysqlDataSource;

 

public class JdbcApp46 {

	public static void main(String[] args) {
	 MysqlDataSource ds=null;
	 Connection con=null;
	 ResultSet rs=null;
	 PooledConnection pc=null;
	 PreparedStatement pst=null;
		try {
		ds=new MysqlDataSource();
		
		ds.setURL("jdbc:mysql://localhost:3300/durgadb");
		ds.setUser("root");
		ds.setPassword("root");
		 
		con=ds .getConnection();
		pst=con.prepareStatement("select * from emp where esal<?");
		pst.setFloat(1,10000);
		rs=pst.executeQuery();
		ResultSetMetaData md=rs.getMetaData();
		int columncount=md.getColumnCount();
		for(int i=1; i<=columncount; i++) {
			System.out.print(md.getColumnName(i)+"\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		while(rs.next()) {
			for(int i=1; i<columncount; i++) {
				System.out.print(rs.getString(i)+"\t");
				
			}
			System.out.println();
		}
	} catch (Exception e) {
		 e.printStackTrace();
	}finally {
		try {
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e2) {
			 e2.printStackTrace();
		}
	}
	}

}
