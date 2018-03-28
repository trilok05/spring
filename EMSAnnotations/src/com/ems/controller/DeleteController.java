package com.ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.configuration.SpringConfiguration;
import com.ems.service.DeleteService;
import com.ems.viewBeans.LoginPageBean;

@Controller
@RequestMapping(value = "/delete")
public class DeleteController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)

	{
		ModelAndView model = new ModelAndView("login","loginForm",new LoginPageBean());
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeleteService service=(DeleteService)context.getBean("deleteService");
		int status = service.deleteEmployee();
		if (status == 1) {
			request.setAttribute("errorMessage", "Successfully Deleted!!");
		} else {

			request.setAttribute("errorMessage", "Deletion error.");
		}
		return model;
	}
}
