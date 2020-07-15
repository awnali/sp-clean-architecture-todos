package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetTodoByIdUseCaseInputValues;

public class GetTodoByIdInputMapper {
	public static GetTodoByIdUseCaseInputValues map(Long id) {
		return new GetTodoByIdUseCaseInputValues(id);
	}
}
