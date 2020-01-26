package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IUserDao;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;
	
	@PostMapping("/login")
	public ResponseEntity<?> processLoginForm(@RequestBody User u)
	{
		Object loggedUser = dao.validateUser(u);
				
		if(loggedUser == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Object>(loggedUser,HttpStatus.OK);
	}

	@GetMapping("/getallusers")
	ResponseEntity<?> getAllUsers()
	{
		return new ResponseEntity<List<User>>(dao.getAllUsers(), HttpStatus.OK);
	}
	
}
