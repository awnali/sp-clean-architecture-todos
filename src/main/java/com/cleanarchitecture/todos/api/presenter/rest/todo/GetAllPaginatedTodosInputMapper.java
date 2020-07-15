package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetAllPaginatedTodosUseCaseInputValues;

public class GetAllPaginatedTodosInputMapper {
	public static GetAllPaginatedTodosUseCaseInputValues map(Integer pageNumber) {
		return new GetAllPaginatedTodosUseCaseInputValues(pageNumber);
	}
}
