package com.banking.view.dialogs;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.banking.model.transactions.TransactionDetails;
import com.banking.view.BankApplicationForm;
import com.management.account.IAccount;

@SuppressWarnings("serial")
public class JD_WithdrawTransaction extends javax.swing.JDialog
{
    private TransactionDetails details;
    private IAccount accnt;
    private String entryBy;
    private boolean isTransactionOk = false;

	public JD_WithdrawTransaction(BankApplicationForm parent, String name, IAccount accnt)
	{
		super(parent);
		this.accnt = accnt;
		this.entryBy = name;
		
		setTitle("Withdraw");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(277,134);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,36,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,156,20);
		getContentPane().add(JTextField_AMT);
		JTextField_AMT.setBounds(84,36,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,84,84,24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156,84,84,24);
	    JTextField_NAME.setText("" + accnt.getAcctNum());
	
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
	}

	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_AMT = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Calcel = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Calcel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		if (validateNumber(JTextField_AMT.getText()))
		{
			Double amount = Double.parseDouble(JTextField_AMT.getText());
			Date date = new Date(System.currentTimeMillis());

			details = new TransactionDetails(accnt, entryBy, amount, date.toString(),
					TransactionDetails.TRANSACTION_TYPE.WITHDRAW);
			isTransactionOk = true;
			dispose();
		} else
		{
			JOptionPane.showMessageDialog(this, "Invalid Number",
					"Invalid Number", JOptionPane.ERROR_MESSAGE);
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