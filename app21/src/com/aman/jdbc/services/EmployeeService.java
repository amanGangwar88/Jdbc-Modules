  package com.aman.jdbc.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeService {
	      BufferedReader br=null;
	      Connection con=null;
	      Statement st=null;
	      ResultSet rs=null;
        //Constructor
		 public EmployeeService(){
			try {
				 Class.forName("oracle.jdbc.OracleDriver");
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
				 st=con.createStatement();
				 br=new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e) { 
				e.printStackTrace();
			} 
		  }
		 //Methods
		 public void insert() {
			 try {
				System.out.println("Employee Number  :");
				int eno=Integer.parseInt(br.readLine());
				System.out.println("Employee Name  : ");
				String ename=br.readLine();
				System.out.println("Employee Salary :");
				float esal=Float.parseFloat(br.readLine());
				System.out.println("Employee Address  ;");
				String eaddr=br.readLine();
				
				rs=st.executeQuery("select * from emp where ENO = "+eno);
				boolean b=rs.next();  
				if(b==true) {
					System.out.println("Employee "+eno+"Existed already");
				}else {
					int rowcount=st.executeUpdate("insert into emp values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')"); 
				if(rowcount==1) {
					System.out.println("Employee "+eno+" Inserted Successfully.");
					
				}else {
					System.out.println("Employee "+eno+" Insertion Failure .");
				}
				}
			} catch (Exception e) {
				System.out.println("Employee Insertion Failure .");
				 System.out.println("Reason : "+e.getMessage());
			}
		 }  
		 public void search() {
			try {
				System.out.print("Enter Employee NUmber .");
				 
				int eno=Integer.parseInt(br.readLine());
				rs=st.executeQuery("select * from emp where ENO = "+eno);
				boolean b=rs.next();  
				if(b==true) {
					 System.out.println("Eemployee Details :");
					 System.out.println("-----------------------");
					 System.out.println("Employee Number  :"+rs.getInt("ENO"));
					 System.out.println("Employee Name  :"+rs.getString("ENAME"));
					 System.out.println("Employee Salary  :"+rs.getFloat("ESAL"));
					 System.out.println("Employee Address  :"+rs.getString("EADDRS"));
				}else {
					System.out.println("Employee "+eno+" Not Existed");
				}
			} catch (Exception e) {
				System.out.println("Empployee Search Failure");
				System.out.println("Reason :"+e.getMessage());
				
			}
		 }
		 public void update() {
			  try {
				  System.out.print("Enter Employee Number .");
					 
					int eno=Integer.parseInt(br.readLine());
					rs=st.executeQuery("select * from emp where ENO = "+eno);
					boolean b=rs.next();
       if(b==true) {
						System.out.println("Enter New Employee Details:");
						System.out.print("Employee Number :"+rs.getInt("ENO"));
						System.out.println("Employee Name : Old Value :"+rs.getString("ENAME")+", New Value :");
						String val1=br.readLine();
						String ename="";
						if(val1==null || val1.equals("")) {
							ename=rs.getString("ENAME");
						 }else {   
							ename=val1;
						    }
						System.out.println("Employee Salary : Old Value :"+rs.getFloat("ESAL")+", New Value :");
					    String val2=br.readLine();
						Float esal=0.0f;
						   if(val2==null || val2.equals("")) {
							esal=rs.getFloat("ESAL");
						    }else {
						  	esal=Float.parseFloat(val2);
						}
							System.out.println("Employee Address : Old Value :"+rs.getString("EADDRS")+", New Value :");
							String val3=br.readLine();
							String eaddrs="";
							if(val3==null || val3.equals("")) {
								eaddrs=rs.getString("EADDRS");
							 }else {   
								eaddrs=val3;
							    }
							int rowcount=st.executeUpdate("update emp set ENAME = '"+ename+"' , ESAL = "+esal+" , EADDRS = '"+eaddrs+"' where ENO = "+eno); 
			               if(rowcount==1) {
			            	   System.out.println("Employee "+eno+" Update Successfully.");
			               }else {
			            	   System.out.println("Employee "+eno+" Not Exixsted.");
			               }
       
       }else {
			 			System.out.println("Employee "+eno+" Not Existed .");
					   }
			} catch (Exception e) {
				System.out.println("Employee Update Failure.");
				System.out.println("Reason :"+e.getMessage());
			}
		 }
		 public void delete() {
			 try {
				System.out.print("Enter Employee Number :");
				int eno=Integer.parseInt(br.readLine());
				rs=st.executeQuery("select * from emp where ENO = " +eno);
				boolean b=rs.next();
				if(b==true) {
					int rowcount=st.executeUpdate("delete from emp where ENO = "+eno);
					if(rowcount==1) {
						System.out.println("Employee "+eno+" Deleted Successfully.");
					}else {
						System.out.println("Employee "+eno+" Not Deleted");
					}
				}else {
					System.out.println("Employee "+eno+" Not Existed.");
				}
			} catch (Exception e) {
				System.out.println("Employee Deletion Failure");
				System.out.println("Reason :"+e.getMessage());
			}
		 }
		 
}
