package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp6 {

	public static void main(String[] args) {
		  try(
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
				Statement st=con.createStatement();
		        Scanner scanner=new Scanner(System.in); 
        ) {
			  System.out.println("Salary range :");
			  float sal_range=scanner.nextFloat();
			  
			int rowcount=st.executeUpdate("delete from emp where esal < "+sal_range);
			System.out.println("Records deleted :"+rowcount);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
 