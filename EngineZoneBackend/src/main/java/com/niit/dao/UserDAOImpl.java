package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean registerUser(UserDetail user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	@Transactional
	public boolean updateDetail(UserDetail user) {
		try
		{
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Transactional
	public UserDetail getUserDetail(String username) {
		Session session=sessionFactory.openSession();
		UserDetail userdetail=(UserDetail)session.get(UserDetail.class,username);
		session.close();
		return userdetail;
	}
	

}
