package com.management.transaction;

import java.math.BigDecimal;

import com.management.account.IAccount;
import com.management.transaction.ATransaction;
import com.management.transaction.ITransaction;

public class Deposit extends ATransaction implements ITransaction
{

	public Deposit(IAccount acct, String name, double amount, String date)
	{
		super(acct, name, amount, date);
	}

	@Override
	public void performTransaction()
	{
		BigDecimal balance = new BigDecimal(acct.getBalance());
		double new_balance = balance.add(new BigDecimal(amount)).doubleValue();
		
		acct.setNewBalance(new_balance);
	}

}
