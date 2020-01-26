package com.app.daos;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Customer;


public interface ICustomerDao 


{
	List<Customer> getAllCustomers();
	Customer addCustomer(Customer c);

	void deleteCustomerById(Integer cid);

	Customer getCustomerrById(int c);

	void updateCustomer(Customer c);
	public void addCustomerAddress(Integer cid, Address ca);
	public Address getCustomerAddressesByCustomerId(int cid);
	public void removeCustomerAddress(int cid);
}


