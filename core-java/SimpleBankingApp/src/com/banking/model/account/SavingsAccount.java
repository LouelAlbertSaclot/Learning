package com.banking.model.account;

import java.math.BigDecimal;

import com.management.account.Account;
import com.management.account.IAccountDetails;

public class SavingsAccount extends Account
{
	private final String ACCT_TYPE = "S";
	private final static double INTEREST_RATE = 0.0325d;
	
	public SavingsAccount(IAccountDetails details)
	{
		super(details.getAcctNum(), 0);
	}

	@Override
	public void addInterest()
	{
		BigDecimal rate = new BigDecimal(INTEREST_RATE);
		BigDecimal curr_bal = new BigDecimal(getBalance());
		BigDecimal earnings = rate.multiply(curr_bal);
		
		setNewBalance(earnings.add(curr_bal).doubleValue());
	}

	@Override
	public String getReport()
	{
		String report = "";
		
		report  = "Account Number = "   + getAcctNum() + "\r\n";
		report += "Account Type = "     + getAccountType() + "\r\n";
		report += "Current Balance = " + getBalance() + "\r\n";
		report += "Previous Balance = "  + getPrevBalance();
		
		return report;
	}
	
	@Override
	public String getAccountType()
	{
		return ACCT_TYPE;
	}

	@Override
	public String toString()
	{
		return "SAVINGS";
	}

}
