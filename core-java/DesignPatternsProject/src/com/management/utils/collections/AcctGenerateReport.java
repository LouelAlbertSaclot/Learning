package com.management.utils.collections;

import com.management.account.IAccount;
import com.management.customer.ICustomer;

public class AcctGenerateReport implements IAccumulatorFunctor<IAccount, String>
{
	private String report = "";
	private ICustomer customer;
	
	public AcctGenerateReport(ICustomer customer)
	{
		this.customer = customer;
	}
	
	@Override
	public void doAction(IAccount acct)
	{
		report  = "Name = " + customer.getName() + "\r\n";
		report += "Address = " + customer.getStreet();
		report += ", " + customer.getCity(); 
		report += ", " + customer.getState();
		report += ", " + customer.getZip() + "\r\n";
		report += "Email = " + customer.getEmail() + "\r\n";
		report += acct.getReport() + "\r\n********************************************************\r\n";
	}

	@Override
	public String getValue()
	{
		return report;
	}

}
