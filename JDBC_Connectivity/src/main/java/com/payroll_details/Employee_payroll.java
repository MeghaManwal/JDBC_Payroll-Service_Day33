package com.payroll_details;

import java.sql.SQLException;

public class Employee_payroll {
	
 public static void main(String[] args) throws ClassNotFoundException, SQLException  {
	 
	 EmployeePayrollRepo repo = new EmployeePayrollRepo();
	 
	 repo.addEmployeeDetail("Mark","HR","M",50000);
	 repo.addSalaryDetail(10000,40000,4000,36000);
	 repo.addEmployeeDetail("Bill","Marketing","M",60000);
	 repo.addSalaryDetail(12000,48000,6000,42000);
 }

}
