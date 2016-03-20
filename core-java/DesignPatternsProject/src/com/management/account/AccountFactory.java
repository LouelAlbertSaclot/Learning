package com.management.account;

import com.management.customer.Corporate;
import com.management.customer.ICustomerDetails;
import com.management.customer.ICustomer;
import com.management.customer.Personal;

public class AccountFactory
{
	public static ICustomer createCustomer(ICustomerDetails customerDetails)
	{
		if ((customerDetails.getCustomerType() != null)
				&& (customerDetails.getCustomerType().equalsIgnoreCase(ICustomerDetails.CORPORATE_TYPE)))
		{
			return new Corporate(customerDetails.getName(), 
									customerDetails.getStreet(),
										customerDetails.getCity(), 
											customerDetails.getState(),
												customerDetails.getZip(), 
													customerDetails.getEmail(),
														customerDetails.getNumOfEmployees());
		}
		
		return new Personal(customerDetails.getName(), 
								customerDetails.getStreet(),
									customerDetails.getCity(), 
										customerDetails.getState(),
											customerDetails.getZip(), 
												customerDetails.getEmail(), 
													customerDetails.getBirthdate());
	}
	
	public static IAccount createAccount(IAccountDetails accountDetails)
	{
		return new Account(0, 0);
	}
}
