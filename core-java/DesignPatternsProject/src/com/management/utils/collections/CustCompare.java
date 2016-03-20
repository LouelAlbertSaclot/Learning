package com.management.utils.collections;

import com.management.customer.ICustomer;

public class CustCompare implements IPredicate<ICustomer>
{
	private String name;
	private String type;
	
	public CustCompare(String name, String type)
	{
		this.name = name;
		this.type = type;
	}
	
	@Override
	public boolean doCompare(ICustomer customer)
	{
		if ((customer.getName().equalsIgnoreCase(name))
				&& (customer.getCustomerType().equals(type)))
		{
			return true;
		}
		
		return false;
	}

}
