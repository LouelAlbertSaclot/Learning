package com.management.controller;

import java.util.ArrayList;
import java.util.List;

import com.management.account.IAccount;
import com.management.customer.ICustomer;
import com.management.transaction.ITransaction;
import com.management.transaction.TransactionManager;
import com.management.utils.collections.CustAddInterest;
import com.management.utils.collections.CustCompare;
import com.management.utils.collections.CustGenerateReport;
import com.management.utils.collections.CustPersist;
import com.management.utils.collections.DataRecord;
import com.management.utils.collections.IAccumulatorFunctor;

public abstract class AbstractController
{
	protected TransactionManager manager = new TransactionManager();
	protected DataRecord<ICustomer> customers = new DataRecord<ICustomer>();
	
	public ICustomer addCustomer(ICustomer c, IAccount account)
	{
		// Check if the Customer is already in the system. This is how the
		// one-to-many relationship of Customer and Account. This is also one of
		// the IOC capabilities of the framework.
		ICustomer customer = null;
		if (customers.size() > 0)
		{
			customer = search(c.getName(), c.getCustomerType());
		}
		
		if (customer != null)
		{
			// remove it first then re-add it later
			customers.remove(customer);
		}
		else
		{
			customer = c;
		}
		
		// validate and add account
		if (customer.addAccount(account))
		{
			account.addListener(customer);
			customers.add(customer);
		}
		
		// persist();
		return customer;
	}
	
	public void addInterest()
	{
		customers.doAction(new CustAddInterest());
	}
	
	public List<ICustomer> getCustomers()
	{
		List<ICustomer> list = new ArrayList<ICustomer>();
		for (ICustomer c : customers)
		{
			list.add(c);
		}
		
		return list;
	}
	
	public ICustomer search(String name, String type)
	{
		return customers.search(new CustCompare(name, type));
	}
	
	public void sendTransaction(ITransaction transaction)
	{
		manager.sentTransaction(transaction);
	}

	public String generateReport()
	{
		IAccumulatorFunctor<ICustomer, String> custGenRep = new CustGenerateReport();
		customers.doAction(custGenRep);
		
		return custGenRep.getValue();
	}
	
	public void persist()
	{
		customers.doAction(new CustPersist());
	}
}
