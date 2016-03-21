package com.creditcard.view;

import java.awt.Frame;

@SuppressWarnings("serial")
public class JDialogGenBill extends javax.swing.JDialog
{
    String billstring;
    
	public JDialogGenBill(Frame parent, String report)
	{
		super(parent);
		
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextArea);
		JTextArea.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		JTextArea.setText(report);
	
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea = new javax.swing.JTextArea();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}
}
