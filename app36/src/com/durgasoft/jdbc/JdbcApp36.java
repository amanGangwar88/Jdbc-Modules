package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.durgasoft.factory.ConnectionFactory;
 

public class JdbcApp36 {

	public static void main(String[] args) {
		PreparedStatement pst=null;
		Scanner sc=null;
		ResultSet rs=null;
		try {
			Connection con=ConnectionFactory.getConnection();
		    sc=new Scanner(System.in);
			pst=con.prepareStatement("select * from emp where esal < ?");
			System.out.println("Salary Range :");
			float salrange=sc.nextFloat();
			pst.setFloat(1, salrange);
			rs= pst.executeQuery();
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			while(rs.next()) {
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDR"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();;
		}finally {
			try {
				pst.close();
				sc.close();
				rs.close();
				ConnectionFactory.cleanUp();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

}
