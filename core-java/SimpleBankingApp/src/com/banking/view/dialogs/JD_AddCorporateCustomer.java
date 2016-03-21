package com.banking.view.dialogs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.banking.model.account.AccountDetails;
import com.banking.model.customer.CorporateDetails;
import com.banking.view.BankApplicationForm;
import com.management.customer.ICustomerDetails;

@SuppressWarnings("serial")
public class JD_AddCorporateCustomer extends javax.swing.JDialog
{
    private ICustomerDetails custDetails;
    private AccountDetails acctDetails;
    private boolean isNewCustomer = false;
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" +
    		"[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
	public JD_AddCorporateCustomer(BankApplicationForm parent)
	{
		super(parent);

		setTitle("Add compamy account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(298,339);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,96,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,120,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12,144,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12,168,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12,192,48,24);
		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,216,96,24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12,240,48,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(120,96,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(120,144,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(120,168,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(120,120,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(120,192,156,20);
		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,216,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(120,240,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,276,84,24);
		JButton_Calcel.setText("Cancel");
		JButton_Calcel.setActionCommand("Cancel");
		getContentPane().add(JButton_Calcel);
		JButton_Calcel.setBounds(156,276,84,24);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12,72,48,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(120,72,156,20);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Calcel.addActionListener(lSymAction);
	}


	//{{DECLARE_CONTROLS
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
	javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
	javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	//}}


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
		boolean correctData = true;
		custDetails = new CorporateDetails();

		custDetails.setName(JTextField_NAME.getText());
		custDetails.setStreet(JTextField_STR.getText());
		custDetails.setCity(JTextField_CT.getText());
		custDetails.setState(JTextField_ST.getText());
		custDetails.setZip(JTextField_ZIP.getText());
		
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
		
		if (!validateNumber(JTextField_NoOfEmp.getText()))
		{
			correctData = false;
			JOptionPane.showMessageDialog(this, "Invalid Number of Employees", 
					"Invalid Number", 
						JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			custDetails.setNumOfEmployees(Integer.parseInt(JTextField_NoOfEmp.getText()));
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