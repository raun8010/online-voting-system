package com.ronak.VotingApp.Service;

import java.util.ArrayList;

import com.ronak.VotingApp.Dao.VotingAppDao;
import com.ronak.VotingApp.Entity.Candidates;
import com.ronak.VotingApp.Entity.User;
import com.ronak.VotingApp.Exception.DaoLayerExceptions;
import com.ronak.VotingApp.Exception.ServiceLayerException;

public class VotingAppService {

VotingAppDao dao = new VotingAppDao();

	public ArrayList<Candidates> getCandidatesfromservicelayer() throws ServiceLayerException  {
		try {
			return dao.getAllCandidatesdetails();		
		}catch(DaoLayerExceptions e) {
			throw new ServiceLayerException("error while fetching from dao to service",e);
		}
	}

	public ArrayList<User> getUserfromservicelayer() throws ServiceLayerException {
		try {
			return dao.getAllUserdetails();		
		}catch(DaoLayerExceptions e) {
			throw new ServiceLayerException("error while fetching from dao to service",e);
		}		
	}

	public void addVotertoService(User user) throws ServiceLayerException {
		try {
			int count=0;
			dao.addDetailsToDao(user);
			ArrayList<Candidates> result=dao.getAllCandidatesdetails();
			
			for(int i=0;i<result.size();i++)
			{
				if(result.get(i).getCandidateId()==1 && user.getCandidateId()==1)
				{
					count=result.get(i).getCandidateCount()+1;
				}
				else if(result.get(i).getCandidateId()==2 && user.getCandidateId()==2)
				{
					count=result.get(i).getCandidateCount()+1;
				}
				else if(result.get(i).getCandidateId()==3 && user.getCandidateId()==3)
				{
					count=result.get(i).getCandidateCount()+1;
				}
				else if(result.get(i).getCandidateId()==4 && user.getCandidateId()==4)
				{
					count=result.get(i).getCandidateCount()+1;
				}
				
			}
			dao.updatecount(user, count);
		}catch (DaoLayerExceptions e) {
			throw new ServiceLayerException("error while sending data from service to dao", e);
		}
	}

}
