package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.durgasoft.factory.ConnectionFactory;

public class JdbcApp31 {

	public static void main(String[] args) {
	 try {
		Connection con=ConnectionFactory.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("----------------------------");
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getFloat(3)+"\t");
			System.out.println(rs.getString(4));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		ConnectionFactory.cleanUp();
	}
	}

}
