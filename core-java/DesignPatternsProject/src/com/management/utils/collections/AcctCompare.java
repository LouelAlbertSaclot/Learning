package com.management.utils.collections;

import com.management.account.IAccount;

public class AcctCompare implements IPredicate<IAccount>
{
	private int acct_nr;

	public AcctCompare(int acct_nr)
	{
		this.acct_nr = acct_nr;
	}

	@Override
	public boolean doCompare(IAccount acct)
	{
		if (acct.getAcctNum() == acct_nr)
		{
			return true;
		}
		
		return false;
	}

}
