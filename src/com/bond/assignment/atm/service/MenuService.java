package com.bond.assignment.atm.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.service.impl.AccountServiceImpl;
import com.bond.assignment.atm.service.impl.MenuServiceImpl;
import com.bond.assignment.atm.service.impl.TransactionServiceImpl;
import com.bond.assignment.atm.view.Menu;

public class MenuService implements MenuServiceImpl {

	private Scanner inputScanner;
	private AccountServiceImpl accountService;
	private TransactionServiceImpl transactionService;

	public MenuService(Scanner inputScanner, AccountServiceImpl accountService,
			TransactionServiceImpl transactionService) {
		super();
		this.inputScanner = inputScanner;
		this.accountService = accountService;
		this.transactionService = transactionService;
	}


	
	@Override
	public void menuHandler(SessionModel currentUserAccountDetails, Menu view) throws SQLException {
		view.renderMenu(currentUserAccountDetails.getUserType());
		int seletecOption = inputScanner.nextInt();
		switch (seletecOption) {
		case 1:
			view.showBalance(accountService.checkAccountBalance(view, currentUserAccountDetails));
			break;
		case 2:
			view.renderDepositGreeting(transactionService.debitCreditTransaction(currentUserAccountDetails,
					view.depositCash(currentUserAccountDetails), "deposit"));
			break;
		case 3:
			view.renderWithdrawGreeting(transactionService.debitCreditTransaction(currentUserAccountDetails,
					view.depositCash(currentUserAccountDetails), "withdraw"));
			break;
		case 7:
			view.renderAccountsList(accountService.accountsList());
			break;

		case 6:
			view.renderAccountGreeting(accountService.createAccount(view.createNewAccount()));
			break;
		case 5:
			int accountNumber = 0;
			if (currentUserAccountDetails.getUserType() == 0)
				accountNumber = view.getAccountNumber();
			else
				accountNumber = currentUserAccountDetails.getActiveUserAccount();
			view.renderAccountHistory(accountNumber, accountService.showAccountHistory(accountNumber));
			break;
		default:
			System.out.println("Invalid Number Entered ... !");
			menuHandler(currentUserAccountDetails, view);
		}

	}

}
