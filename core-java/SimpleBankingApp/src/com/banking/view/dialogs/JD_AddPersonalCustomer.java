package com.banking.view.dialogs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.banking.model.account.AccountDetails;
import com.banking.model.customer.PersonalDetails;
import com.banking.view.BankApplicationForm;
import com.management.customer.ICustomerDetails;

@SuppressWarnings("serial")
public class JD_AddPersonalCustomer extends javax.swing.JDialog
{
    private ICustomerDetails custDetails;
    private AccountDetails acctDetails;
    private boolean isNewCustomer = false;
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" +
    		"[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
	public JD_AddPersonalCustomer(BankApplicationForm parent)
	{
		super(parent);
		
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283,303);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,0,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,24,84,24);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,84,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,108,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12,132,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12,156,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12,180,48,24);
		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,204,96,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12,228,48,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,84,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84,132,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84,156,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84,108,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84,180,156,20);
		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(84,204,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84,228,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,264,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,264,84,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84,60,156,20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12,60,48,24);

		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();

	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Checking radio is clicked make this radio on 
		//and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Saving radio is clicked make this radio on 
		//and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	 
	}

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
		boolean correctData = true;
		custDetails = new PersonalDetails();

		custDetails.setName(JTextField_NAME.getText());
		custDetails.setStreet(JTextField_STR.getText());
		custDetails.setCity(JTextField_CT.getText());
		custDetails.setState(JTextField_ST.getText());
		custDetails.setZip(JTextField_ZIP.getText());
		custDetails.setEmail(JTextField_EM.getText());
		custDetails.setBirthdate(JTextField_BD.getText());
		
		if (!validateNumber(JTextField_ACNR.getText()))
		{
			correctData = false;
			JOptionPane.showMessageDialog(this, "Invalid Account Number", 
													"Invalid Account Number", 
														JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			int acct_nr = Integer.parseInt(JTextField_ACNR.getText());
			if (JRadioButton_Chk.isSelected())
			{
				acctDetails = new AccountDetails(acct_nr,
						AccountDetails.ACCT_TYPE.CHECKING);
			} else
			{
				acctDetails = new AccountDetails(acct_nr,
						AccountDetails.ACCT_TYPE.SAVINGS);
			}
		}
		
		if (!validateEmail(JTextField_EM.getText()))
		{
			correctData = false;
			JOptionPane.showMessageDialog(this, "Invalid Email", 
													"Invalid Email", 
														JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			custDetails.setEmail(JTextField_EM.getText());
		}
		
		if (correctData)
		{
			isNewCustomer = true;
			dispose();
		}
	}
	
	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		//make this frame invisible if Cancel button is clicked
        dispose();
	}

	public ICustomerDetails getCustomerDetails()
	{
		return custDetails;
	}
	
	public AccountDetails getAccountDetails()
	{
		return acctDetails;
	}
	
	public boolean isNewCustomer()
	{
		return isNewCustomer;
	}
	
	private boolean validateEmail(String email)
	{
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}
	
	private boolean validateNumber(String number)
	{
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(number);
		
		return matcher.matches();
	}
}