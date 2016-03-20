package com.management.utils.collections;

import com.management.account.IAccount;

public class AcctAddInterest implements IFunctor<IAccount>
{
	@Override
	public void doAction(IAccount acct)
	{
		acct.addInterest();
	}

}
