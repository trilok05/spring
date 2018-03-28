package com.ems.dao;

import java.util.List;

import com.ems.viewBeans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeDetail(String username);
	
	public boolean checkLogin(String username);
	
	public void createLogin(Employee obj);
	
	public int updateEmployeeDetails(Employee obj);
	
	public int deleteCurrentEmployee();
	
	public List getAllEmployeesList();
}
