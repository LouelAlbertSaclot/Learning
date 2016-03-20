package com.management.utils.collections;

import com.management.customer.ICustomer;

public class CustGenerateReport implements IAccumulatorFunctor<ICustomer, String>
{
	private String report = "";
	
	@Override
	public void doAction(ICustomer cust)
	{
		report += cust.generateReport();
	}

	@Override
	public String getValue()
	{
		return report;
	}

}
