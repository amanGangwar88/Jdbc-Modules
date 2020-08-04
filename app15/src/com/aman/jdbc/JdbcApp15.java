package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JdbcApp15 {

	public static void main(String[] args) {
		 try(
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		    ) {
                 DatabaseMetaData dbmd=con.getMetaData();
                 System.out.println("Database Product Name  :"+dbmd.getDatabaseProductName());
                 System.out.println("Database Product Version :"+dbmd.getDatabaseProductVersion());
                 System.out.println("Database Driver Minor Version :"+dbmd.getDatabaseMinorVersion());
                 System.out.println("Database Driver Major Version :"+dbmd.getDatabaseMajorVersion());
                 System.out.println("Database Keyword :"+dbmd.getSQLKeywords());
                 System.out.println("Database String Functions :"+dbmd.getStringFunctions());
                 System.out.println("Database Numeric Function :"+dbmd.getNumericFunctions());
                 System.out.println("Databade have Batch update or not :"+dbmd.supportsBatchUpdates());
                 System.out.println("Databse support stored Strrred prroducedure or not :"+dbmd.supportsStoredProcedures());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
