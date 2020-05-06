package com.ronak.VotingApp.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ronak.VotingApp.Exception.AuthenticationException;

public class ConnectionUtility {
	
	private static final String URL= "jdbc:mysql://localhost:3306/voting";
	private static final String USER ="root";
	private static final String PWD= "King@1234";
	
	public Connection getConnection() throws AuthenticationException {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL ,USER, PWD);
			
		}catch(SQLException e) {
			throw new AuthenticationException("Something went wrong with db connection ",e);
			
		}
		return con;
		
	}
	

}
