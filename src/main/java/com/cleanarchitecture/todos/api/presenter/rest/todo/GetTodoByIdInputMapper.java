package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.GetTodoByIdUseCase;

public class GetTodoByIdInputMapper {
	public static GetTodoByIdUseCase.InputValues map(Long id) {
		return new GetTodoByIdUseCase.InputValues(id);
	}
}