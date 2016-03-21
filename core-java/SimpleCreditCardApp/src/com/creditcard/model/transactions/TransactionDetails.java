package com.creditcard.model.transactions;


public class TransactionDetails
{
	private String name;
	private double amount;
	private String date;
	private String trans_type;
	private String acctNum;
	
	public TransactionDetails(String name, String acctNum, double amount, String date, String type)
	{
		this.name = name;
		this.amount = amount;
		this.date = date;
		this.trans_type = type;
		this.acctNum = acctNum;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAcctNum()
	{
		return acctNum;
	}
	
	public double getAmount()
	{
		return amount;
	}

	public String getDate()
	{
		return date;
	}

	public String getTransactionType()
	{
		return trans_type;
	}
	
}
