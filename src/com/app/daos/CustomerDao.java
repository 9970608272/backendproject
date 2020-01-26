package com.app.daos;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;
import com.app.pojos.Role;



@Repository
@Transactional
public class CustomerDao implements ICustomerDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Customer> getAllCustomers() 
	{
		try {
			System.out.println("in list cdao");
			
			String jpql="select c from Customer c";
			   
			List<Customer> list = sf.getCurrentSession().createQuery(jpql,Customer.class).getResultList();
			
			if(list==null)
				System.out.println("list is null");
			else
			 System.out.println(list);
			
			return list;
		} catch (RuntimeException e) {
			
			
			System.out.println("in list cdao");
			
			e.printStackTrace();
			
			
		}
		return null;
		 
	}

	@Override
	public Customer addCustomer(Customer c) 
	{
		User u=new User(c.getEmail(),c.getPassword(),Role.CUSTOMER);
		sf.getCurrentSession().save(u);
		c.setUser(u);
		c.setRole(Role.CUSTOMER);
		sf.getCurrentSession().persist(c);	
		return c;
	}

	@Override
	public void deleteCustomerById(Integer cid) {
		System.out.println("in dao"+cid);
		Customer cust=sf.getCurrentSession().get(Customer.class, cid);
		sf.getCurrentSession().delete(cust);
	}

	@Override
	public Customer getCustomerrById(int c) {
		
		return sf.getCurrentSession().get(Customer.class, c);
	}

	@Override
	public void updateCustomer(Customer c) {
		sf.getCurrentSession().update(c);
		
	}
	@Override
	public void addCustomerAddress(Integer cid, Address ca) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.setAddress(ca);
		sf.getCurrentSession().update(c);
	}

	@Override
	public Address getCustomerAddressesByCustomerId(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		return c.getAddress();
	}

	@Override
	public void removeCustomerAddress(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.setAddress(null);
		sf.getCurrentSession().update(c);
	}

	
	
}

