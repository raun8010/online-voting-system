package com.ronak.VotingApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ronak.VotingApp.Entity.Candidates;
import com.ronak.VotingApp.Entity.User;
import com.ronak.VotingApp.Exception.AuthenticationException;
import com.ronak.VotingApp.Exception.DaoLayerExceptions;
import com.ronak.VotingApp.Utility.ConnectionUtility;

public class VotingAppDao {

	ConnectionUtility cu = new ConnectionUtility();

	public ArrayList<Candidates> getAllCandidatesdetails() throws DaoLayerExceptions {
		try {
			ArrayList<Candidates> result = new ArrayList<>();
			Connection con = cu.getConnection();
			String query = "select * from candidates";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Candidates obj = new Candidates(rs.getInt(1), rs.getString(2), rs.getInt(3));

				result.add(obj);
			}
			con.close();
			return result;
		} catch (SQLException | AuthenticationException e) {
			throw new DaoLayerExceptions("error while fetching candidates", e);
		}
	}

	public void addDetailsToDao(User user) throws DaoLayerExceptions {
		try {
			Connection con = cu.getConnection();
			String query = "Insert INTO user (userFirstName,userLastName,userPhoneNo,votecandidateId) VALUES (?,?,?,?)";
			PreparedStatement ps;
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUserFirstName());
			ps.setString(2, user.getUserLastName());
			ps.setString(3, user.getUserPhoneNo());
			ps.setInt(4, user.getCandidateId());
			ps.execute();
			con.close();
		} catch (SQLException | AuthenticationException e) {
			throw new DaoLayerExceptions("error while fetching users", e);

		}
	}

	public ArrayList<User> getAllUserdetails() throws DaoLayerExceptions {
		try {
			ArrayList<User> result = new ArrayList<>();
			Connection con = cu.getConnection();
			String query = "select * from user";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User obj = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				result.add(obj);
			}
			
			con.close();
				return result;
			
		} catch (SQLException | AuthenticationException e) {
			throw new DaoLayerExceptions("error while fetching users", e);
		}
	
	}

	public void updatecount (User user, int count) throws DaoLayerExceptions{
         try {
         Connection con=cu.getConnection();
         String query= "UPDATE candidates SET candidateCount= " + count +" WHERE candidateId ='"+ user.getCandidateId()+"'";


         PreparedStatement ps;
         ps= con.prepareStatement(query);
         ps.execute();
         con.close();
         }catch(SQLException |AuthenticationException e)
	{
         throw new DaoLayerExceptions("error while inserting", e);

}
	}
	
}
