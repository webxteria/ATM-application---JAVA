package com.bond.assignment.atm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bond.assignment.atm.model.AccountModel;
import com.bond.assignment.atm.model.TransactionModel;
import com.bond.assignment.atm.service.impl.SessionServiceImpl;

public class AccountDao {

	Database db = new Database();
	private final int adminAccountNumber = 440101;
	private final int adminAccountPin = 6470;
	float amount;
	SessionServiceImpl sessionService;

	public AccountDao(SessionServiceImpl sessionService){
		this.sessionService = sessionService;
	}
	public boolean createNewUserAccount(int accountNumber) throws SQLException {
		try {

			String query = "insert into  account(account_number,account_pin) values ( " + accountNumber + ", "
					+ generateRandomNumber() + ")";
			db.updateData(query);
			return true;
		} catch (Exception ex) {
			System.out.println("Database Errors");
			return false;
		}

	}

	public int generateRandomNumber() {
		return ((int) (Math.random() * 5000 + 1));
	}

	public boolean updateAccountDetails(TransactionModel transactionModel, float balance) throws SQLException {
		String query = "Update account SET current_balance = " + balance + " WHERE account_number = "
				+ transactionModel.getTransactionAccount();
		db.updateData(query);
		return true;

	}

	public ResultSet getAccountsList() throws SQLException {
		String query = "SELECT account_number,current_balance FROM account";
		ResultSet rs = db.retriveData(query);
		return rs;
	}

	public ResultSet getAccountHistory(int accountNumber) throws SQLException {
		String query = "SELECT * FROM transaction where account_action_idFk = " + accountNumber;
		System.out.println(query);
		ResultSet rs = db.retriveData(query);
		return rs;
	}

	public boolean transferAmount(int firstAccountNumber, int secondAccountNumber, Database db2,
			Connection connection) {
		// TODO Auto-generated method stub

		return false;
	}

	public AccountModel authenticateUser(AccountModel accountDetails) throws SQLException {

		if ((accountDetails.getAccountNumber() == adminAccountNumber)
				&& (accountDetails.getAccountPin() == adminAccountPin)) {

			accountDetails.setAccountType(0);
			accountDetails.setId(0);
			sessionService.setSession(accountDetails);
			return accountDetails;

		} else {
			String query = "SELECT * FROM account WHERE account_number = " + accountDetails.getAccountNumber();
			ResultSet rs = db.retriveData(query);
			if (rs.next() == false) {
				return null;
			}

			accountDetails.setAccountType(1);
			accountDetails.setId(getIdFromResultSet(rs));
			sessionService.setSession(accountDetails);
			return accountDetails;
		}

	}

	public int getIdFromResultSet(ResultSet rs) throws SQLException {
		int id = 0;
		while (rs.next()) {
			id = rs.getInt("id");
		}
		return id;
	}

	public float getAccountDetails(TransactionModel transactionModel) throws SQLException {
		String query = "SELECT current_balance FROM account WHERE account_number = "
				+ transactionModel.getTransactionAccount();
		ResultSet rs = db.retriveData(query);
		while (rs.next()) {
			amount = rs.getInt("current_balance");
		}
		return amount;
	}

	public float getAccountDetails(int accountNumber) throws SQLException {
		String query = "SELECT current_balance FROM account WHERE account_number = " + accountNumber;
		ResultSet rs = db.retriveData(query);
		while (rs.next()) {
			amount = rs.getInt("current_balance");
		}
		return amount;
	}

}
