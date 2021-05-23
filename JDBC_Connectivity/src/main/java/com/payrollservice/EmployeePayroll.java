package com.payrollservice;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeePayroll {
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Scanner s = new Scanner(System.in);
			
			System.out.println("Enter FirstName");
			Information info = new Information();
			info.setFirstName(s.next());
			
			System.out.println("Enter LastName");
			info.setLastName(s.next());
			
			System.out.println("Enter Experience");
			info.setExperience(s.next());
			
			System.out.println("Enter EmailId");
			info.setEmailId(s.next());
			
			EmployeeRepo repo = new EmployeeRepo();
			repo.insertRecord(info);
				
		}

}
