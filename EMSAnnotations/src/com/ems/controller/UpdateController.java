package com.ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.configuration.SpringConfiguration;
import com.ems.dao.EmployeeDAO;
import com.ems.daoImpl.EmployeeDAOImpl;
import com.ems.service.ActiveUser;
import com.ems.service.RegistrationService;
import com.ems.service.UpdateService;
import com.ems.viewBeans.Employee;

@Controller
@RequestMapping(value = "/update")
public class UpdateController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)

	{

		ModelAndView model = new ModelAndView("update");
		UpdateService service = (UpdateService)getBean("updateService");
		Employee bean = service.getActiveEmployee();
		model.addObject("update", bean);
		return model;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doUpdate(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("update") Employee bean) {
		ModelAndView model = new ModelAndView("update");
		if (bean.getPassword().equals("")) {
			request.setAttribute("errorMessage", "Password cannot be empty.");
		} else {
			UpdateService service = (UpdateService)getBean("updateService");
			int status = service.updateEmployeeDetails(bean);
			if (status == 1) {
				request.setAttribute("errorMessage", "Successfully Updated!!");
			} else {

				request.setAttribute("errorMessage", "Updation error.");
			}
		}
		return model;
	}
	
	private Object getBean(String beanName) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		Object obj=context.getBean(beanName);
		return obj;
	}

}
