package com.management.controller;

public final class DefaultController extends AbstractController
{
	private static DefaultController instance = new DefaultController();
	
	private DefaultController() {}
	public final static DefaultController getInstance()
	{
		if (instance == null)
		{
			instance = new DefaultController();
		}
		
		return instance;
	}
}
