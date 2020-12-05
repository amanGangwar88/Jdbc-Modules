package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class JdbcApp44 {

	public static void main(String[] args) {
		OracleDataSource ds=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		 try {
			ds=new OracleDataSource();
			
			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("system");
			ds.setPassword("1234");
			
			con=ds.getConnection();
			
			st=con.createStatement();
			rs=st.executeQuery("select * from emp");
			System.out.println("ENO\tENAME\tESAL\tEADDRS");
			System.out.println("---------------------------------");
			while(rs.next()){
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDRS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				 ds.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
