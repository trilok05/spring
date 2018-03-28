package com.ems.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.configuration.SpringConfiguration;
import com.ems.dao.EmployeeDAO;
import com.ems.daoImpl.EmployeeDAOImpl;

public class DeleteService {

	@Resource(name="employeeDAO")
	EmployeeDAO dao;
	
	public int deleteEmployee(){
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		dao=context.getBean(EmployeeDAOImpl.class);
		
		return dao.deleteCurrentEmployee();
	}
}
