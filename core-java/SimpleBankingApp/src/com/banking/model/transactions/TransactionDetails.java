package com.banking.model.transactions;

import com.management.account.IAccount;

public class TransactionDetails
{
	private IAccount acct;
	private String name;
	private double amount;
	private String date;
	private int trans_type;
	
	public static enum TRANSACTION_TYPE { DEPOSIT, WITHDRAW }
	
	public TransactionDetails(IAccount acct, String name, double amount, String date, TRANSACTION_TYPE type)
	{
		this.acct = acct;
		this.name = name;
		this.amount = amount;
		this.date = date;
		
		switch (type) 
		{
			case WITHDRAW :
				trans_type = 1;
				break;
			default:
				trans_type = 0;
				break;
		}
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

	public int getTransactionType()
	{
		return trans_type;
	}
	
}
