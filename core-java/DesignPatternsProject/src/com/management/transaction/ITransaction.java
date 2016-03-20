package com.management.transaction;

import com.management.account.IAccount;

public interface ITransaction
{
	public IAccount getAccount();
	public String getName();
	public double getAmount();
	public String getDate();
	
	void execute();
}
