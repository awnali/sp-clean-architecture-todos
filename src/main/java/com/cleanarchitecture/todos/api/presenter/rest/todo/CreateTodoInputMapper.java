package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.io.CreateTodoUseCaseInputValues;
import com.cleanarchitecture.todos.api.presenter.rest.requests.CreateTodoRequet;

public final class CreateTodoInputMapper {

	public static CreateTodoUseCaseInputValues map(CreateTodoRequet createTodoRequet, String userId) {
		return new CreateTodoUseCaseInputValues(createTodoRequet.getName(), userId);
	}
}
