package com.management.transaction;

import java.util.Stack;

import com.management.utils.DynamicLogProxy;

public class TransactionManager
{
	private Stack<ITransaction> executedTrans = new Stack<ITransaction>();
	
	public void sentTransaction(ITransaction transaction)
	{
		transaction = DynamicLogProxy.newInstance(transaction);
		transaction.execute();
		executedTrans.add(transaction);
	}
}
