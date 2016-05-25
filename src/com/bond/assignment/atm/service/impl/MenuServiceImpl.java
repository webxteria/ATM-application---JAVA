package com.bond.assignment.atm.service.impl;

import java.sql.SQLException;

import com.bond.assignment.atm.model.SessionModel;
import com.bond.assignment.atm.view.Menu;

public interface MenuServiceImpl {

	void menuHandler(SessionModel currentUserAccountDetails, Menu view) throws SQLException;

}