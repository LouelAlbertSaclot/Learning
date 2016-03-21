package com.banking.view.dialogs;

import java.awt.Frame;

@SuppressWarnings("serial")
public class JD_GenerateReport extends javax.swing.JDialog
{
	public JD_GenerateReport(Frame parent, String report)
	{
		super(parent);
		
		getContentPane().setLayout(null);
		setSize(455,367);
		setVisible(false);
		
		getContentPane().add(JScrollPane);
		JScrollPane.setBounds(24,24,358,240);
		JScrollPane.getViewport().add(JTextArea);
		JTextArea.setBounds(0,0,335,237);
		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);
		
		JTextArea.append(report);
	
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	javax.swing.JScrollPane JScrollPane = new javax.swing.JScrollPane();
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
