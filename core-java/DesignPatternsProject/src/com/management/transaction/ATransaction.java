package com.management.transaction;

import com.management.account.IAccount;

public abstract class ATransaction implements ITransaction
{
	protected IAccount acct;
	protected String name;
	protected double amount;
	protected String date;
	
	public ATransaction(IAccount acct, String name, double amount, String date)
	{
		this.acct = acct;
		this.name = name;
		this.amount = amount;
		this.date = date;
	}
	
	public IAccount getAccount()
	{
		return acct;
	}

	public String getName()
	{
		return name;
	}

	public double getAmount()
	{
		return amount;
	}

	public String getDate()
	{
		return date;
	}

	@Override
	public void execute()
	{
		performTransaction();
		acct.addTransaction(this);
	}
	
	public abstract void performTransaction();
}
