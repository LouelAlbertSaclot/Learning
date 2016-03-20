package com.management.transaction;

import java.math.BigDecimal;

import com.management.account.IAccount;
import com.management.transaction.ATransaction;
import com.management.transaction.ITransaction;

public class Withdraw extends ATransaction implements ITransaction
{

	public Withdraw(IAccount acct, String name, double amount, String date)
	{
		super(acct, name, amount, date);
	}

	@Override
	public void performTransaction()
	{
		BigDecimal balance = new BigDecimal(acct.getBalance());
		double new_balance = balance.subtract(new BigDecimal(amount)).doubleValue();
		
		acct.setNewBalance(new_balance);
	}

}
