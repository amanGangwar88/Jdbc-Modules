package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class JdbcApp45 {

	public static void main(String[] args) {
	 OracleConnectionPoolDataSource ds=null;
	 Connection con=null;
	 ResultSet rs=null;
	 PooledConnection pc=null;
	 Statement st=null;
		try {
		ds=new OracleConnectionPoolDataSource();
		
		ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("system");
		ds.setPassword("1234");
		
		pc=ds.getPooledConnection();
		con=pc.getConnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from emp");
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
			st.close();
			con.close();
			pc.close();
			ds.close();
		} catch (Exception e2) {
			 e2.printStackTrace();
		}
	}
	}

}
