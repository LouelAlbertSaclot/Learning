package com.creditcard.model.transactions;

import com.management.account.IAccount;
import com.management.transaction.ITransaction;
import com.management.transaction.TransactionFactory;

public class CCardTransactionFactory extends TransactionFactory
{
	public static ITransaction createTransaction(IAccount acct, String name, double amount, String date, String trnType)
	{
		if (trnType.equals("D"))
		{
			return new Deposit(acct, name, amount, date);
		}
		
		return new Charge(acct, name, amount, date);
	}
}
