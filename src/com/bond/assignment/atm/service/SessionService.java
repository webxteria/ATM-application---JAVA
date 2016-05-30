package com.bond.assignment.atm.service;

import com.bond.assignment.atm.model.AccountModel;
import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.service.impl.SessionServiceImpl;

public class SessionService implements SessionServiceImpl {

	SessionModel sessionModel ;
	
	public SessionService(SessionModel sessionModel) {
		this.sessionModel = sessionModel;
	}

	@Override
	public SessionModel setSession(AccountModel accountModel) {
		sessionModel.setActiveUserAccount(accountModel.getAccountNumber());
		sessionModel.setActiveUserId(accountModel.getId());
		sessionModel.setUserType(accountModel.getAccountType());
		return sessionModel;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bond.assignment.atm.service.impl.SessionServiceImpl#getSession()
	 */
	@Override
	public SessionModel getSession() {
		return this.sessionModel;
	}

}
