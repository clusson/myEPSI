package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDao;

public class UserService implements IUserService {
	private IUserDao userDao;
	
	public UserService() {
		
	}

	@Override
	public List<User> getListOfUsers() {
		return userDao.getListOfUsers();
	}

	@Override
	public User getUserById(String id) {
		User user = userDao.getUserById(id);
		return user;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}


}
