package com.ems.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ems.configuration.SpringConfiguration;
import com.ems.dao.EmployeeDAO;
import com.ems.daoImpl.EmployeeDAOImpl;
import com.ems.viewBeans.Employee;

public class RegistrationService {

	@Resource(name="employeeDAO")
	EmployeeDAO dao;
	public boolean createLogin(Employee bean){
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		dao=(EmployeeDAOImpl)context.getBean("employeeDAO");
				
		boolean userFound = dao.checkLogin(bean.getUsername());
		
		if(!userFound){			
		
			dao.createLogin(bean);
		}
		
		return !userFound;
	}
	
	public String checkDetails(Employee bean){
		
		if(bean.getUsername().equals(""))
		return "Username cannot be empty";
		if(bean.getPassword().equals(""))
		return "Password cannot be empty";
		return "";
	}
	
}
