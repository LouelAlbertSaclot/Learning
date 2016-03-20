package com.management.account;

import java.util.List;
import java.util.Observer;

import com.management.customer.ICustomer;
import com.management.transaction.ITransaction;

public interface IAccount
{
	public void notifyCustomer();
	public void addListener(Observer o);
	public void addInterest();
	public void addTransaction(ITransaction transaction);
	public void setNewBalance(double amount);
	public void setOwner(ICustomer owner);
	public void setExpDate(String date);
	
	public int getAcctNum();
	public double getBalance();
	public double getPrevBalance();
	public String getReport();
	public String getAccountType();
	public ICustomer getOwner();
	public String getExpDate();
	
	public List<ITransaction> getTransactions();
	public void persist();
}
