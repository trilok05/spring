package com.ems.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.ems.dao.EmployeeDAO;
import com.ems.service.ActiveUser;
import com.ems.viewBeans.Employee;
@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	public boolean checkLogin(String username) {

		SessionFactory factory = configure();
		Session session = factory.openSession();

		System.out.println("In Check login");
		boolean userFound = false;
		String SQL_QUERY = " from Employee as e where e.username= :code";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("code", username);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;
	}

	public void createLogin(Employee obj) {

		SessionFactory factory = configure();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(obj);
		System.out.println("Employee saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}

	private SessionFactory configure() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}
	
	public Employee getEmployeeDetail(String username){
		
		SessionFactory factory = configure();
		Session session = factory.openSession();

		System.out.println("In Check login");
		String SQL_QUERY = " from Employee as e where e.username= :code";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("code", username);
		List list = query.list();
		return (Employee)list.get(0);
	}
	
	public List getAllEmployeesList(){
		
		SessionFactory factory = configure();
		Session session = factory.openSession();

		String SQL_QUERY = " from Employee";
		Query query = session.createQuery(SQL_QUERY);
		List list = query.list();
		return list;
	}
	
	public int updateEmployeeDetails(Employee obj) {

		try{
		SessionFactory factory = configure();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(obj);
		System.out.println("Employee updated successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
		}catch(Exception e){
			return 0;
		}
		return 1;
	}
	
	public int deleteCurrentEmployee() {

		try{
		SessionFactory factory = configure();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();	
		String hql = "delete from Employee where username= :uid";
		Query query = session.createQuery(hql);
	    query.setString("uid", ActiveUser.username);
		System.out.println(query.executeUpdate());
		System.out.println("Employee deleted successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
		}catch(Exception e){
			return 0;
		}
		return 1;
	}
}
