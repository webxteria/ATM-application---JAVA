package com.bond.assignment.atm.service;

public class ValidatorService {

	public boolean validateNullPointerValidator(Object object) {
		if (object == null) {
			return false;
		} else {
			return true;
		}
	}

}
