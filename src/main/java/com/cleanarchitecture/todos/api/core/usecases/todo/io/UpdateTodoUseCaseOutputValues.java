package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

public class UpdateTodoUseCaseOutputValues extends UseCaseOutputValues<Todo> {

	public UpdateTodoUseCaseOutputValues(Todo todo) {
		this.setOutPutObject(todo);
	}

	@Override
	protected void setOutPutObject(Todo todo) {
		this.outputObject = todo;

	}

}
