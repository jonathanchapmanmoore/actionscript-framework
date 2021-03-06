/*===========================================================================
|                                         
|                     Copyright 1994-97 Macromedia, Inc. 
|                                         
|      This material is the confidential trade secret and proprietary  
|      information of Macromedia, Inc.  It may not be reproduced, used,
|      sold or transferred to any third party without the prior written
|      consent of Macromedia, Inc.  All rights reserved.
|
|==========================================================================*/

//package com.macromedia.flash;

/*
	A basic extension of the java.awt.Dialog class
 */

import java.awt.*;

import symantec.itools.awt.FormattedTextField;
import symantec.itools.awt.ComboBox;
public class ZoomDialog extends Dialog
{
    Frame parent;
	public ZoomDialog(Frame parent, boolean modal)
	{
		super(parent, modal);
		this.parent = parent;

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setLayout(null);
		setVisible(false);
		setSize(insets().left + insets().right + 430,insets().top + insets().bottom + 270);
		setBackground(new Color(12632256));
		ftfLeft = new symantec.itools.awt.FormattedTextField();
		ftfLeft.setBounds(insets().left + 206,insets().top + 36,102,19);
		add(ftfLeft);
		ftfLeft.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		ftfTop = new symantec.itools.awt.FormattedTextField();
		ftfTop.setBounds(insets().left + 206,insets().top + 66,102,19);
		add(ftfTop);
		ftfTop.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		ftfRight = new symantec.itools.awt.FormattedTextField();
		ftfRight.setBounds(insets().left + 206,insets().top + 96,102,19);
		add(ftfRight);
		ftfRight.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		ftfBottom = new symantec.itools.awt.FormattedTextField();
		ftfBottom.setBounds(insets().left + 206,insets().top + 126,102,19);
		add(ftfBottom);
		ftfBottom.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		buOK = new java.awt.Button();
		buOK.setActionCommand("button");
		buOK.setLabel("OK");
		buOK.setBounds(insets().left + 142,insets().top + 192,62,26);
		buOK.setBackground(new Color(12632256));
		add(buOK);
		buCancel = new java.awt.Button();
		buCancel.setActionCommand("button");
		buCancel.setLabel("Cancel");
		buCancel.setBounds(insets().left + 226,insets().top + 192,62,26);
		buCancel.setBackground(new Color(12632256));
		add(buCancel);
		label1 = new java.awt.Label("Left");
		label1.setBounds(insets().left + 122,insets().top + 36,76,19);
		label1.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(label1);
		label2 = new java.awt.Label("Top");
		label2.setBounds(insets().left + 122,insets().top + 66,76,19);
		label2.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(label2);
		label3 = new java.awt.Label("Right");
		label3.setBounds(insets().left + 122,insets().top + 96,76,19);
		label3.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(label3);
		label4 = new java.awt.Label("Bottom");
		label4.setBounds(insets().left + 122,insets().top + 126,76,19);
		label4.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(label4);
		setTitle("Zoom Rect");
		//}}

		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		buOK.addActionListener(lSymAction);
		buCancel.addActionListener(lSymAction);
		//}}
	}
	
	public void addNotify()
	{
  	    // Record the size of the window prior to calling parents addNotify.
	    Dimension d = getSize();

		super.addNotify();

		if (fComponentsAdjusted)
			return;

		// Adjust components according to the insets
		setSize(insets().left + insets().right + d.width, insets().top + insets().bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++)
		{
			Point p = components[i].getLocation();
			p.translate(insets().left, insets().top);
			components[i].setLocation(p);
		}
		fComponentsAdjusted = true;
	}

    // Used for addNotify check.
	boolean fComponentsAdjusted = false;


	public ZoomDialog(Frame parent, String title, boolean modal)
	{
		this(parent, modal);
		setTitle(title);
	}

	public synchronized void show()
	{
		Rectangle bounds = getParent().bounds();
		Rectangle abounds = bounds();

		move(bounds.x + (bounds.width - abounds.width)/ 2,
			 bounds.y + (bounds.height - abounds.height)/2);

		super.show();
	}

	//{{DECLARE_CONTROLS
	symantec.itools.awt.FormattedTextField ftfLeft;
	symantec.itools.awt.FormattedTextField ftfTop;
	symantec.itools.awt.FormattedTextField ftfRight;
	symantec.itools.awt.FormattedTextField ftfBottom;
	java.awt.Button buOK;
	java.awt.Button buCancel;
	java.awt.Label label1;
	java.awt.Label label2;
	java.awt.Label label3;
	java.awt.Label label4;
	//}}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == ZoomDialog.this)
				Dialog1_WindowClosing(event);
		}
	}
	
	void Dialog1_WindowClosing(java.awt.event.WindowEvent event)
	{
		hide();
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == buOK)
				buOK_Action(event);
			else if (object == buCancel)
				buCancel_Action(event);
		}
	}

	void buOK_Action(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
		dispose();
		int x =  Integer.valueOf(ftfLeft.getText()).intValue();
		int y =  Integer.valueOf(ftfTop.getText()).intValue();
		int width =  Integer.valueOf(ftfRight.getText()).intValue();
		int height =  Integer.valueOf(ftfBottom.getText()).intValue();
        
        ((FlashApp) parent).flashPlayer.SetZoomRect(x, y, width, height);		
        Graphics g = parent.getGraphics();
        Rectangle r = parent.bounds();
        g.clearRect(0, 0, r.width, r.height);
        ((FlashApp) parent).flashPlayer.Update(g);
	}

	void buCancel_Action(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
		dispose();
	}
}
