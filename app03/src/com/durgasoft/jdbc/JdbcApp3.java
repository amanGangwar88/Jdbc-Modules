package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp3 {
	public static void main(String[] args) {
	//Declaring the resource part
		Connection con=null;
	    Statement st=null;
	    BufferedReader br=null;
	   
	//Creating the resource
		try {
	    Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		st=con.createStatement();
		br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Table Name :");
		String table_Name=br.readLine();
		
		String primary_Key_Cols="";
		String query="create table "+table_Name+"(";
		int primary_Cols_Count=0;
		while(true) {
			System.out.print("Column Name :");
			String col_name=br.readLine();
			query=query + col_name+ "  ";
			
			System.out.print("Column Type :");
			String col_Type=br.readLine();
			query=query + col_Type;
			
			System.out.println("Is it primary key ?[Yes/No]  :");
			String primary_Key_Option=br.readLine();
			if(primary_Key_Option.equals("yes")) {
				if(primary_Cols_Count==0) {
		       primary_Key_Cols = primary_Key_Cols + col_name;	
				}else {
					primary_Key_Cols = primary_Key_Cols + "," + col_name;
				}
				primary_Cols_Count = primary_Cols_Count + 1;
				}
			System.out.print("One More Colmn ?[yes/no]");
			String col_Option=br.readLine();
			if(col_Option.equals("yes")) {
				query=query+",";
				continue;
			}else {
				query = query + ", primary key(" + primary_Key_Cols + "))";
				break;
			}
			
		}
		//System.out.println(query);
		st.executeUpdate(query);
		System.out.println("Table Create Successfully :");
	} catch (Exception e) {
		 e.printStackTrace();
	}finally {
		 try {
			br.close();
			st.close();
			con.close();
		} catch (Exception e) {
	e.printStackTrace();
		}
	}
	}
}
