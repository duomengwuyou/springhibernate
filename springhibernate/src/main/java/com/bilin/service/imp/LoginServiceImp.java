package com.bilin.service.imp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bilin.dao.UserDaoInterface;
import com.bilin.dao.entity.MainUser;
import com.bilin.service.LoginServiceInterface;
import com.bilin.util.SessionHelper;

@Component
public class LoginServiceImp implements LoginServiceInterface {

	private SessionHelper sessionHelper;
	private UserDaoInterface userDao;

	private SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	private void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	public UserDaoInterface getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoInterface userDao) {
		this.userDao = userDao;
	}


	// 验证用户是否存在
	public int validate(String username, String password) {
		Session session = this.getSessionHelper().openSession();
		try {
			org.hibernate.Query query = session.createQuery("from MainUser as u where u.name=? and u.password = ?");
			// " and role=?");
			query.setString(0, username);
			query.setString(1, password);
			// query.setInteger(2, role);
			@SuppressWarnings("unchecked")
			List<MainUser> list = query.list();
			session.close();

			if (list.size() == 1) {
				return list.get(0).getId();
			}
			else {
				return -1;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			session.close();
			return -1;
		}
	}

	public MainUser getUser(int userid) {
		// TODO Auto-generated method stub
		Session session = this.getSessionHelper().openSession();
		try {
			org.hibernate.Query query = session.createQuery("from MainUser as u where u.id = ?");
			// " and role=?");
			query.setInteger(0, userid);
			// query.setInteger(2, role);
			@SuppressWarnings("unchecked")
			List<MainUser> list = query.list();

			if (list.size() == 1) {
				return list.get(0);
			}
			else {
				return null;
			}

		}
		catch (Exception e) {
			// e.printStackTrace();
			session.close();
			return null;
		}finally{

		}
	}

	public boolean registUser(MainUser newuser) {
		// TODO Auto-generated method stub
		Session session = this.getSessionHelper().openSession();
		Transaction transaction = session.beginTransaction();

		try {

			session.save(newuser);
			transaction.commit();
			return true;

		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(MainUser user) {
		// TODO Auto-generated method stub
		Session session = this.getSessionHelper().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.merge(user);
			transaction.commit();
			return true;
		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	
	}

}
