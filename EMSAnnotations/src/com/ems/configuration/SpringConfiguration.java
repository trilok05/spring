package com.ems.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ems.daoImpl.EmployeeDAOImpl;
import com.ems.service.AllEmployeeService;
import com.ems.service.DeleteService;
import com.ems.service.LoginService;
import com.ems.service.RegistrationService;
import com.ems.service.UpdateService;
import com.ems.viewBeans.Employee;
import com.ems.viewBeans.LoginPageBean;

@Configuration
public class SpringConfiguration {

	@Bean(name="loginPageBean")
	public LoginPageBean loginPageBean(){
		return new LoginPageBean();	 
	}
	
	@Bean(name="employee")
	public Employee employee(){
		return new Employee();	 
	}
	
	@Bean(name="loginService")
	public LoginService loginService(){
		return new LoginService();	 
	}
	
	@Bean(name="registrationService")
	public RegistrationService registrationService(){
		return new RegistrationService();	 
	}
	
	@Bean(name="deleteService")
	public DeleteService deleteService(){
		return new DeleteService();	 
	}
	
	@Bean(name="updateService")
	public UpdateService updateService(){
		return new UpdateService();	 
	}
	
	@Bean(name="allEmployeeService")
	public AllEmployeeService allEmployeeService(){
		return new AllEmployeeService();	 
	}
	
	@Bean(name="employeeDAO" )
	public EmployeeDAOImpl employeeDAO(){
		return new EmployeeDAOImpl();	 
	}
}
