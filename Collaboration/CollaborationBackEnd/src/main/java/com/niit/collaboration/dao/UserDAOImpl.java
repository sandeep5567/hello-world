package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Users;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		List<Users> listUser = sessionFactory.getCurrentSession().createCriteria(Users.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

	@Transactional
	public Users get(String userId) {
		String hql = "from Users where user_id= '" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Users> listUser = (List<Users>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}

		return null;
	}

	@Transactional
	public void saveorupdate(Users user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void delete(String userId) {
		Users userToDelete = new Users();
		userToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Transactional
	public boolean isValidUser(String username, String password) {
		String hql = "from Users where user_id= '" + username + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Users> list = (List<Users>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}

}
