package com.management.customer;

import java.util.Observable;

import com.management.account.IAccount;

public class Personal extends ACustomer implements IPersonal 
{
	private String birthdate;
	
	public Personal(String name, String street, 
						String city, String state,
							String zip, String email, String birthdate)
	{
		super(name, street, city,  state, zip, email);
		this.birthdate = birthdate;
	}

	@Override
	public String getBirthDate()
	{
		return birthdate;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		if (o instanceof IAccount)
		{
			sendEmailToCustomer();
		}
	}

	@Override
	public String getCustomerType()
	{
		return "P";
	}

}
