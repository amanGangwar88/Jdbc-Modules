package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
 
import com.durgasoft.factory.ConnectionFactory;

public class JdbcApp35 {

	public static void main(String[] args) {
		PreparedStatement pst=null;
		Scanner sc=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			sc=new Scanner(System.in);
			pst=con.prepareStatement("delete from emp where esal < ?");
			System.out.print("Salary Range :");
			float sal_range=sc.nextFloat();
			pst.setFloat(1, sal_range);
			int row_count=pst.executeUpdate();
			System.out.println("Records Deleted :"+row_count);
		} catch (Exception e) {
		 System.out.println(e.getMessage());
		}finally {
			try {
				sc.close();
				pst.close();
				ConnectionFactory.cleanUp();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
