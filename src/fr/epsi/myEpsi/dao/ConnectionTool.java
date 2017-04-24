package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectionTool {
	
	public static void main (String[] args) {
		Connection con = ConnectionTool.getConnection();
		if (con != null) {
			System.out.println(con.toString());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		Connection con = null;
		
		ResultSet resultats = null;
		String requete = "SELECT * FROM USERS";

		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
			   java.sql.Statement stmt = con.createStatement();
			   resultats = stmt.executeQuery(requete);
			   ResultSetMetaData rsmd = resultats.getMetaData();
			    int nbCols = rsmd.getColumnCount();

			    while (resultats.next()) {
			        for (int i = 1; i <= nbCols; i++) {
			            System.out.print(resultats.getString(i) + " ");
			         }
			         System.out.println();
			     }	   

		} catch (SQLException e1) {
			e1.printStackTrace();
	}
		return con;

	}
}
