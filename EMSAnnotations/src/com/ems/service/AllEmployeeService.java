package com.ems.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ems.configuration.SpringConfiguration;
import com.ems.dao.EmployeeDAO;
import com.ems.daoImpl.EmployeeDAOImpl;
@Service("allEmployeeService")
public class AllEmployeeService {

	@Resource(name="employeeDAO")
	EmployeeDAO dao;
	public List getAllEmployeesList(){
		ApplicationContext context = applicationContext();

		dao=(EmployeeDAOImpl)context.getBean("employeeDAO");
		
		return dao.getAllEmployeesList();
	}

	private ApplicationContext applicationContext() {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		return context;
	}
}
