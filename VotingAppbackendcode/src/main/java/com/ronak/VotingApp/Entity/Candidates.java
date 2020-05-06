package com.ronak.VotingApp.Entity;

public class Candidates {
	private int candidateId;
	private String candidateName;
	private int candidateCount;
	public Candidates() {
		super();
	}
	public Candidates(int candidateId, String candidateName, int candidateCount) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateCount = candidateCount;
	}
	public Candidates(String candidateName, int candidateCount) {
		super();
		this.candidateName = candidateName;
		this.candidateCount = candidateCount;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public int getCandidateCount() {
		return candidateCount;
	}
	public void setCandidateCount(int candidateCount) {
		this.candidateCount = candidateCount;
	}
	@Override
	public String toString() {
		return "Candidates [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidateCount="
				+ candidateCount + "]";
	}
	
	

}
