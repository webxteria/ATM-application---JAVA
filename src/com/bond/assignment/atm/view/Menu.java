package com.bond.assignment.atm.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bond.assignment.atm.model.AccountModel;
import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.model.TransactionModel;

public class Menu {

	AccountModel accountModel;
	TransactionModel transactionModel;
	TransactionModel transactionDebitCredit;
	Scanner inputScanner = new Scanner(System.in);

	public void getWelcomeMessage() {
		System.out.println("Welcome to MY BANK");
	}

	public void askForAccountNumber() {
		System.out.println("Please Enter your Card Number");
	}

	public void askForPinNumber() {
		System.out.println("Please Enter your Pin Number");
	}

	public void askForCardNumber() {
		System.out.println("Please Enter Your Card Number");
	}

	public void askForAmount() {
		System.out.println("Please Enter Amount ");

	}

	public void renderAccountsList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Account Number \t Account Balance");
		while (rs.next()) {
			System.out.println(rs.getInt("account_number") + "\t\t\t" + rs.getFloat("current_balance"));
		}

	}

	public void renderAccountHistory(int accountNumber, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		while (rs.next()) {
			if (rs.getInt("account_action_idFk") == 440101) {
				System.out.println("Admin " + transactionType((rs.getInt("transaction_type_idFk"))) + " "
						+ rs.getFloat("amount") + " AED to " + rs.getInt("account_target_idFk"));
			} else {
				System.out.println(
						rs.getInt("account_target_idFk") + " " + transactionType((rs.getInt("transaction_type_idFk")))
								+ " " + rs.getFloat("amount") + " AED to " + rs.getInt("account_target_idFk"));
			}
			System.out.println("");
		}
	}

	public String transactionType(int transactionType) {
		if (transactionType == 1) {
			return "Deposit";
		} else if (transactionType == 2) {
			return "Credit";
		} else {
			return "Transfer";
		}

	}

	public int getAccountNumber() {
		askForAccountNumber();
		int accountNumber = inputScanner.nextInt();
		return accountNumber;
	}

	public AccountModel authenticationInput() {
		accountModel = new AccountModel();
		getWelcomeMessage();
		askForAccountNumber();
		accountModel.setAccountNumber(inputScanner.nextInt());
		askForPinNumber();
		accountModel.setAccountPin(inputScanner.nextInt());
		return accountModel;
	}

	public void renderMenu(int accountType) {

		if (accountType == 0) {
			System.out.println("Please Enter number of action");
			System.out.println(
					" 1. Check User Balance \n 2. Deposit Cash in User Account \n 3. Withdraw Balance of any user \n 4. Transfer Balance of user account \n 5. Check User Transaction  \n 6. Create Account \n 7. List of User");
		} else {
			System.out.println(
					" 1. Balance Check \n 2. Deposit Cash \n 3. Withdraw Cash \n 4. Transfer Balance of user account \n 5. Account History ");
		}

	}

	public void showBalance(float accountBalance) {
		System.out.println("Your account Balance is " + accountBalance);

	}

	public TransactionModel depositCash(SessionModel currentUserAccountDetails) {
		transactionModel = new TransactionModel();
		if (currentUserAccountDetails.getUserType() == 0) {
			askForAccountNumber();
			transactionModel.setTransactionAccount(inputScanner.nextInt());
		} else {
			transactionModel.setTransactionAccount(currentUserAccountDetails.getActiveUserAccount());
		}
		askForAmount();
		transactionModel.setTransactionAmount(inputScanner.nextFloat());
		return transactionModel;
	}

	public int createNewAccount() {
		askForAccountNumber();
		int accountNumber = inputScanner.nextInt();
		return accountNumber;
	}

	public void renderAccountGreeting(boolean createAccount) {
		System.out.println("Congratulation Your account successfuly Created ...! ");

	}

	public void renderDepositGreeting(boolean debitCreditTransaction) {
		System.out.println("Successfully deposit to your account");

	}

	public void renderWithdrawGreeting(boolean debitCreditTransaction) {
		System.out.println("Successfully Withdraw from your account");
	}

	public AccountModel getFirstAccount() {
		askForAccountNumber();
		AccountModel acc = new AccountModel();
		acc.setAccountNumber(inputScanner.nextInt());
		return acc;
	}

	public AccountModel getSecondAccount() {
		askForSecondAccountNumber();
		AccountModel secondAcc = new AccountModel();
		secondAcc.setAccountNumber(inputScanner.nextInt());
		return secondAcc;
	}

	public TransactionModel getAmount() {
		askForAmount();
		transactionDebitCredit = new TransactionModel();
		transactionDebitCredit.setTransactionAmount(inputScanner.nextFloat());
		return transactionDebitCredit;
	}

	private void askForSecondAccountNumber() {
		System.out.println("Enter other account Number");
	}

}
