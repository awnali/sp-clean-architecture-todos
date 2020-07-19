package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.GetAllPaginatedTodosUseCase;

public class GetAllPaginatedTodosInputMapper {
	public static GetAllPaginatedTodosUseCase.InputValues map(Integer pageNumber) {
		return new GetAllPaginatedTodosUseCase.InputValues(pageNumber);
	}
}
