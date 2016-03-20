package com.management.utils.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataRecord<E> implements Iterable<E>
{
	private Set<E> collection = new HashSet<E>();
	
	public void add(E e)
	{
		collection.add(e);
	}
	
	public boolean remove(E e)
	{
		return collection.remove(e);
	}
	
	public int size()
	{
		return collection.size();
	}
	
	public Iterator<E> iterator()
	{
		return collection.iterator();
	}
	
	public E search(IPredicate<E> p)
	{
		E elem = null;
		for (E e : collection)
		{
			if (p.doCompare(e))
			{
				elem = e;
				break;
			}
		}
		
		return elem;
	}
	
	public void doAction(IFunctor<E> func)
	{
		for (E e : collection)
		{
			func.doAction(e);
		}
	}
}
