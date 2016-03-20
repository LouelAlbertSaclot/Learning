package com.management.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicLogProxy implements InvocationHandler
{
	private Object obj = null;

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(final T obj)
	{
		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
											obj.getClass().getInterfaces(), 
												new DynamicLogProxy(obj));
	}

	private DynamicLogProxy(Object obj)
	{
		this.obj = obj;
	}

	@Override
	public Object invoke(Object arg0, Method m, Object[] args)
			throws Throwable
	{
		Object result;
		try
		{
			System.out.println(".....inside DynamicLogProxy!");
			result = m.invoke(obj, args);
		} 
		catch (Exception e)
		{
			throw new RuntimeException("unexpected invocation exception: "
					+ e.getMessage());
		} 
		finally
		{
			System.out.println(".....exiting DynamicLogProxy!");
		}
		
		return result;
	}

}
