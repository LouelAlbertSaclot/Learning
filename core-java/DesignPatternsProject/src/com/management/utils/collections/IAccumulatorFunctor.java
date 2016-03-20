package com.management.utils.collections;

public interface IAccumulatorFunctor<T, R> extends IFunctor<T>
{
	R getValue();
}
