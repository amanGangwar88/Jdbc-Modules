 package com.durgasoft.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Types;

public class JdbcApp50 {

	public static void main(String[] args) {
	    Connection con=null;
	    CallableStatement cst=null;
	    
	try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			cst=con.prepareCall("{call getSal(?,?)}");
			cst.setInt(1, 111);
			cst.registerOutParameter(2, Types.FLOAT);
			cst.execute();
			float esal=cst.getFloat(2);
			System.out.println("Salary :"+esal);
			
		} catch (Exception e) {
		 e.printStackTrace();
		}finally {
			try {
				cst.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
