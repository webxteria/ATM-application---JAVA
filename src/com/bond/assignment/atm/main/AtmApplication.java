package com.bond.assignment.atm.main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bond.assignment.atm.dao.TransactionData;
import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.service.AccountService;
import com.bond.assignment.atm.service.MenuService;
import com.bond.assignment.atm.service.TransactionService;
import com.bond.assignment.atm.service.impl.AccountServiceImpl;
import com.bond.assignment.atm.service.impl.MenuServiceImpl;
import com.bond.assignment.atm.view.Menu;

public class AtmApplication {
	private static TransactionData transactionData;
	private static AccountServiceImpl accountServiceImpl;

	public static void main(String[] args) throws SQLException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bond/assignment/atm/beans/AtmApplicationBean.xml");

		transactionData = (TransactionData) context.getBean("transactionData");
		accountServiceImpl = (AccountService) context.getBean("accountService");

		MenuServiceImpl menuService = new MenuService(new Scanner(System.in), accountServiceImpl,
				new TransactionService(transactionData, accountServiceImpl));

		Menu view = new Menu();

		SessionModel currentUserAccount = accountServiceImpl.authenticateUser(view);
		menuService.menuHandler(currentUserAccount, view);
	}
}
