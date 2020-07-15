package com.cleanarchitecture.todos.api.core.usecases;

public abstract class UseCaseOutputValues<O> {
	public O outputObject;
	public abstract void setOutPutObject(O outputObject);
}
