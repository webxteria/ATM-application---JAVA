package com.bond.assignment.atm.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bond.assignment.atm.dao.AccountDao;
import com.bond.assignment.atm.model.AccountModel;
import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.model.TransactionModel;
import com.bond.assignment.atm.service.impl.AccountServiceImpl;
import com.bond.assignment.atm.service.impl.SessionServiceImpl;
import com.bond.assignment.atm.view.Menu;

public class AccountService implements AccountServiceImpl {

	AccountDao accountDao;
	AccountModel accountModel;
	SessionServiceImpl sessionService;
	ValidatorService validatorService;

	public AccountService(SessionServiceImpl sessionService,ValidatorService validatorService,AccountDao accountDao) {
		this.sessionService = sessionService;
		this.validatorService = validatorService;
		this.accountDao = accountDao;
	}
	
	@Override
	public SessionModel authenticateUser(Menu view) throws SQLException {
		accountModel = view.authenticationInput();
		accountModel = accountDao.authenticateUser(accountModel);
		if (validatorService.validateNullPointerValidator(accountModel) == false) {
			System.out.println("Invalid User Name/ password ... !");
			authenticateUser(view);
		}
		sessionService.setSession(accountModel);
		return sessionService.getSession();
	}


	@Override
	public float checkAccountBalance(Menu view, SessionModel currentUserAccountDetails) throws SQLException {
		int accountNumber = 0;
		if (currentUserAccountDetails.getUserType() == 0) {
			accountNumber = view.getAccountNumber();
		} else {
			accountNumber = currentUserAccountDetails.getActiveUserAccount();
		}
		return accountDao.getAccountDetails(accountNumber);
	}

	
	@Override
	public float updateAccount(TransactionModel transactionModel) throws SQLException {
		return accountDao.getAccountDetails(transactionModel);
	}

	
	@Override
	public boolean updateNewBalance(TransactionModel transactionModel, float balance) throws SQLException {
		return accountDao.updateAccountDetails(transactionModel, balance);
	}

	
	@Override
	public ResultSet accountsList() throws SQLException {
		return accountDao.getAccountsList();
	}

	
	@Override
	public boolean createAccount(int accountNumber) throws SQLException {
		return accountDao.createNewUserAccount(accountNumber);
	}

	
	@Override
	public ResultSet showAccountHistory(int accountNumber) throws SQLException {
		return accountDao.getAccountHistory(accountNumber);
	}
}
