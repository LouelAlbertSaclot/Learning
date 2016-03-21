package com.banking.model.customer;

import com.management.customer.ICustomerDetails;

public class PersonalDetails implements ICustomerDetails
{
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String birthdate;

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String getStreet()
	{
		return street;
	}

	@Override
	public void setStreet(String street)
	{
		this.street = street;
	}

	@Override
	public String getCity()
	{
		return city;
	}

	@Override
	public void setCity(String city)
	{
		this.city = city;
	}

	@Override
	public String getState()
	{
		return state;
	}

	@Override
	public void setState(String state)
	{
		this.state = state;
	}

	@Override
	public String getZip()
	{
		return zip;
	}

	@Override
	public void setZip(String zip)
	{
		this.zip = zip;
	}

	@Override
	public String getEmail()
	{
		return email;
	}

	@Override
	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String getBirthdate()
	{
		return birthdate;
	}

	@Override
	public void setBirthdate(String birthdate)
	{
		this.birthdate = birthdate;
	}

	@Override
	public int getNumOfEmployees()
	{
		return 0;
	}

	@Override
	public void setNumOfEmployees(int nr_of_employees)
	{ }
	
	@Override
	public String getCustomerType()
	{
		return "P";
	}
}
