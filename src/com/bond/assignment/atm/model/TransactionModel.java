package com.bond.assignment.atm.model;

public class TransactionModel {

	TransactionTypeModel transactionType;
	private int transactionStatus;
	private int transactionAccount;
	private float transactionAmount;

	public int getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(int transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getTransactionAccount() {
		return transactionAccount;
	}

	public void setTransactionAccount(int transactionAccount) {
		this.transactionAccount = transactionAccount;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
