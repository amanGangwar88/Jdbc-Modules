package com.aman.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.aman.jdbc.services.EmployeeService;

public class JdbcApp21 {

	public static void main(String[] args) {
     BufferedReader br =null;
     try {
		br=new BufferedReader(new InputStreamReader(System.in));
		 //Create employee service object.
	    EmployeeService empService=new EmployeeService();
		while(true) {
			System.out.println("1.Insert Employee .");
		    System.out.println("2.Search Employee .");
		    System.out.println("3.Update Employee .");
		    System.out.println("4.Delete Employee .");
		    System.out.println("5.Exit .");
		    System.out.println("Your Option .");
		    System.out.println();
		    int option=Integer.parseInt(br.readLine());
		           
		    
		    
		    switch (option) {
			case 1:
				System.out.println("----Employee Insert Module----");
				empService.insert();
				System.out.println();
				break;
            case 2:
				System.out.println("----Employee Search Module----");
				empService.search();
				System.out.println();
				break;
            case 3:
				System.out.println("-----Employee Update Module-----");
				empService.update();
				System.out.println();
				break;
            case 4:
	            System.out.println("-----Employee Delete Module -------");
	            empService.delete();
	            System.out.println();
	            break;
            case 5:
	            System.out.println("**** Thanks for Using App ****");
	            break;


			default:
				System.out.println("Enter the number from 1,2,3,4 and 5.");
				break;
			}
		}
	} catch (Exception e) {
	    e.printStackTrace();
	}
     

	}

}
