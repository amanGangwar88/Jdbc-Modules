package com.durgasoft.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcApp51 {

	public static void main(String[] args) {
	 Connection con=null;
	 CallableStatement cst=null;
	 
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		cst=con.prepareCall("{? = call getAVGSal(?,?)}");
		cst.setInt(2, 111);
		cst.setInt(3, 222);
		cst.registerOutParameter(1, Types.FLOAT);
		cst.execute();
		System.out.println("AVG SAL:"+cst.getFloat(1));
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			cst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}

}
