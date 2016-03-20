package com.management.customer;


public interface ICustomerDetails
{
	public final static String PERSONAL_TYPE = "P";
	public final static String CORPORATE_TYPE = "C";
	
	public String getName();
	public void setName(String name);
	
	public String getStreet();
	public void setStreet(String street);
	
	public String getCity();
	public void setCity(String city);
	
	public String getState();
	public void setState(String state);
	
	public String getZip();
	public void setZip(String zip);
	
	public String getEmail();
	public void setEmail(String email);
	
	public String getBirthdate();
	public void setBirthdate(String birthdate);
	
	public int getNumOfEmployees();
	public void setNumOfEmployees(int nr_of_employees);
	
	public String getCustomerType();
}
