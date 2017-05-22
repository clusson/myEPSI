package fr.epsi.myEpsi.service;

import java.util.List;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDao;
import utils.UserDuplicateException;

public class UserService implements IUserService {
	public IUserDao dao = new UserDao();
	public static Logger logger = Logger.getLogger(UserService.class);

	@Override
	public List<User> getListOfUsers() {
		return dao.getListOfUsers();
	}

	@Override
	public User getUserById(String id) {
		User user = dao.getUserById(id);
		return user;
	}

	@Override
	public void addUser(User user) throws UserDuplicateException {
		if(getUserById(user.getId()) == null){
			dao.addUser(user);	
		} else {
			throw new UserDuplicateException();
		}
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		dao.deleteUser(user);
	}


}
