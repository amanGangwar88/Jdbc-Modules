package com.Aman.jdbc;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp20 {

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
			System.out.print("table Name :");
			String tname=br.readLine();
			
		    rs=st.executeQuery("select * from "+tname);
		    ResultSetMetaData md=rs.getMetaData();
		    int col_count=md.getColumnCount();
		    String data="";
		    int count1=1;
		    for(int i=1; i<=col_count; i++) {
		    	data=data+md.getColumnName(i);
		    	if(count1==col_count) {
		    		data=data +"\n";
		    	}else {
		    		data=data+",";
		    		count1=count1+1;
		    	}
		    }
		   
		    while(rs.next()) {  
		    	int count2=1;
		    	for(int i=1; i<=col_count; i++) {
		    		data = data + rs.getString(i);
		    		if(count2==col_count) {
		    			data=data+"\n";
		    		}else {
		    			data=data+",";
		    			count2=count2+1;
		    		}
		    	}
		    }
		    fos=new FileOutputStream("C:/Adv7/jdbc/app20/"+tname+".txt");
		    byte[] b=data.getBytes();
		    fos.write(b);
		    System.out.println("Data transfered succesfull .");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				st.close();
				rs.close();
				br.close();
				fos.close();
			} catch (Exception e2) {
			e2.printStackTrace();
			}
		}
	}

}
