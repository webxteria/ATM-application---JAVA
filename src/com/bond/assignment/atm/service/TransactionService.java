package com.bond.assignment.atm.service;

import java.sql.SQLException;

import com.bond.assignment.atm.dao.TransactionData;
import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.model.TransactionModel;
import com.bond.assignment.atm.service.impl.AccountServiceImpl;
import com.bond.assignment.atm.service.impl.TransactionServiceImpl;

public class TransactionService implements TransactionServiceImpl {
	TransactionData transactionData;
	AccountServiceImpl accountService;

	public TransactionService(TransactionData transactionData,AccountServiceImpl accountService) {
		this.transactionData = transactionData;
		this.accountService = accountService;
	}
	
	@Override
	public boolean debitCreditTransaction(SessionModel currentUserAccountDetails, TransactionModel transactionModel,
			String transactionType) throws SQLException {
		float currentBalance = accountService.updateAccount(transactionModel);
		float newBalance = 0;
		if (transactionType == "deposit") {
			newBalance = currentBalance + transactionModel.getTransactionAmount();
		} else {
			newBalance = currentBalance - transactionModel.getTransactionAmount();
			if (newBalance < 0) {
				System.out.println("You don't have Sufficient Balance");
				return false;
			}
		}
		accountService.updateNewBalance(transactionModel, newBalance);
		return transactionData.logTransaction(transactionModel, currentUserAccountDetails, transactionType);
	}

}
