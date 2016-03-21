package com.banking.view.dialogs;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.banking.model.transactions.TransactionDetails;
import com.banking.view.BankApplicationForm;
import com.management.account.IAccount;

@SuppressWarnings("serial")
public class JD_DepositTransaction extends javax.swing.JDialog
{
	private TransactionDetails details;
    private IAccount accnt;
    private String entryBy;
    private boolean isTransactionOk = false;
    
	public JD_DepositTransaction(BankApplicationForm parent, String name, IAccount accnt)
	{
		super(parent);
		this.accnt = accnt;
		this.entryBy = name;
		
		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
	    JTextField_NAME.setText("" + accnt.getAcctNum());
	    
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		if (validateNumber(JTextField_Deposit.getText()))
		{
			Double amount = Double.parseDouble(JTextField_Deposit.getText());
			Date date = new Date(System.currentTimeMillis());
			
			details = new TransactionDetails(accnt, entryBy, amount, date.toString() , 
												TransactionDetails.TRANSACTION_TYPE.DEPOSIT);
			isTransactionOk = true;
	        dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Invalid Number", 
													"Invalid Number", 
														JOptionPane.ERROR_MESSAGE);
		}
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

	public TransactionDetails getDetails()
	{
		return details;
	}
	
	public boolean isTransactionOk()
	{
		return isTransactionOk;
	}
	
	private boolean validateNumber(String number)
	{
		Pattern pattern = Pattern.compile("[0-9]*.[0-9]*");
		Matcher matcher = pattern.matcher(number);
		
		return matcher.matches();
	}
}