package com.creditcard.model.account;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import com.creditcard.model.transactions.Charge;
import com.creditcard.model.transactions.Deposit;
import com.management.account.Account;
import com.management.transaction.ITransaction;

public class Silver extends Account
{
	private final BigDecimal MP = new BigDecimal(0.14d);
	private final BigDecimal MI = new BigDecimal(0.18d);
	
	public Silver(int acctNum, double amount)
	{
		super(acctNum, amount);
	}

	@Override
	public String getAccountType()
	{
		return "S";
	}

	@Override
	public void addInterest()
	{
		BigDecimal curr_bal = new BigDecimal(getBalance());
		BigDecimal interest = MI.multiply(curr_bal);
		
		setNewBalance(curr_bal.add(interest).doubleValue());
	}

	@Override
	public String getReport()
	{
		double totalCharges = getTotalCharges();
		double totalCredits = getTotalCredits();
		
		BigDecimal prevBal = new BigDecimal(getBalance());
		BigDecimal part1 = prevBal.subtract(new BigDecimal(totalCredits)).add(new BigDecimal(totalCharges));
		BigDecimal part2 = MI.multiply(prevBal.subtract(new BigDecimal(totalCredits)));
		
		double new_bal = part1.add(part2).doubleValue();
		setNewBalance(new_bal);
		
		double due = MP.multiply(new BigDecimal(new_bal)).doubleValue();
		
		String report = "";
		report  = "Account Number = "   + getAcctNum() + "\r\n";
		report += "Account Type = "     + getAccountType() + "\r\n";
		report += "Last Month Balance = " + getBalance() + "\r\n";
		report += "Total Charges = "  + totalCharges + "\r\n";
		report += "Total Credits = "  + totalCredits + "\r\n";
		report += "New Balance = "  + new_bal + "\r\n";
		report += "Total Due = "  + due;
		
		return report;
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
	
	@Override
	public void persist()
	{
		JOptionPane.showMessageDialog(null, "Data Persisted Simulation",
				"Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private double getTotalCharges()
	{
		double total = 0d;
		for (ITransaction t : getTransactions())
		{
			if (t instanceof Charge)
			{
				total += t.getAmount();
			}
		}
			
		return total;
	}
	
	private double getTotalCredits()
	{
		double total = 0d;
		for (ITransaction t : getTransactions())
		{
			if (t instanceof Deposit)
			{
				total += t.getAmount();
			}
		}
			
		return total;
	}
}
