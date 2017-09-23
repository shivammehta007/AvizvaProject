package com.avizva.trainingProject.backend.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.User;

/**
 * 
 * @author Akshay,Shivam,Saurabh
 * @repository
 * @Transactional
 * This is the UserDAOImpl class in
 * which there are unimplemented methods
 * which contains the business logic of
 * registration,authentication,and user
 * update.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = Logger.getLogger(SupplierDAOImpl.class);

	/**
	 * 
	 * @return is used to return the current session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/**@return we have returned the boolean value.
	 * In the below method we have applied the 
	 * logic for registering user using persist
	 * as one to one mapping is been performed.
	 */
	public boolean registerUser(User user) {
		LOGGER.info("UserDAO.registerUser called");
		boolean flag = false;
		try {
			Session session = getSession();
			user.setEnabled(true);
			session.persist(user);
			flag = true;
			LOGGER.info("UserDAO.registerUser successful");
		} catch (Exception e) {
			LOGGER.error("UserDAO.registerUser unsuccessful: "+e);
		}
		return flag;
		
	}
	
	
	/**
	 * @return flag is returning the boolean value.
	 * In the below method we have applied logic
	 * for the user authentication.   
	 */
	public boolean authLogin(String username, String password) {
		LOGGER.info("UserDAO.authLogin called");
		boolean flag = false;
		List<User> userList=null;
		try {
			Session session = getSession();
			Query q =  session.createQuery("from User where username =:username and password =:password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			userList = q.list();
			LOGGER.info("UserDAO.authLogin successful");
		} catch (Exception e) {
			LOGGER.error("UserDAO.authLogin unsuccessful: "+e);

		}
		if(!(userList.isEmpty())){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @return returning the object of user.
	 * 
	 */
	public User getUserByUsername(String username) {
		User user=null;
		try {
			Session session = getSession();
			user = session.get(User.class, username);
		} catch (Exception e) {
			LOGGER.error("UserDAO.getUserByUsername unsuccessful: "+e);
		}
		return user;
	}
	
	/**
	 * @return flag is returning the boolean value.
	 * In the below method we are applying business logic for
	 * deactivation of user by making enable false
	 */
	public boolean deactivate(User user){
		boolean flag=false;
		try {
			Session session=getSession();
			user.setEnabled(false);
			session.update(user);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	/**
	 * @return flag is returning the boolean value.
	 * In the below method we are applying business logic for
	 * update of user.
	 */
	public boolean updateUser(User user) {
		boolean flag = false;
		try {
			Session session = getSession();
			
			session.update(user);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	

}
