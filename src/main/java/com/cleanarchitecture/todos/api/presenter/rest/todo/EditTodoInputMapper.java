package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.EditUseCaseInputValues;
import com.cleanarchitecture.todos.api.presenter.rest.requests.EditTodoRequest;

public final class EditTodoInputMapper {

	public static EditUseCaseInputValues map(EditTodoRequest editTodoRequest) {
		
		return new EditUseCaseInputValues(new Todo());
	}
}
