package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;

public class CreateTodoUseCaseInputValues implements UseCaseInputValues {
	
	public String name;
	public String userId;
	
	public CreateTodoUseCaseInputValues(String name, String userId){
		this.name = name;
		this.userId = userId;
	}

	public String getName() {
		return name;
	}


	public String getUserId() {
		return userId;
	}
	
}
