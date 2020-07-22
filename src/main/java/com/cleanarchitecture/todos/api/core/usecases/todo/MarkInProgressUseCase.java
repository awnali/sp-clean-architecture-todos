package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.domain.enums.TodoStatus;

@Service
public class MarkInProgressUseCase extends UpdateTodoAttributeUseCase {

	@Override
	protected Todo update(Todo todo) {
		todo.setStatus(TodoStatus.IN_PROGRESS);
		return todo;
	}

}
