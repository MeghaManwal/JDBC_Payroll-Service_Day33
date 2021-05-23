package com.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
	
	public void insertRecord(Information info) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
		//Step1: Load & Register Driver Class
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		
		//Step2: Establish a MySql Connection
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll__service", "root", "Varsha@!4455");
		
		//Step3: Create Statement
		 statement = connection.createStatement();
		
		//Step4: Execute Query
		String query = "insert into payroll(Name,department,gender, basicpay) value('"+info.getName()+"','"+info.getDepartment()+"','"+info.getGender()+"','"+info.getBasicPay()+"')";
		int result = statement.executeUpdate(query);
		System.out.print(result);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
			statement.close();
			}
			if(statement != null) {
			connection.close();
			}
		}
		
	}

	public List<Information> findAll(String Name) throws SQLException {
		List<Information> infos=new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement prepstatement = null;
		try {
		//Step1: Load & Register Driver Class
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		
		//Step2: Establish a MySql Connection
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll__service", "root", "Varsha@!4455");
		
		//Step3: Create Statement
		 String query =" select * from payroll where Name=?";
		 prepstatement = connection.prepareStatement(query);
		 prepstatement.setString(1, Name);
		 
		//Step4: Execute Query
		ResultSet resultset = prepstatement.executeQuery();
	
		while(resultset.next()) {
			Information information = new Information();
			
			int id=resultset.getInt(1);
			information.setId(id);
			
			String name = resultset.getString(2);
			information.setName(name);
			
			String dept = resultset.getString(5);
			information.setDepartment(dept);
			
			String gender = resultset.getString(6);
			information.setGender(gender);
			
			int pay = resultset.getInt(7);
			information.setBasicPay(pay);
			
			infos.add(information);
		}
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
		return infos;
	}

	public void updatedata(int id, int basicPay) throws SQLException {
		Connection connection = null;
		PreparedStatement prepstate = null;
		try {
		//Step1: Load & Register Driver Class
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		
		//Step2: Establish a MySql Connection
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll__service", "root", "Varsha@!4455");
		
		//Step3: Create Statement
		 String query ="Update payroll set basicPay=? where Id=?";
		 prepstate = connection.prepareStatement(query);
		 prepstate.setFloat(1, basicPay);
		 prepstate.setInt(2, id);
		
		//Step4: Execute Query
		 prepstate.executeUpdate();
		 System.out.print("Records Updated!");
		
		 }catch (SQLException e) {
			e.printStackTrace();
		 }catch (Exception e) {
			e.printStackTrace();
		 }finally {
			if(connection != null) {
			   connection.close();
			}
			if(prepstate != null) {
			   prepstate.close();
			}
		}
		
	}

	public List<Information> findAllForParticularDate() throws SQLException {
	
		List<Information> infos=new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepstatement = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll__service", "root", "Varsha@!4455");
			
			String query ="Select * from payroll where Start between Cast('2020-03-10' as date) and date(now()); ";
			prepstatement = connection.prepareStatement(query);
			
			ResultSet resultset = prepstatement.executeQuery();
			
			while(resultset.next()) {
				Information information = new Information();
				
				int id=resultset.getInt(1);
				information.setId(id);
				
				String name = resultset.getString(2);
				information.setName(name);
				
				String dept = resultset.getString(5);
				information.setDepartment(dept);
				
				String gender = resultset.getString(6);
				information.setGender(gender);
				
				int pay = resultset.getInt(7);
				information.setBasicPay(pay);
				
				infos.add(information);
			}
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
			return infos;
		
	}

	

}
