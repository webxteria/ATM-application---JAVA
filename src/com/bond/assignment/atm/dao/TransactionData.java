package com.bond.assignment.atm.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bond.assignment.atm.model.AccountModel;
import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.model.TransactionModel;

public class TransactionData {
	private int transactionId;
	private int transactionType;
	private PreparedStatement prepareStatement;
	private final int transfer = 1;
	private final int deposit = 2;
	private final int withdraw = 3;
	Database db = new Database();
	SessionModel sessionModel = new SessionModel();

	public boolean logTransaction(TransactionModel transactionModel, SessionModel currentUserAccountDetails,
			String transactionType) throws SQLException {
		try {
			int transactionTypeId = 0;
			if (transactionType == "deposit") {
				transactionTypeId = 1;
			} else if (transactionType == "withdraw") {
				transactionTypeId = 2;
			}

			String query = "Insert into transaction(account_action_idFk,account_target_idFk,transaction_type_idFk,amount) values("
					+ currentUserAccountDetails.getActiveUserAccount() + "," + transactionModel.getTransactionAccount()
					+ "," + transactionTypeId + "," + transactionModel.getTransactionAmount() + ")";
			db.updateData(query);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean logTransaction(TransactionModel transactionModel, AccountModel currentUserAccountDetails,
			String transactionType) throws SQLException {
		try {
			int transactionTypeId = 0;
			if (transactionType == "deposit") {
				transactionTypeId = 1;
			} else if (transactionType == "withdraw") {
				transactionTypeId = 2;
			}

			String query = "Insert into transaction(account_action_idFk,account_target_idFk,transaction_type_idFk,amount) values("
					+ currentUserAccountDetails.getAccountNumber() + "," + transactionModel.getTransactionAccount()
					+ "," + transactionTypeId + "," + transactionModel.getTransactionAmount() + ")";
			db.updateData(query);
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
