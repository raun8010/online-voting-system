package com.ronak.VotingApp.Entity;

public class User {
	private int userId;
	private String userFirstName;
	private String userLastName;
	private String userPhoneNo;
	private int candidateId;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userFirstName, String userLastName, String userPhoneNo, int candidateId) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNo = userPhoneNo;
		this.candidateId = candidateId;
	}
	public User(String userFirstName, String userLastName, String userPhoneNo, int candidateId) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNo = userPhoneNo;
		this.candidateId = candidateId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userPhoneNo=" + userPhoneNo + ", candidateId=" + candidateId + "]";
	}
	
	
	

}
