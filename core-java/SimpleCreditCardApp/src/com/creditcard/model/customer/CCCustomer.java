package com.creditcard.model.customer;

import com.management.customer.Personal;

public class CCCustomer extends Personal
{

	public CCCustomer(String name, String street, String city, String state,
			String zip, String email, String birthdate)
	{
		super(name, street, city, state, zip, email, birthdate);
	}

	@Override
	public String getCustomerType()
	{
		return "C";
	}
}
