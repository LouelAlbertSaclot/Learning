package com.management.customer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.management.account.IAccount;
import com.management.utils.collections.AcctAddInterest;
import com.management.utils.collections.AcctCompare;
import com.management.utils.collections.AcctGenerateReport;
import com.management.utils.collections.AcctPersist;
import com.management.utils.collections.DataRecord;
import com.management.utils.collections.IAccumulatorFunctor;

public abstract class ACustomer implements ICustomer
{
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected String email;
	protected DataRecord<IAccount> accounts;
	
	public ACustomer(String name, String street, String city, String state,
			String zip, String email)
	{
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		
		accounts = new DataRecord<IAccount>();
	}
	
	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public String getStreet()
	{
		return street;
	}

	@Override
	public String getCity()
	{
		return city;
	}

	@Override
	public String getState()
	{
		return state;
	}

	@Override
	public String getZip()
	{
		return zip;
	}
	
	@Override
	public String getEmail()
	{
		return email;
	}

	@Override
	public boolean addAccount(IAccount acct)
	{
		IAccount a = search(acct.getAcctNum());
		if (a == null)
		{
			acct.setOwner(this);
			acct.persist();
			accounts.add(acct);
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Account already exists.",
										    "Duplicate Account", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	@Override
	public IAccount search(int acct_nr)
	{
		return accounts.search(new AcctCompare(acct_nr));
	}

	@Override
	public void removeAccount(IAccount acct)
	{
		accounts.remove(acct);
	}
	
	@Override
	public void addInterest()
	{
		accounts.doAction(new AcctAddInterest());
	}
	
	@Override
	public List<IAccount> getAccounts()
	{
		List<IAccount> list = new ArrayList<IAccount>();
		for (IAccount acct : accounts)
		{
			list.add(acct);
		}
		
		return list;
	}

	@Override
	public void sendEmailToCustomer()
	{
		// Mocking email for now
		JOptionPane.showMessageDialog(null, "Email notification was sent to " + getEmail(),
			    "Email Sent", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public String generateReport()
	{
		IAccumulatorFunctor<IAccount, String> repGen = new AcctGenerateReport(this);
		accounts.doAction(repGen);
		
		return repGen.getValue();
	}
	
	@Override
	public void persist()
	{
		accounts.doAction(new AcctPersist());
	}
	
	public abstract String getCustomerType();

}
