package com.management.utils.collections;

import com.management.account.IAccount;

public class AcctPersist implements IFunctor<IAccount>
{

	@Override
	public void doAction(IAccount acct)
	{
		acct.persist();
	}

}
