package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp25 {

	public static void main(String[] args) {
	     Connection con=null; 
	     Statement st=null;
	     ResultSet rs=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
	    st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    rs=st.executeQuery("select * from emp");
	    
	    rs.beforeFirst();
	    rs.next();
	    System.out.println(rs.getInt(1));
	    
	    rs.afterLast();
	    rs.previous();
	    System.out.println(rs.getInt(1));
	    
	    rs.last();
	    System.out.println(rs.getInt(1));
	    
	    rs.first();
	    System.out.println(rs.getInt(1));
	} catch (Exception e) {
	    e.printStackTrace();
	}

	}

}
