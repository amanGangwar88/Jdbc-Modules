package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import com.durgasoft.factory.ConnectionFactory;

public class JdbcApp32 {

	public static void main(String[] args) {
		 try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			st.addBatch("insert into emp values(666, 'FFF', 5000, 'Hyd')");
			st.addBatch("update emp set esal =esal+500 where esal<10000");
			st.addBatch("delete from emp where eno=555");
			
			
			int [] rowcount=st.executeBatch();
			for(int i=0; i<rowcount.length; i++) {
				System.out.println("Record Manipulated "+rowcount[i]);
			}
		} catch (Exception e) {
		   e.printStackTrace();
		}finally{
			ConnectionFactory.cleanup();
		}
	}

}
