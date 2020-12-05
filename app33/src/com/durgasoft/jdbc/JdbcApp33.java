package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.durgasoft.factory.ConnectionFactory;
 

public class JdbcApp33 {

	public static void main(String[] args) {
		PreparedStatement pst=null;
		BufferedReader br=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			 pst=con.prepareStatement("insert into emp values (?,?,?,?)");
			br=new BufferedReader(new InputStreamReader(System.in));
			 while(true) {
            System.out.print("Emploee Number :");
            int eno=Integer.parseInt(br.readLine());
            System.out.print("Emploee Name :");
            String ename=br.readLine();
            System.out.print("Employee Salary :");
            float esal=Float.parseFloat(br.readLine());
            System.out.print("Employee Address:");
            String eaddr=br.readLine();
            
            pst.setInt(1, eno);
            pst.setString(2, ename);
            pst.setFloat(3, esal);
            pst.setString(4, eaddr);
			
            pst.executeUpdate();
            System.out.println("Employee Inserted Successfully");
            System.out.println("One More Employee ?[yes/no]");
            String option=br.readLine();
            if(option.equals("yes")) {
            	continue;
            }else { 
            	break;
            }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				br.close();
				ConnectionFactory.cleanUp();
			} catch (Exception e2) {
				e2.printStackTrace();;
			}
		}
	}

}
