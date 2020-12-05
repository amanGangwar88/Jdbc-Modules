package com.durgasoft.jdbc;
 
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcAPP40 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		FileInputStream fis=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
			pst=con.prepareStatement("insert into emp1 values(?,?)");
		    pst.setInt(1, 111);
		    
		    File file=new File("C:/Adv7/image.jpg");
		    fis =new FileInputStream(file);
		    
		    pst.setBinaryStream(2, fis, file.length());
		    pst.executeUpdate();
		    System.out.println("Employee Inserted Successfully with Image.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
