package com.ems.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ems.configuration.SpringConfiguration;
import com.ems.dao.EmployeeDAO;
import com.ems.daoImpl.EmployeeDAOImpl;
import com.ems.viewBeans.LoginPageBean;

public class LoginService {

	@Resource(name="employeeDAO")
	EmployeeDAO dao;
	public boolean checkLogin(LoginPageBean bean){
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		dao=(EmployeeDAOImpl)context.getBean("employeeDAO");
		
		return dao.checkLogin(bean.getUsername());
	}
}
