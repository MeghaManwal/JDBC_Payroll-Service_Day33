package com.payrollservice;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {
		
	    static final Scanner s = new Scanner(System.in);
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			System.out.println(" Press 1 to Add Data\n Press 2 to Reterive data\n Press 3 to Update data\n");
			int choice = s.nextInt();
			
			switch(choice) {
			case 1:
				  AddData();
				  break;
			case 2:
				  ReteriveData();
				  break;
			case 3:
				  UpdateData();
				  break;
			}		
		}

		private static void UpdateData() throws SQLException {
		
			System.out.println("Enter Id");
		    int id = s.nextInt();
			
			System.out.println("Enter BasicPay");
		    int basicPay = s.nextInt();
			
			EmployeeRepo repo = new EmployeeRepo();
			repo.updatedata(id, basicPay);
				
		}

		private static void ReteriveData() throws SQLException {
			EmployeeRepo repo = new EmployeeRepo();
			System.out.println("Enter Name");
			String Name = s.next();
			List<Information> infos = repo.findAll(Name);
			infos.forEach(System.out::println);
		}

		private static void AddData() throws ClassNotFoundException, SQLException {
			Information info = new Information();
			
			System.out.println("Enter Name");
			info.setName(s.next());
			
			System.out.println("Enter Department");
			info.setDepartment(s.next());
			
			System.out.println("Enter Gender");
			info.setGender(s.next());
			
			System.out.println("Enter BasicPay");
			info.setBasicPay(s.nextInt());
			
			EmployeeRepo repo = new EmployeeRepo();
			repo.insertRecord(info);
			
		}

}
