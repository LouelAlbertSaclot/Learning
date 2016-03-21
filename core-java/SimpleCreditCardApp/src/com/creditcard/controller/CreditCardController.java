package com.creditcard.controller;

import java.util.List;

import com.creditcard.model.CCardFactory;
import com.creditcard.model.account.CardDetails;
import com.creditcard.model.transactions.CCardTransactionFactory;
import com.creditcard.model.transactions.TransactionDetails;
import com.management.account.IAccount;
import com.management.controller.DefaultController;
import com.management.customer.ICustomer;
import com.management.customer.ICustomerDetails;
import com.management.transaction.ITransaction;

public class CreditCardController
{
	private DefaultController defaultController = DefaultController.getInstance();
	
	public ICustomer addCustomer(ICustomerDetails custDetails, CardDetails cardDetails)
	{
		return defaultController.addCustomer(CCardFactory.createCustomer(custDetails),
				CCardFactory.createAccount(cardDetails));
	}
	
	public void addInterest()
	{
		defaultController.addInterest();
	}
	
	public List<ICustomer> getCustomers()
	{
		return defaultController.getCustomers();
	}
	
	public ICustomer search(String name, String type)
	{
		return defaultController.search(name, type);
	}
	
	public void sendTransaction(TransactionDetails trnDetails)
	{
		int acctNum = Integer.parseInt(trnDetails.getAcctNum());
		
		ICustomer customer = defaultController.search(trnDetails.getName(), "C");
		IAccount account = customer.search(acctNum);
		
		ITransaction transaction = CCardTransactionFactory.createTransaction(
				account, trnDetails.getName(), trnDetails.getAmount(),
				trnDetails.getDate(), trnDetails.getTransactionType());

		defaultController.sendTransaction(transaction);
	}
	
	public String generateReport()
	{
		return defaultController.generateReport();
	}
}
