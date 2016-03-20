package com.management.utils.collections;

import com.management.customer.ICustomer;

public class CustAddInterest implements IFunctor<ICustomer>
{

	@Override
	public void doAction(ICustomer customer)
	{
		customer.addInterest();
	}

}
