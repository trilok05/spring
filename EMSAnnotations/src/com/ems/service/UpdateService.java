package com.ems.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.configuration.SpringConfiguration;
import com.ems.dao.EmployeeDAO;
import com.ems.daoImpl.EmployeeDAOImpl;
import com.ems.viewBeans.Employee;

public class UpdateService {

	@Resource(name="employeeDAO")
	EmployeeDAO dao;
	public Employee getActiveEmployee(){
		dao = (EmployeeDAO)getBean("employeeDAO");
		Employee bean = dao.getEmployeeDetail(ActiveUser.username);
		return bean;
	}
	
	public int updateEmployeeDetails(Employee obj){
		EmployeeDAO dao = (EmployeeDAO)getBean("employeeDAO");
		return dao.updateEmployeeDetails(obj);
	}
	
	private Object getBean(String beanName) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		Object obj=context.getBean(beanName);
		return obj;
	}
}
