package com.bond.assignment.atm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.model.TransactionModel;
import com.bond.assignment.atm.view.Menu;

public interface AccountServiceImpl {

	SessionModel authenticateUser(Menu view) throws SQLException;

	float checkAccountBalance(Menu view, SessionModel currentUserAccountDetails) throws SQLException;

	float updateAccount(TransactionModel transactionModel) throws SQLException;

	boolean updateNewBalance(TransactionModel transactionModel, float balance) throws SQLException;

	ResultSet accountsList() throws SQLException;

	boolean createAccount(int accountNumber) throws SQLException;

	ResultSet showAccountHistory(int accountNumber) throws SQLException;

}