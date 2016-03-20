package com.management.transaction;

import com.management.account.IAccount;

public class TransactionFactory 
{
	public static final int DEPOSIT_TYPE = 0;
	public static final int WITHDRAW_TYPE = 1;
	
	public static ITransaction createTransaction(IAccount acct, String name, double amount, String date, int type)
	{
		if (type == WITHDRAW_TYPE)
		{
			return new Withdraw(acct, name, amount, date);
		}
		
		return new Deposit(acct, name, amount, date); 
	}
}
