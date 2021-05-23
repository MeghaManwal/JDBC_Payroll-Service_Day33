package com.payrollservice;

public class Information {
    
	public int Id;
	public String Name;
	public String department;
	public String gender;
	public double basicPay;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Information [Id=" + Id + ", Name=" + Name + ", department=" + department + ", gender=" + gender
				+ ", basicPay=" + basicPay + "]";
	}	

}
