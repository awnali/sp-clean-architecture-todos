package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.EditTodoUseCase;
import com.cleanarchitecture.todos.api.presenter.rest.requests.EditTodoRequest;

public final class EditTodoInputMapper {

	public static EditTodoUseCase.InputValues map(EditTodoRequest editTodoRequest, Long id) {

		return new EditTodoUseCase.InputValues(id, editTodoRequest.getName(), editTodoRequest.getStatus());
	}
}
