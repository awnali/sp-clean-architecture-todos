package com.cleanarchitecture.todos.api.presenter.rest.todo;

import com.cleanarchitecture.todos.api.core.usecases.todo.io.DeleteUseCaseInputValues;

public final class DeleteTodoInputMapper {
	
	public static DeleteUseCaseInputValues map(Long todoId, String userId) {
		return new DeleteUseCaseInputValues(userId, todoId);
	}
}
