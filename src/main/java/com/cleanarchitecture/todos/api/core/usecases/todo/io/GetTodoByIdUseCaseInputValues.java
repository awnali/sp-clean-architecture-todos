package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;

public class GetTodoByIdUseCaseInputValues implements UseCaseInputValues {
	public Long id;

	public GetTodoByIdUseCaseInputValues(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
