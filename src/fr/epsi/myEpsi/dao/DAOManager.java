package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOManager {
	
	public Connection connection;

	public DAOManager() throws ClassNotFoundException, SQLException{
		Class.forName("org.hsqldb.jdbcDriver");
		this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
	}
	
	public Connection getConnection() {
		return this.connection;
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	public PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}