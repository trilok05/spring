package com.ems.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ems.configuration.SpringConfiguration;
import com.ems.service.ActiveUser;
import com.ems.service.LoginService;
import com.ems.service.RegistrationService;
import com.ems.viewBeans.LoginPageBean;
import com.ems.viewBeans.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)	
	 public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	
	    {
	
	        ModelAndView model = new ModelAndView("login");
	        
	        LoginPageBean loginBean = (LoginPageBean)getBean("loginPageBean");
	
	        model.addObject("loginForm", loginBean);
	
	        return model;
	
	    }
		
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addStudent(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginForm") LoginPageBean bean) {
		
		LoginService service = (LoginService)getBean("loginService");
		boolean checked = service.checkLogin(bean);
		
		if (checked) {
			ActiveUser.username=bean.getUsername();
			return new ModelAndView("welcome");
		} else {
			ModelAndView model = new ModelAndView("login","errorMessage", "Invalid Login!!");
//			model.addObject("loginForm", bean);
//			request.setAttribute("errorMessage", "Invalid Login!!");
			return model;
		}
	}
	
	private Object getBean(String beanName) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		Object obj=context.getBean(beanName);
		return obj;
	}
	
}
