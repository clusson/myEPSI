package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDao;

public class UserService implements IUserService {
	private IUserDao userDao;
	
	public UserService() {
		UserDao user = new UserDao();
	}

	
	@Override
	public List<User> getListOfUsers() {
		List<User> result = userDao.getListOfUsers();
		return result;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}