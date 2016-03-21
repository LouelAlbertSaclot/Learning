package com.banking.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.banking.model.BankingFactory;
import com.banking.model.account.AccountDetails;
import com.banking.model.customer.PersonalDetails;
import com.banking.model.transactions.TransactionDetails;
import com.management.account.IAccount;
import com.management.controller.DefaultController;
import com.management.customer.ICustomer;
import com.management.customer.ICustomerDetails;
import com.management.transaction.ITransaction;
import com.management.transaction.TransactionFactory;

public class BankController
{
	private DefaultController defaultController = null;
	
	public BankController()
	{
		this.defaultController = DefaultController.getInstance();
		processData();
	}
	
	public void processData()
	{
		try
		{
			DataInputStream in = new DataInputStream( new FileInputStream("database.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(strLine, "|");
				List<String> data = new ArrayList<String>();
				while (st.hasMoreTokens())
				{
					data.add(st.nextToken());
				}
				
				if(data.size() > 0)
				{
					if (data.get(0).equals("P"))
					{
						createPersonal(data);
					}
					else
					{
						createCorporate(data);
					}
				}
			}
			
			in.close();
		} catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private void createCorporate(List<String> data)
	{

	}

	private void createPersonal(List<String> data)
	{
		PersonalDetails customerDetails = new PersonalDetails();
		customerDetails.setName(data.get(1));
		customerDetails.setStreet(data.get(2));
		customerDetails.setCity(data.get(3));
		customerDetails.setState(data.get(4));
		customerDetails.setZip(data.get(5));
		customerDetails.setEmail(data.get(6));
		customerDetails.setBirthdate(data.get(7));
		
		AccountDetails.ACCT_TYPE type;
		if (data.get(8).equals("S"))
		{
			type = AccountDetails.ACCT_TYPE.SAVINGS;
		}
		else
		{
			type = AccountDetails.ACCT_TYPE.CHECKING;
		}
		
		int acctNum = Integer.parseInt(data.get(9));
		AccountDetails acctDetails = new AccountDetails(acctNum, type);
		
		if (search(customerDetails.getName(), "P") == null)
		{
			ICustomer customer = addCustomer(customerDetails, acctDetails);
			
			Date date = new Date(System.currentTimeMillis());
			double amount = Double.parseDouble(data.get(10));
			TransactionDetails trn = new TransactionDetails(customer.search(acctNum),
					customer.getName(), amount, date.toString(), TransactionDetails.TRANSACTION_TYPE.DEPOSIT);
			sendTransaction(trn);
		}
	}

	public void addInterest()
	{
		defaultController.addInterest();
	}
	
	public String generateReport()
	{
		return defaultController.generateReport();
	}
	
	public List<ICustomer> getCustomers()
	{
		return defaultController.getCustomers();
	}
	
	public ICustomer search(String name, String type)
	{
		return defaultController.search(name, type);
	}
	
	public ICustomer addCustomer(ICustomerDetails details, AccountDetails acctDetails)
	{
		ICustomer customer = BankingFactory.createCustomer(details);
		IAccount account = BankingFactory.createAccount(acctDetails);
		
		return defaultController.addCustomer(customer, account);
	}
	
	public void sendTransaction(TransactionDetails details)
	{
		ITransaction transaction = TransactionFactory.createTransaction(
				details.getAccount(), details.getName(), details.getAmount(),
				details.getDate(), details.getTransactionType());
		
		defaultController.sendTransaction(transaction);
	}
}
