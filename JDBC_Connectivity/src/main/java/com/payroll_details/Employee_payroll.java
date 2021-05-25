package com.payroll_details;

import java.sql.SQLException;
import java.util.Scanner;

public class Employee_payroll {
	
 public static void main(String[] args) throws ClassNotFoundException, SQLException  {
	 Scanner s = new Scanner(System.in);
	 EmployeePayrollRepo repo = new EmployeePayrollRepo();
	 
	 System.out.println("Enter 1 for Adding Data\n Enter 2 for Deleting Data\n");
	 int option = s.nextInt();
	 if(option == 1) {
	 repo.addEmployeeDetail("Mark","HR","M",50000);
	 repo.addSalaryDetail(10000,40000,4000,36000);
	 repo.addEmployeeDetail("Bill","Marketing","M",60000);
	 repo.addSalaryDetail(12000,48000,6000,42000);
	 }else {
	 repo.cascadingdelete();
	 }
 }

}
