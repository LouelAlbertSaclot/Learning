package com.banking.main;

import javax.swing.UIManager;

import com.banking.view.BankApplicationForm;

public class BANK
{
	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	public static void main(String args[])
	{
		try
		{
			try
			{
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e)
			{
			}

			(new BankApplicationForm()).setVisible(true);
		} catch (Throwable t)
		{
			t.printStackTrace();
			System.exit(1);
		}
	}

}
