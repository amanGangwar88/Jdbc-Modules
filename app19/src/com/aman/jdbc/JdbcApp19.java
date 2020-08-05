package com.aman.jdbc;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp19 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		BufferedReader br=null;
		FileOutputStream fos=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			st=con.createStatement();
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Table Name :");
			String tname=br.readLine();
			
			rs=st.executeQuery("select * from "+tname);
			ResultSetMetaData md=rs.getMetaData();
			int col_count=md.getColumnCount();
			String data="<html><body><center><br><br><table bgcolor='lightblue' border='1'>";
			data = data + "<tr>";
			for(int i = 1; i<= col_count; i++)
			{
				data = data + "<th><font color='red' size='5'>";
				data = data +md.getColumnName(i);
				data = data + "</font></th>";
			}
			data = data + "</tr>"; 
			
			while(rs.next()) {
				data = data + "<tr>";
				
				for(int i=1; i<=col_count; i++) {
					data = data + "<td>";
					data = data +rs.getString(i);
					data = data + "</td>";
				}
				
				data = data + "</tr>";
			}
			data = data + "</table></center></body></html>";
			
			fos =new FileOutputStream("C:/Adv7/jdbc/app19/"+tname+".html");
			byte[] b=data.getBytes();
			fos.write(b);
			System.out.println("Data Transfered to C:/Adv7/jdbc/app19");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fos.close();
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
			e2.printStackTrace();
			}
		}
 	}

}


 