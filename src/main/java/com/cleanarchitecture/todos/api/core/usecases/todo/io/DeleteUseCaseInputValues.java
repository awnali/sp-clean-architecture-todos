package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;

public class DeleteUseCaseInputValues implements UseCaseInputValues{
	public String userId;
	public Long todoId;
	
	public DeleteUseCaseInputValues(String userId, Long todoId) {
		super();
		this.userId = userId;
		this.todoId = todoId;
	}
	
}
