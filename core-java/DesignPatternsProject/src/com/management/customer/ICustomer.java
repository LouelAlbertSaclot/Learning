package com.management.customer;

import java.util.List;
import java.util.Observer;

import com.management.account.IAccount;

public interface ICustomer extends Observer
{
	String getName();
	String getStreet();
	String getCity();
	String getState();
	String getZip();
	String getEmail();
	String getCustomerType();
	
	boolean addAccount(IAccount acct);
	void removeAccount(IAccount acct);
	void sendEmailToCustomer();
	void addInterest();
	void persist();
	
	List<IAccount> getAccounts();
	IAccount search(int acct_nr);
	String generateReport();
	
}
