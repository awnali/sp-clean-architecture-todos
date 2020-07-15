package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

public class CreateTodoUseCaseOuputValues extends UseCaseOutputValues<Todo> {
	public Todo createdTodo;
	public CreateTodoUseCaseOuputValues(Todo createdTodo) {
		super();
		this.createdTodo = createdTodo;
		this.setOutPutObject(createdTodo);
	}
	@Override
	public void setOutPutObject(Todo todo) {
		this.outputObject = todo;
	}
	
}
