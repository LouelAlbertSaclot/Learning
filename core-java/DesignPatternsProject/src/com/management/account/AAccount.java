package com.management.account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.management.customer.Corporate;
import com.management.customer.ICustomer;
import com.management.customer.Personal;
import com.management.transaction.ITransaction;

public abstract class AAccount extends Observable implements IAccount
{
	protected int acctNum;
	protected double curr_amount;
	protected double prev_amount;
	protected List<ITransaction> transactions;
	protected ICustomer owner;
	protected String expDate;
	
	public AAccount(int acctNum, double amount)
	{
		this.acctNum = acctNum;
		this.curr_amount = amount;
		
		transactions = new ArrayList<ITransaction>();
	}
	
	@Override
	public int getAcctNum()
	{
		return acctNum;
	}
	
	@Override
	public double getBalance()
	{
		return roundTwoDecimals(curr_amount);
	}
	
	@Override
	public double getPrevBalance()
	{
		return roundTwoDecimals(prev_amount);
	}
	
	@Override
	public void setNewBalance(double amount)
	{
		prev_amount = curr_amount;
		curr_amount = amount;
	}
	
	@Override
	public List<ITransaction> getTransactions()
	{
		return transactions;
	}
	
	@Override
	public void addTransaction(ITransaction transaction)
	{
		if ((getBalance() < 0)
				|| (transaction.getAmount() > 400))
		{
			notifyCustomer();
		}
		
		transactions.add(transaction);
	}
	
	@Override
	public void addListener(Observer o)
	{
		addObserver(o);
	}
	
	@Override
	public void notifyCustomer()
	{
		setChanged();
		notifyObservers();
	}
	
	@Override
	public ICustomer getOwner()
	{
		return owner;
	}

	@Override
	public void setOwner(ICustomer owner)
	{
		this.owner = owner;
	}
	
	@Override
	public void persist()
	{
		try
		{
			String out = setCustomerDetails(getOwner()) + "|" + setAccountDetails(this) + "\n";
			
			PrintWriter database = new PrintWriter(new BufferedWriter(new FileWriter("database.txt", true)));
			database.println(out);
			database.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void setExpDate(String date)
	{
		this.expDate = date;
	}
	
	@Override
	public String getExpDate()
	{
		return expDate;
	}
	
	private double roundTwoDecimals(double d)
	{
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}
	
	private String setCustomerDetails(ICustomer customer)
	{
		String data = customer.getCustomerType() + "|";
		data += customer.getName() + "|";
		data += customer.getStreet() + "|";
		data += customer.getCity() + "|";
		data += customer.getState() + "|";
		data += customer.getZip() + "|";
		data += customer.getEmail() + "|";
		
		
		if (customer.getCustomerType() ==  "P")
		{
			data += ((Personal)customer).getBirthDate();
		}
		else
		{
			data += ((Corporate)customer).getNumEmployees();
		}
		
		return data;
	}
	
	private String setAccountDetails(IAccount account)
	{
		String data = account.getAccountType() + "|";
		data += account.getAcctNum() + "|";
		data += account.getBalance();
		
		return data;
	}

	public abstract void addInterest();
	public abstract String getReport();
}
