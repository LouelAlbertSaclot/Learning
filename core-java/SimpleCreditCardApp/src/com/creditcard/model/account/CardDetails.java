package com.creditcard.model.account;

public class CardDetails
{
	private int ccardNum;
	private String expDate;
	private String type;
	
	public int getCCardNum()
	{
		return ccardNum;
	}
	public void setCCardNum(int ccardNum)
	{
		this.ccardNum = ccardNum;
	}
	public String getExpDate()
	{
		return expDate;
	}
	public void setExpDate(String expDate)
	{
		this.expDate = expDate;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
}
