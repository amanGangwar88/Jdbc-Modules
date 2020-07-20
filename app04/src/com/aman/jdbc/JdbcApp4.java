package com.aman.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp4 {

	public static void main(String[] args) {
	Connection con=null;
	Statement st=null;
	BufferedReader br=null;
		try {
			//Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		st=con.createStatement();
	    br =new BufferedReader(new InputStreamReader(System.in));
	    while(true) {
	    	System.out.println("Employee Number  :");
	    	int eno=Integer.parseInt(br.readLine());
	    	
	    	System.out.println("Employee Name  :");
	    	String ename=br.readLine();
	    	
	    	System.out.println("Employee salary  :");
	    	float esal=Float.parseFloat(br.readLine());
	    	
	    	System.out.println("Employee Address  :");
	    	String eaddr=br.readLine();
	    	
	    	int rowcount = st.executeUpdate("insert into emp values ("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')"); 
	    	if(rowcount==1) {
	       System.out.println("Employee inserted successfully");
	       System.out.println("One more record insert :[yes/no]");
	       String option=br.readLine();
	       if(option.equals("yes")) {
	    	   continue;
	       }else {
	    	   break;
	       }
	    }}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			br.close();
			st.close();
			con.close();
		} catch (Exception e2) {
		e2.printStackTrace();
		}
	}
	}

}
