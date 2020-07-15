package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;

public class EditUseCaseInputValues implements UseCaseInputValues {
	public Todo todo;

	public EditUseCaseInputValues(Todo todo) {
		this.todo = todo;
	}
}
