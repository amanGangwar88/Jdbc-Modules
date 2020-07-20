 package com.aman.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp2{
	 public static void main(String [] args)throws Exception{
		 Class.forName("oracle.jdbc.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		 Statement st=con.createStatement();
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Table Name   :");
		 String table_Name=br.readLine();
		 String query="create table "+table_Name+"(ENO number(3) primary key,ENAME varchar2(10),ESAL float,EADDR varchar2(10))";
		 st.executeUpdate(query);
		 System.out.println("Table create successfully .");
		 st.close();
		 con.close();
		 
	 }
 }