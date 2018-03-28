package com.ems.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.configuration.SpringConfiguration;
import com.ems.service.AllEmployeeService;

@Controller
@RequestMapping(value="/allemployees")
public class AllEmployeesListController {

	private ApplicationContext context;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAllEmployee(HttpServletRequest request, HttpServletResponse response)

	{
		context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		AllEmployeeService service=(AllEmployeeService)context.getBean("allEmployeeService");		
		List list=service.getAllEmployeesList();
		request.setAttribute("emplist", list);
		ModelAndView model = new ModelAndView("allemployees");
		return model;
	}
}
