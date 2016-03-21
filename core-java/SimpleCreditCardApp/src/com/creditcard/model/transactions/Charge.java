package com.creditcard.model.transactions;

import java.math.BigDecimal;

import com.management.account.IAccount;
import com.management.transaction.ITransaction;
import com.management.transaction.Withdraw;

public class Charge extends Withdraw implements ITransaction
{

	public Charge(IAccount acct, String name, double amount, String date)
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
