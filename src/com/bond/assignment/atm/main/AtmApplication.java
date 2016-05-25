package com.bond.assignment.atm.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.service.AccountService;
import com.bond.assignment.atm.service.MenuServiceImp;
import com.bond.assignment.atm.service.TransactionService;
import com.bond.assignment.atm.service.impl.AccountServiceImpl;
import com.bond.assignment.atm.service.impl.MenuServiceImpl;
import com.bond.assignment.atm.view.Menu;

public class AtmApplication {
	private static AccountServiceImpl accountService = new AccountService();

	public static void main(String[] args) throws SQLException {

		MenuServiceImpl menuService = new MenuServiceImp(new Scanner(System.in), accountService,
				new TransactionService());
		Menu view = new Menu();

		SessionModel currentUserAccount = accountService.authenticateUser(view);
		menuService.menuHandler(currentUserAccount, view);
	}

}
