package com.bond.assignment.atm.service.impl;

import java.sql.SQLException;

import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.model.TransactionModel;

public interface TransactionServiceImpl {

	boolean debitCreditTransaction(SessionModel currentUserAccountDetails, TransactionModel transactionModel,
			String transactionType) throws SQLException;

}