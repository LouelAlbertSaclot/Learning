package com.creditcard.view;

import java.awt.BorderLayout;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.creditcard.controller.CreditCardController;
import com.creditcard.model.transactions.TransactionDetails;
import com.management.account.IAccount;
import com.management.customer.ICustomer;

/**
 * A basic JFC based application.
 */
@SuppressWarnings("serial")
public class CCApplicationForm extends javax.swing.JFrame
{
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CCApplicationForm thisframe;
    private Object rowdata[];
    
    private CreditCardController cardContoller;
    
	public CCApplicationForm()
	{
		thisframe=this;
		cardContoller = new CreditCardController();
		
		setTitle("Credit-card processing Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(650, 325);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);

		JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
        newaccount=false;
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
		
		JButton_NewCCAccount.setText("Add Credit Card Account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,150,33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468,164,150,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,150,31);
		
		JButton_Addinterest.setText("Add Monthly Interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Addinterest.setBounds(468,134,150,31);

		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
	}
	
	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
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
			if (object == CCApplicationForm.this)
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
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				addInterest(event);
		}
	}
    
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.setVisible(true);

		if (ccac.isNewCustomer())
		{
			ICustomer customer = cardContoller.addCustomer(ccac.getCustomerDetails(), ccac.getCardDetails());
			IAccount acct = customer.search(ccac.getCardDetails().getCCardNum());
			
            // add row to table
            rowdata[0] = customer.getName();
            rowdata[1] = acct.getAcctNum();
            rowdata[2] = acct.getExpDate();
            rowdata[3] = acct.getAccountType();
            rowdata[4] = acct.getBalance();
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
        }
    }

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		JDialogGenBill billFrm = new JDialogGenBill(this, cardContoller.generateReport());
		billFrm.setBounds(450, 20, 420, 350);
		billFrm.setVisible(true);
	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0)
        {
            String name = (String) model.getValueAt(selection, 0);
            String acctNum = model.getValueAt(selection, 1).toString();
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(thisframe,name);
		    dep.setBounds(430, 15, 275, 140);
		    dep.setVisible(true);
		    
		    if (dep.isTransactionOk())
		    {
		    	Date date = new Date(System.currentTimeMillis());
		    	TransactionDetails trnDetails = new TransactionDetails(name, acctNum, dep.getAmount(), date.toString(), "D");
		    	cardContoller.sendTransaction(trnDetails);
		    }
    		
		    // compute new amount
		    double newAmount = cardContoller.search(name, "C").search(Integer.parseInt(acctNum)).getBalance();
		    model.setValueAt(String.valueOf(newAmount), selection, 4);
		}
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0)
        {
        	String name = (String) model.getValueAt(selection, 0);
            String acctNum = model.getValueAt(selection, 1).toString();

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(thisframe,name);
		    wd.setBounds(430, 15, 275, 140);
		    wd.setVisible(true);
		    
		    if (wd.isTransactionOk())
		    {
		    	Date date = new Date(System.currentTimeMillis());
		    	TransactionDetails trnDetails = new TransactionDetails(name, acctNum, wd.getAmount(), date.toString(), "C");
		    	cardContoller.sendTransaction(trnDetails);
		    }
		    
		    // compute new amount
		    double newAmount = cardContoller.search(name, "C").search(Integer.parseInt(acctNum)).getBalance();
		    model.setValueAt(String.valueOf(newAmount), selection, 4);
		}
	}
	
	void addInterest(java.awt.event.ActionEvent event)
	{
		  int value = JOptionPane.showConfirmDialog(JButton_Addinterest,
				  										"Are you sure you want to add interest to ALL accounts?",
													    	"Confirmation",	JOptionPane.YES_NO_OPTION);
		  if (value == 0)
		  {
			  cardContoller.addInterest();
			  model.getDataVector().removeAllElements();
			  
			  for (ICustomer customer : cardContoller.getCustomers())
			  {
				  for (IAccount acct : customer.getAccounts())
				  {
			            rowdata[0] = customer.getName();
			            rowdata[1] = acct.getAcctNum();
			            rowdata[2] = acct.getExpDate();
			            rowdata[3] = acct.getAccountType();
			            rowdata[4] = acct.getBalance();
			            model.addRow(rowdata);
			            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				  }
			  }
		  }
	}
}
