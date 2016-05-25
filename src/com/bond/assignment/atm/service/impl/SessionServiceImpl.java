package com.bond.assignment.atm.service.impl;

import com.bond.assignment.atm.model.AccountModel;
import com.bond.assignment.atm.model.SessionModel;

public interface SessionServiceImpl {

	SessionModel setSession(AccountModel accountModel);

	SessionModel getSession();

}