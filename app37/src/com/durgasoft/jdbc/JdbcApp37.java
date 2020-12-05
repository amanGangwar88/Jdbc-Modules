package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
 

import com.durgasoft.factory.ConnectionFactory;
 

public class JdbcApp37 {

	public static void main(String[] args) {
		PreparedStatement pst=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			pst=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			pst.setString(1, "C-111");
			pst.setString(2, "AAA");
			pst.setString(3, "Hyd");
			pst.setString(4, "java");
			pst.setInt(5, 1);
			
			java.util.Date date=new java.util.Date();
			long time=date.getTime();
			java.sql.Date date1=new java.sql.Date(time);
			pst.setDate(6, date1);
			
			pst.executeUpdate();
			System.out.println("Customer C-111 Inseretd Successfully .");
			
			pst.setString(1, "C-222");
			pst.setString(2, "BBB");
			pst.setString(3, "Hyd");
			pst.setString(4, ".NET");
			pst.setInt(5, 1);
			
			java.sql.Date date2=java.sql.Date.valueOf("2020-07-02");
			pst.setDate(6, date2);
			pst.executeUpdate();
			System.out.println("Customer C-222 Inserted Successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				ConnectionFactory.clenup();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
