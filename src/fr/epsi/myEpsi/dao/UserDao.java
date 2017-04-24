package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.User;

public class UserDao implements IUserDao{

	@Override
	public List<User> getListOfUsers() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		Connection con;
		
		ResultSet resultats = null;
		String requete = "SELECT * FROM USERS";
		ArrayList user = new ArrayList<User>();
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			   Statement stmt = con.createStatement();
			   resultats = stmt.executeQuery(requete);
			    while (resultats.next()) {
			    	user.add(new User(resultats.getString(1), resultats.getString(2), resultats.getBoolean(3)));

			     }	   

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return user;

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