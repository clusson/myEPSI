package fr.epsi.myEpsi.service;
import java.util.List;

import fr.epsi.myEpsi.beans.User;
import utils.UserDuplicateException;

public interface IUserService {

	List<User> getListOfUsers();
	User getUserById(String id);
	void addUser(User user) throws UserDuplicateException;
	void updateUser(User user);
	void deleteUser(User user);

}
