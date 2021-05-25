package com.payroll_details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeePayrollRepo {

	public void addEmployeeDetail(String Name, String department, String gender, int basicPay) throws SQLException {
		Connection connection = null;
		PreparedStatement prepstatement = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll__service", "root", "");
			
			
			String query = "insert into payroll(Name,department,gender, basicpay) value(?,?,?,?)";
			prepstatement = connection.prepareStatement(query);
			prepstatement.setString(1, Name);
			prepstatement.setString(2, department);
			prepstatement.setString(3, gender);
			prepstatement.setInt(4, basicPay);
			
			prepstatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		 }catch (Exception e) {
			e.printStackTrace();
		 }finally {
		 	if(connection != null) {
		 		connection.close();
			}
			if(prepstatement != null) {
				prepstatement.close();
			}
		 }
	}

	public void addSalaryDetail(int Deduction , int IncomeTax, int TaxablePay , int NetSalary  ) throws SQLException {
		Connection connection = null;
		PreparedStatement prepstatement = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll__service", "root", "");
			
			
			String query = "insert into payroll_details(Deduction,IncomeTax,TaxablePay, NetSalary) value(?,?,?,?)";
			prepstatement = connection.prepareStatement(query);
			prepstatement.setInt(1, Deduction);
			prepstatement.setInt(2, IncomeTax);
			prepstatement.setInt(3, TaxablePay);
			prepstatement.setInt(4, NetSalary);
			
			prepstatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		 }catch (Exception e) {
			e.printStackTrace();
		 }finally {
		 	if(connection != null) {
		 		connection.close();
			}
			if(prepstatement != null) {
				prepstatement.close();
			}
		 }
		
	}

}
