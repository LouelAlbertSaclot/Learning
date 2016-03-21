package com.creditcard.model;

import com.creditcard.model.account.Bronze;
import com.creditcard.model.account.CardDetails;
import com.creditcard.model.account.Gold;
import com.creditcard.model.account.Silver;
import com.creditcard.model.customer.CCCustomer;
import com.management.account.AccountFactory;
import com.management.account.IAccount;
import com.management.customer.ICustomer;
import com.management.customer.ICustomerDetails;

public class CCardFactory extends AccountFactory
{
	public static ICustomer createCustomer(ICustomerDetails customerDetails)
	{
		return new CCCustomer(customerDetails.getName(), 
								customerDetails.getStreet(),
									customerDetails.getCity(), 
										customerDetails.getState(),
											customerDetails.getZip(), 
												customerDetails.getEmail(), 
													customerDetails.getBirthdate());
	}

	public static IAccount createAccount(CardDetails cardDetails)
	{
		IAccount account;
		if (cardDetails.getType().equals("G"))
		{
			account = new Gold(cardDetails.getCCardNum(), 0);
		}
		else if (cardDetails.getType().equals("S"))
		{
			account = new Silver(cardDetails.getCCardNum(), 0);
		}
		else
		{
			account = new Bronze(cardDetails.getCCardNum(), 0);
		}
		
		account.setExpDate(cardDetails.getExpDate());
		return account;
	}

}
