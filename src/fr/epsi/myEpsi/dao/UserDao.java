package fr.epsi.myEpsi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.servlet.Login;

public class UserDao implements IUserDao{

	
	private DAOManager connection;
	private static Logger logger = Logger.getLogger(UserDao.class);
	
	public UserDao() {
		connection.getConnection();
	}
	
	@Override
	public List<User> getListOfUsers() {
		List<User> user = new ArrayList<User>();
        try {
        	
            Statement statement = connection.createStatement();
            String req = "SELECT * FROM USERS";
            ResultSet results = null;

            results = statement.executeQuery(req);
    			    while (results.next()) {
    			    	user.add(new User(results.getString(1), results.getString(2), results.getBoolean(3)));
    			     }	   

    		} catch (SQLException e1) {
    			e1.printStackTrace();
    		}
    		return user;
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
    		.prepareStatement("INSERT INTO USERS(id,password,administrator) values "
    				+ "('" + user.getId() + "','"+user.getPassword()+ "','"+ user.getAdministrator()+ "')");
            // Parameters start with 1
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE USERS set password=" + user.getPassword() + ","
                    		+ " administrator="+ user.getAdministrator()+ 
                            "where ID=" + user.getId() +"");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteUser(User user) {
		 try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("DELETE FROM USERS where ID="+ user.getId()+"");
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}


}