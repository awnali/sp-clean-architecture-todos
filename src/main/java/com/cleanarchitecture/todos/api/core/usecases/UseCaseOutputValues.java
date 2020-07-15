package com.cleanarchitecture.todos.api.core.usecases;

public abstract class UseCaseOutputValues<O> {
	public O outputObject;

	protected abstract void setOutPutObject(O outputObject);

	public O getOutputObject() {
		return this.outputObject;
	}
}
