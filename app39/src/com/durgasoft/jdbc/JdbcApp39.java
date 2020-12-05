package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.durgasoft.Factory.ConnectionFactory;

public class JdbcApp39 {

	public static void main(String[] args) {
	    PreparedStatement pst=null;
		 try {
			Connection con=ConnectionFactory.getConnection();
			pst=con.prepareStatement("insert into emp values (?,?,?,?)");
			
			pst.setInt(1, 777);
			pst.setString(2, "FFF");
			pst.setFloat(3, 11000);
			pst.setString(4, "Hyd");
			pst.addBatch();

			pst.setInt(1, 888);
			pst.setString(2, "GGG");
			pst.setFloat(3, 12000);
			pst.setString(4, "Hyd");
			pst.addBatch();
			
			int[] rowcounts=pst.executeBatch();
			for(int  rowcount: rowcounts ) {
				System.out.println("Row Count :"+rowcounts);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				ConnectionFactory.cleanUp();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
