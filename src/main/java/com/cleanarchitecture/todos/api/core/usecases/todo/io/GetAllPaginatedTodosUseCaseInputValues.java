package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;

public class GetAllPaginatedTodosUseCaseInputValues implements UseCaseInputValues {
	private int pageNumber;

	public GetAllPaginatedTodosUseCaseInputValues(int pageNumber) {
		super();
		this.pageNumber = pageNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}
}
