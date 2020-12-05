package com.aman.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp26 {   

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		BufferedReader br=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3300/durgadb", "root", "root");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select * from emp");
			rs.moveToInsertRow();
			br=new BufferedReader(new InputStreamReader(System.in));
			
			while(true){
				System.out.print("Employee Number  :");
				int eno=Integer.parseInt(br.readLine());
				System.out.print("Employee Name  :");
				String ename=br.readLine();
				System.out.print("Employee Salary :");
				float esal=Float.parseFloat(br.readLine());
				System.out.print("Employee Address  :");
				String eaddr=br.readLine();
				
				rs.updateInt(1, eno);
				rs.updateString(2, ename);
				rs.updateFloat(3, esal);
				rs.updateString(4, eaddr);
				rs.insertRow();
				System.out.println("Employee "+eno+" Inserted Successfully .");
				
				System.out.println("One more Employee  [yes/no]");
				String option=br.readLine();
				
				if(option.equalsIgnoreCase("yes")) {
					continue;
				}else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
