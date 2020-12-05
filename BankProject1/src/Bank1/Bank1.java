package Bank1;

import java.util.Scanner;

public class Bank1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		 int userInput;
		 int size=0;
		 double[] accountBalances=new double[250];
		 String[] accountName=new String[250];
		 for(;true;) {
	 System.out.println("Bank Admin Menu :");
	 System.out.println("Please Enter a Menu Option :");
	 System.out.println("(1):Add Coustomer to the Bank.");
	 System.out.println("(2):Change Coustomer Name.");
	 System.out.println("(3):Check Account Balance.");
	 System.out.println("(4):Modify Account Balance.");
	 System.out.println("(5):Summary of all Accounts.");
	 System.out.println("(6):Quit.");
	 
	 

	 userInput=input.nextInt();
	 if(userInput==1) {
		 System.out.println("Bank Add Coustomer Menu.");
		 
		 System.out.println("Please Enter the Account Balance.");
		 double balance=input.nextDouble();
		 accountBalances[size]=balance;
		 
		 System.out.println("Please Enter Account Name.");
		 input.nextLine();//Use for clean the Buffer.
		 String name=input.nextLine();
		 accountName[size]=name;
		 
		 System.out.println("Coustomer Id is: "+size);
		 size = size + 1;
		 
	 }else if(userInput==2) {
		 System.out.println("Bank Change Name Menu.");
		 System.out.println("Please Coustomer Id To Change Their Name.");
		 int index =input.nextInt();
		 System.out.println("What is the Costomer's New Name.");
		 input.nextLine();
		 accountName[index]=input.nextLine();
	 }else if(userInput==3) {
		 System.out.println("Bank Check Balance Menu.");
		 System.out.println("Please Coustomer Id o check the Balance");
		 int index=input.nextInt();
		 double balance=accountBalances[index];
		 System.out.println("This coustomer has $"+balance+"in their Account");
	 }else if(userInput==4) {
		 System.out.println("Bank Modify Balance Menu.");
		 System.out.println("Please Coustomer Id o check the Balance");
		 int index=input.nextInt();
		 System.out.println("Please input Your new balance;");
		 accountBalances [index]=input.nextDouble(); 
	 }else if(userInput==5) {
		 System.out.println("Bank all coustomer summary menu:");
		 double total=0;
		 for(int i=0; i<size; i++) {
			 total = total + accountBalances[i];
			 System.out.println(accountName[i] + "has $" +accountBalances[i] + "in their account :");
		 }
		 System.out.println("In Total, their is $ " +total+ "in the Bank.");
	 }else if(userInput==-1) {
		 System.out.println(userInput);
		 System.exit(-1);
	 }else {
		 System.out.println("Error: valid Input.");
	 }

	}
	}
}
