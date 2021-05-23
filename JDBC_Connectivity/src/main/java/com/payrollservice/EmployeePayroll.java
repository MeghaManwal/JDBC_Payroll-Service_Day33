package com.payrollservice;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {
		
	    static final Scanner s = new Scanner(System.in);
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			System.out.println("Press 1 to Add Data\n Press 2 to Reterive data");
			int choice = s.nextInt();
			
			switch(choice) {
			case 1:
				  AddData();
				  break;
			case 2:
				  ReteriveData();
				  break;	
			}
					
		}

		private static void ReteriveData() throws SQLException {
			EmployeeRepo repo = new EmployeeRepo();
			List<Information> infos = repo.findAll();
			infos.forEach(System.out::println);
		}

		private static void AddData() throws ClassNotFoundException, SQLException {
			System.out.println("Enter Name");
			Information info = new Information();
			info.setName(s.next());
			
			System.out.println("Enter Department");
			info.setDepartment(s.next());
			
			System.out.println("Enter Gender");
			info.setGender(s.next());
			
			System.out.println("Enter BasicPay");
			info.setBasicPay(s.nextDouble());
			
			EmployeeRepo repo = new EmployeeRepo();
			repo.insertRecord(info);
			
		}

}
