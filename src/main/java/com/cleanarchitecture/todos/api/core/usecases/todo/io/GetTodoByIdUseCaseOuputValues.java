package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

public class GetTodoByIdUseCaseOuputValues extends UseCaseOutputValues<Todo> {
	
	public GetTodoByIdUseCaseOuputValues(Todo todo){
		this.setOutPutObject(todo);
	}
	@Override
	protected void setOutPutObject(Todo todo) {
		this.outputObject = todo;
	}

}
