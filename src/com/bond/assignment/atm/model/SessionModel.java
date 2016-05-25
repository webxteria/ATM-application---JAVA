package com.bond.assignment.atm.model;

public class SessionModel {
	
	private int activeUserId;
	private int activeUserAccount;
	private int userType;

	public int getActiveUserId() {
		return activeUserId;
	}

	public void setActiveUserId(int activeUserId) {
		this.activeUserId = activeUserId;
	}

	public int getActiveUserAccount() {
		return activeUserAccount;
	}

	public void setActiveUserAccount(int activeUserAccount) {
		this.activeUserAccount = activeUserAccount;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
