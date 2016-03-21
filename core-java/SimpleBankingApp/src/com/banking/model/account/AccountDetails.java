package com.banking.model.account;

import com.management.account.IAccountDetails;

public class AccountDetails implements IAccountDetails
{
	private int acct_num;
	private int acct_type = 0;
	
	public static enum ACCT_TYPE { SAVINGS, CHECKING }
	
	public AccountDetails(int acct_num, ACCT_TYPE type)
	{
		this.acct_num = acct_num;
		
		switch (type) 
		{
			case CHECKING :
				acct_type = 1;
				break;
			default :
				acct_type = 0;
				break;
		}
	}
	
	@Override
	public int getAcctNum()
	{
		return acct_num;
	}
	
	@Override
	public int getAcctType()
	{
		return acct_type;
	}
}
