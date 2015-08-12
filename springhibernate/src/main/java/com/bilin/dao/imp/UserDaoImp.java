package com.bilin.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bilin.dao.UserDaoInterface;
import com.bilin.util.SessionHelper;

@Component
public class UserDaoImp implements UserDaoInterface {

	private SessionHelper sessionHelper;

	private SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	private void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	public int getUserNumber() {
		// TODO Auto-generated method stub
		Session session = this.getSessionHelper().openSession();
		try {

			org.hibernate.Query tempquery = session.createQuery("from MainUser");
			@SuppressWarnings("unchecked")
			int usersize = tempquery.list().size();
			session.close();
			return usersize;

		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			return 0;
		}
	}

	
	
}
