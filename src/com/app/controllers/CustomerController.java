package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.ICustomerDao;
import com.app.pojos.Address;
import com.app.pojos.Customer;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerDao dao;

	@PostMapping(value="/addCustomer" ,consumes = "application/json", produces = "application/json")
	ResponseEntity<?> addCustomer(@RequestBody Customer c) {
		System.out.println("in addcust");
		return new ResponseEntity<Customer>(dao.addCustomer(c), HttpStatus.CREATED);
	}

	@GetMapping("/getallcustomers")
	ResponseEntity<?> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(dao.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/getcustomerById/{cid}")
	ResponseEntity<?> getCustomerById(@PathVariable String cid) {
		int i = Integer.parseInt(cid);
		System.out.println("cid :" + cid);
		return new ResponseEntity<Customer>(dao.getCustomerrById(i), HttpStatus.CREATED);
	}

	@PostMapping("/updatecustomer")
	ResponseEntity<?> updateCustomer(@RequestBody Customer c) {
		dao.updateCustomer(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/deletecustomerbyid/{cid}")
	public void deleteCustomerById(@PathVariable Integer cid) {
		System.out.println("in delete custo " + cid);
		dao.deleteCustomerById(cid);
	}
	@PostMapping("/addCustomerAddress/{cid}")
	ResponseEntity<?> addCustomerAddress(@PathVariable Integer cid, @RequestBody Address ca) {
		dao.addCustomerAddress(cid, ca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getCustomerAddressesByCustomerId/{cid}")
	ResponseEntity<?> getCustomerAddressesByCustomerId(@PathVariable Integer cid) {
		return new ResponseEntity<Address>(dao.getCustomerAddressesByCustomerId(cid), HttpStatus.OK);
	}

	@PostMapping("/removeCustomerAddress")
	ResponseEntity<?> removeCustomerAddress(@RequestParam int cid) {
		dao.removeCustomerAddress(cid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
