package com.durgasoft.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 

public class JdbcApp41 {

	public static void main(String[] args) {
		 Connection con=null;
	 PreparedStatement pst=null;
	 ResultSet rs =null;
	 FileOutputStream fos=null;
	 InputStream is=null;
		try {
			 
		Class.forName("oracle.jdbc.OracleDriver");
	 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		 pst=con.prepareStatement("select * from emp1 where eno= ?");
		 
		 rs=pst.executeQuery();
		rs.next();
		int eno=rs.getInt(1);
		System.out.println("Employee Number :"+eno);
		fos=new FileOutputStream("C:/Adv7/"+eno+".jpg");
		is=rs.getBinaryStream(2);
		
		int val=is.read();
		while(val != -1) {
			fos.write(val);
			val=is.read();
		}
		System.out.println("Image Retrived Successfully");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		try {
			 
			is.close();
			fos.close();
			rs.close();
			pst.close();
			con.close();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	}

}
