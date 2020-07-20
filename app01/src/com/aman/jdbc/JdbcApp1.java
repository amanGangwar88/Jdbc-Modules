 package com.aman.jdbc;
 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//This code is not Working in my Laptop because of DSN name
public class JdbcApp1 {

	public static void main(String[] args)throws Exception {
	  //Load and Register the driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
      //Establish the connection between java application and database  
        Connection con=DriverManager.getConnection("jdbc:odbc:aman","system","1234");
     
      //Create statement object
        Statement st=con.createStatement();
        
      //Create Buffered reader and take table name as a dynamic input
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Table Name   :");
        String table_Name=br.readLine();
        
      //Write SQL query
        String query="create table "+table_Name+"(ENO number(3) primary key,ENAME varchar2(10),ESAL float,EADDR varchar2(10))";
       
      //Execute query
        st.executeUpdate(query);
        
        System.out.println("Table create successfully .");
      //close connection
        st.close();
        con.close();
        
	}

}
