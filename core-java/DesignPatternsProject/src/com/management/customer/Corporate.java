package com.management.customer;

import java.util.Observable;

public class Corporate extends ACustomer implements ICorporate
{
	private int nr_of_employees;
	
	public Corporate(String name, String street, 
						String city, String state,
								String zip, String email, int numOfEmployees)
	{
		super(name, street, city,  state, zip, email);
		this.nr_of_employees = numOfEmployees;
	}

	@Override
	public int getNumEmployees()
	{
		return nr_of_employees;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		sendEmailToCustomer();
	}
	
	@Override
	public String getCustomerType()
	{
		return "C";
	}
}
