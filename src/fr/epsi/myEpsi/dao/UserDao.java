package fr.epsi.myEpsi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.User;

public class UserDao implements IUserDao{

	
	private DAOManager connection;
	
	public UserDao() {
		connection.getConnection();
	}
	
	
	
	@Override
	public List<User> getListOfUsers() {
		List<User> users = new ArrayList<User>();
        try {
        	
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM USERS");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAdministrator(rs.getBoolean("ISADMINSITRATOR"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
	}

	@Override
	public User getUserById(String id) {
		User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM USERS where ID=?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId((rs.getString("ID")));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAdministrator(rs.getBoolean("ISADMINISTRATOR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
	}

	@Override
	public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
    		.prepareStatement("INSERT INTO USERS(id,password,administrator) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getAdministrator());
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE USERS set PASSWORD=?, ISADMINISTRATOR=?" +
                            "where ID=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setBoolean(2, user.getAdministrator());
            preparedStatement.setString(3, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteUser(User user) {
		 try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("DELETE FROM USERS where ID=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}


}