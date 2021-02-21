package com.arun.shop.dao;
import com.arun.shop.entity.User;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
	private EntityManager entityManager;
@Autowired
	public UserDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<User> findAll(){
		Session currentSession= entityManager.unwrap(Session.class);
		Query<User> theQuery=
				currentSession.createQuery("from User",User.class);
		List<User> users1=theQuery.getResultList();
		return users1;
	}
	
}
