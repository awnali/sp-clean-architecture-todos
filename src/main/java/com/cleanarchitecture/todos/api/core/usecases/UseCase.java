package com.cleanarchitecture.todos.api.core.usecases;

public interface UseCase<I extends UseCaseInputValues, O extends UseCaseOutputValues<?>> {
	public O execute(I inputValues) throws Exception;
}