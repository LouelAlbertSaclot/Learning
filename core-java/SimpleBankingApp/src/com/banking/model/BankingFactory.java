package com.banking.model;

import com.banking.model.account.CheckingAccount;
import com.banking.model.account.SavingsAccount;
import com.management.account.AccountFactory;
import com.management.account.IAccount;
import com.management.account.IAccountDetails;

public class BankingFactory extends AccountFactory
{
	private final static int CHECKING_TYPE = 1;
	
	public static IAccount createAccount(IAccountDetails acctDetails)
	{
		if (acctDetails.getAcctType() == CHECKING_TYPE)
		{
			return new CheckingAccount(acctDetails);
		}
		
		return new SavingsAccount(acctDetails);
	}
}