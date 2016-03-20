package com.management.utils.collections;

import com.management.customer.ICustomer;

public class CustPersist implements IFunctor<ICustomer>
{

	@Override
	public void doAction(ICustomer customer)
	{
		customer.persist();
	}

}
