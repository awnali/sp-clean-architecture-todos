package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.stereotype.Service;
import com.cleanarchitecture.todos.api.core.domain.Todo;

@Service
public class EditTodoUseCase extends UpdateTodoMultipleAttributesUseCase {

	@Override
	protected Todo update(Todo todo, InputValues input) {
		return todo.editTodo(input.getName(), input.getStatus());
	}
}
