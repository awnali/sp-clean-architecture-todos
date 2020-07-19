package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.CreateTodoUseCase;
import com.cleanarchitecture.todos.api.presenter.rest.requests.CreateTodoRequet;

public final class CreateTodoInputMapper {

	public static CreateTodoUseCase.InputValues map(CreateTodoRequet createTodoRequet, String userId) {
		return new CreateTodoUseCase.InputValues(createTodoRequet.getName(), userId);
	}
}
