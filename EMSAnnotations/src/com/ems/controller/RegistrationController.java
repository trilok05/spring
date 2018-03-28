package com.ems.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.configuration.SpringConfiguration;
import com.ems.service.RegistrationService;
import com.ems.viewBeans.Employee;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

	@RequestMapping(method = RequestMethod.GET)
	public String getRegister( Map<String, Object> model)

	{		
		Employee bean = (Employee)getBean("employee");
		model.put("registrationForm", bean);
		return "register";

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("registrationForm") Employee bean) {

		RegistrationService service = (RegistrationService)getBean("registrationService");
		String str=service.checkDetails(bean);
		if(!str.equals("")){
			request.setAttribute("errorMessage", str);
			return new ModelAndView("register");
		}
		boolean created = service.createLogin(bean);
		if (created) {
			request.setAttribute("errorMessage", "Successfully Registered!!");
			return new ModelAndView("register");
		} else {
			ModelAndView model = new ModelAndView("register");
//			model.addObject("registrationForm", registerbean);
			request.setAttribute("errorMessage", "User already exist!!");
			return model;
		}
	}
	
	private Object getBean(String beanName) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		Object obj=context.getBean(beanName);
		return obj;
	}
}
