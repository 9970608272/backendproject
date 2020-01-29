package com.app.daos;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao {

	List<User> getAllUsers();
	Object validateUser(User u);
	void deleteUserById(int u);
}
