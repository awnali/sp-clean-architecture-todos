package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.enums.TodoStatus;

@Service
public class MarkCompletedUseCase extends UpdateTodoUseCase {

	@Override
	protected Todo changeStatus(Todo todo) {
		todo.setStatus(TodoStatus.COMPLETED);
		return todo;
	}

}
