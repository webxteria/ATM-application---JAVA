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

	AccountDao accountDao = new AccountDao();
	AccountModel accountModel;
	SessionServiceImpl sessionService = new SessionService();
	ValidatorService validatorService = new ValidatorService();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bond.assignment.atm.service.impl.AccountService#authenticateUser(com.
	 * bond.assignment.atm.view.Menu)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bond.assignment.atm.service.impl.AccountService#checkAccountBalance(
	 * com.bond.assignment.atm.view.Menu,
	 * com.bond.assignment.atm.model.SessionModel)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bond.assignment.atm.service.impl.AccountService#updateAccount(com.
	 * bond.assignment.atm.model.TransactionModel)
	 */
	@Override
	public float updateAccount(TransactionModel transactionModel) throws SQLException {
		accountDao = new AccountDao();
		return accountDao.getAccountDetails(transactionModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bond.assignment.atm.service.impl.AccountService#updateNewBalance(com.
	 * bond.assignment.atm.model.TransactionModel, float)
	 */
	@Override
	public boolean updateNewBalance(TransactionModel transactionModel, float balance) throws SQLException {
		accountDao = new AccountDao();
		return accountDao.updateAccountDetails(transactionModel, balance);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bond.assignment.atm.service.impl.AccountService#accountsList()
	 */
	@Override
	public ResultSet accountsList() throws SQLException {
		accountDao = new AccountDao();
		return accountDao.getAccountsList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bond.assignment.atm.service.impl.AccountService#createAccount(int)
	 */
	@Override
	public boolean createAccount(int accountNumber) throws SQLException {
		accountDao = new AccountDao();
		return accountDao.createNewUserAccount(accountNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bond.assignment.atm.service.impl.AccountService#showAccountHistory(
	 * int)
	 */
	@Override
	public ResultSet showAccountHistory(int accountNumber) throws SQLException {
		accountDao = new AccountDao();
		return accountDao.getAccountHistory(accountNumber);
	}
}
