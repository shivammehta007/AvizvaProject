package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.User;

@Repository("userDAOImpl")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean registerUser(User user) {
		boolean flag = false;
		Session session = getSession();
		user.setEnable(true);
		session.persist(user);
		flag = true;
		return flag;
		
	}

	public boolean authLogin(String username, String password) {
		boolean flag = false;
		Session session = getSession();
			Query q =  session.createQuery("from User where username =:username and password =:password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			List<User> userList = q.list();
			if(!(userList.isEmpty())){
				flag = true;
			}

		return flag;
	}
	
	public User getUserByUsername(String username) {
		Session session = getSession();
		User user = session.get(User.class, username);
		return user;
		
	}
	
	public boolean deactivate(User user){
		boolean flag=false;
		Session session=getSession();
		user.setEnable(false);
		session.update(user);
		flag = true;
		return flag;
	}

	public boolean updateUser(User user) {
		boolean flag = false;
		Session session = getSession();
		session.update(user);
		flag = true;
		return flag;
	}
	
	

}
