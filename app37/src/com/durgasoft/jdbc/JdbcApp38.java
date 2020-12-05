package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.durgasoft.factory.ConnectionFactory;

public class JdbcApp38 {

	public static void main(String[] args) {
		 
		Statement st=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs = st.executeQuery("select * from customer");
			System.out.println("CID\tCNAME\tCADDR\tPRODUCT\tQUANTITY\tDOD");
			System.out.println("-----------------------------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getString("CID")+"\t");
				System.out.print(rs.getString("CNAME")+"\t");
				System.out.print(rs.getString("CADDR")+"\t");
				System.out.print(rs.getString("PRODUCT")+"\t");
				System.out.print(rs.getInt("QUANTITY")+"\t");
				System.out.println(rs.getDate("DATE_OF_DELIVERY"));
			}
			System.out.println();
			pst=con.prepareStatement("select * from customer");
			rs=pst.executeQuery();
			System.out.println("CID\tCNAME\tCADDR\tPRODUCT\tQUANTITY\tDOD");
			System.out.println("-----------------------------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getString("CID")+"\t");
				System.out.print(rs.getString("CNAME")+"\t");
				System.out.print(rs.getString("CADDR")+"\t");
				System.out.print(rs.getString("PRODUCT")+"\t");
				System.out.print(rs.getInt("QUANTITY")+"\t");
				System.out.println(rs.getDate("DATE_OF_DELIVERY"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				pst.close();
				ConnectionFactory.clenup();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
