package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;
import com.app.pojos.Photographer;
import com.app.pojos.Role;
import com.app.pojos.User;

@Repository
@Transactional
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> getAllUsers() {

		String jpql = "Select u from User u";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	}

	@Override
	public Object validateUser(User u) 
	{
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		User dbu = sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", u.getEmail())
				.setParameter("pass", u.getPassword()).getSingleResult();

		if (dbu != null) {
			if (dbu.getRole().equals(Role.CUSTOMER)) {
				String jpql1 = "select c from Customer c where c.email=:em";
				return sf.getCurrentSession().createQuery(jpql1, Customer.class).setParameter("em", dbu.getEmail())
						.getSingleResult();
			} else if (dbu.getRole().equals(Role.PHOTOGRAPHER)) {
				String jpql2 = "select p from Photographer p where p.email=:em";
				return sf.getCurrentSession().createQuery(jpql2, Photographer.class).setParameter("em", dbu.getEmail())
						.getSingleResult();
			} else {
				return dbu;
			}
		}
		return null;
	}

	@Override
	public void deleteUserById(int u) {
		
		System.out.println("in dao"+u);
		User user=sf.getCurrentSession().get(User.class, u);
		sf.getCurrentSession().delete(user);	
	}
}
