package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.durgasoft.factory.ConnectionFactory;

public class JdbcApp34 {

	public static void main(String[] args) {
	 PreparedStatement pst=null;
	 Scanner sc=null;
		try {
			 
		sc=new Scanner(System.in);
		Connection con=ConnectionFactory.getConnection();
	
		pst = con.prepareStatement("update emp set esal = esal + ? where esal < ?");
		 
		System.out.print("Bonus Amount  :");
		int bonus_amt=sc.nextInt();
		System.out.print("Salary Range :");
		float sal_range=sc.nextFloat();
		
		pst.setInt(1, bonus_amt);
		pst.setFloat(2, sal_range);
		int row_count=pst.executeUpdate();
		System.out.println("Record Updated :"+row_count);
	} catch (Exception e) {
		 e.printStackTrace(); 
	}finally {
		try {
			pst.close();
			sc.close();
			ConnectionFactory.cleanUp();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	}

}
