package com.banking.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.banking.controller.BankController;
import com.banking.model.account.AccountDetails;
import com.banking.model.transactions.TransactionDetails;
import com.banking.view.dialogs.JD_AddCorporateCustomer;
import com.banking.view.dialogs.JD_AddPersonalCustomer;
import com.banking.view.dialogs.JD_DepositTransaction;
import com.banking.view.dialogs.JD_GenerateReport;
import com.banking.view.dialogs.JD_WithdrawTransaction;
import com.management.account.IAccount;
import com.management.customer.ICustomer;
import com.management.customer.ICustomerDetails;

/**
 * A basic JFC based application.
 */
@SuppressWarnings("serial")
public class BankApplicationForm extends javax.swing.JFrame
{
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object rowdata[];
    
    BankApplicationForm thisframe;
    private BankController bankContoller;
    
	public BankApplicationForm()
	{
		thisframe = this;
		
		setTitle("Bank Account Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(585,325);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,309);
		
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Accountnr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        
        bankContoller = new BankController();
        List<ICustomer> customers = bankContoller.getCustomers();
        for (ICustomer c : customers)
        {
        	for (IAccount a : c.getAccounts())
        	{
        		refreshTable(c, a);
        	}
        }
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 419, 0);
		
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,31);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,31);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,134,96,31);
		
		JButton_GenReport.setText("Report");
		JPanel1.add(JButton_GenReport);
		JButton_GenReport.setBounds(468,164,96,31);

		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);

		JButton_PerAC.setActionCommand("jbutton");
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_GenReport.addActionListener(lSymAction);
	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_GenReport = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == BankApplicationForm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
			{
				JButtonExit_actionPerformed(event);
			}
			else if (object == JButton_PerAC)
			{
				addPersonalCustomer(event);
			}
			else if (object == JButton_CompAC)
			{
				addCorporateCustomer(event);
			}
			else if (object == JButton_Deposit)
			{
				deposit(event);
			}
			else if (object == JButton_Withdraw)
			{
				withdraw(event);
			}
			else if (object == JButton_Addinterest)
			{
				addInterest(event);
			}
			else if (object == JButton_GenReport)
			{
				generateReport(event);
			}
		}
	}
    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void addPersonalCustomer(java.awt.event.ActionEvent event)
	{
		JD_AddPersonalCustomer pac = new JD_AddPersonalCustomer(thisframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
		
		if (pac.isNewCustomer())
		{
			addCustomer(pac.getCustomerDetails(), pac.getAccountDetails());
        }
    }

	void addCorporateCustomer(java.awt.event.ActionEvent event)
	{
		JD_AddCorporateCustomer pac = new JD_AddCorporateCustomer(thisframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setVisible(true);
		
		if (pac.isNewCustomer())
		{
			addCustomer(pac.getCustomerDetails(), pac.getAccountDetails());
        }
	}
	
	void deposit(java.awt.event.ActionEvent event)
	{
	    // get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0)
		{
			String accnr = model.getValueAt(selection, 0).toString();
			String name = model.getValueAt(selection, 1).toString();
			String type = model.getValueAt(selection, 3).toString();
			IAccount accnt = bankContoller.search(name, type).search(Integer.parseInt(accnr));

			// Show the dialog for adding deposit amount for the current mane
			JD_DepositTransaction dep = new JD_DepositTransaction(thisframe, name, accnt);
			dep.setBounds(430, 15, 275, 140);
			dep.setVisible(true);
			
			if (dep.isTransactionOk())
			{
				sendRequest(dep.getDetails());
			}

			model.setValueAt(String.valueOf(accnt.getBalance()), selection, 5);
		}
	}

	void withdraw(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0)
        {
            String accnr = model.getValueAt(selection, 0).toString();
			String name = model.getValueAt(selection, 1).toString();
			String type = model.getValueAt(selection, 3).toString();
			IAccount accnt = bankContoller.search(name, type).search(Integer.parseInt(accnr));

		    //Show the dialog for adding withdraw amount for the current mane
		    JD_WithdrawTransaction wd = new JD_WithdrawTransaction(thisframe, name, accnt);
		    wd.setBounds(430, 15, 275, 140);
		    wd.setVisible(true);
		    
			if (wd.isTransactionOk())
			{
				sendRequest(wd.getDetails());
			}
			
			model.setValueAt(String.valueOf(accnt.getBalance()), selection, 5);
		}
	}
	
	void addInterest(java.awt.event.ActionEvent event)
	{
		  int value = JOptionPane.showConfirmDialog(JButton_Addinterest,
				  										"Are you sure you want to add interest to ALL accounts?",
													    	"Confirmation",	JOptionPane.YES_NO_OPTION);
		  if (value == 0)
		  {
			  bankContoller.addInterest();
			  model.getDataVector().removeAllElements();
			  
			  for (ICustomer customer : bankContoller.getCustomers())
			  {
				  for (IAccount acct : customer.getAccounts())
				  {
					  refreshTable(customer, acct);
				  }
			  }
		  }
	}
	
	void generateReport(java.awt.event.ActionEvent event)
	{
		JD_GenerateReport report = new JD_GenerateReport(this, bankContoller.generateReport());
		report.setBounds(450, 20, 420, 350);
		report.setVisible(true);
	}
	
	private void addCustomer(ICustomerDetails customerdetails, AccountDetails acctDetails)
	{
		ICustomer storedCust = bankContoller.addCustomer(customerdetails, acctDetails);
		IAccount storedAcct = storedCust.search(acctDetails.getAcctNum());
		
        // add row to table
		refreshTable(storedCust, storedAcct);
	}
	
	private void refreshTable(ICustomer customer, IAccount account)
	{
        rowdata[0] = account.getAcctNum();
        rowdata[1] = customer.getName();
        rowdata[2] = customer.getCity();
        rowdata[3] = customer.getCustomerType();
        rowdata[4] = account.getAccountType();
        rowdata[5] = account.getBalance();
        model.addRow(rowdata);
        
        JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}
	
	private void sendRequest(TransactionDetails details)
	{
		bankContoller.sendTransaction(details);
	}
}
