package core.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcApp5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
       Scanner scanner=null;
		try {
			OracleDriver oracleDriver=new OracleDriver();
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			st=con.createStatement();
			
			scanner = new Scanner(System.in);
			System.out.print("Bonus Ammount :");
		    int bonus_amt=scanner.nextInt();
			System.out.println("Salary Range :");
			float sal_range=scanner.nextFloat();
			int row_count= st.executeUpdate("update emp set esal = esal+"+bonus_amt+"where esal < "+sal_range);
			
			System.out.println("No of records are updated :" +row_count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {  
				
				st.close();
				con.close();
				scanner.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
