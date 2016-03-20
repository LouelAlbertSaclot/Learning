package com.management.account;

public class Account extends AAccount
{
	public Account(int acctNum, double amount)
	{
		super(acctNum, amount);
	}

	@Override
	public String getAccountType()
	{
		return "A";
	}

	@Override
	public void addInterest()
	{
	}

	@Override
	public String getReport()
	{
		return "";
	}
}
