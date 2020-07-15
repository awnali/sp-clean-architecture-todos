package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.beans.factory.annotation.Autowired;

import com.cleanarchitecture.todos.api.core.domain.NotFoundException;
import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetTodoByIdUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.UpdateTodoUseCaseOutputValues;

public abstract class UpdateTodoUseCase
		implements UseCase<GetTodoByIdUseCaseInputValues, UpdateTodoUseCaseOutputValues> {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public UpdateTodoUseCaseOutputValues execute(GetTodoByIdUseCaseInputValues inputValues) throws Exception {
		try {
			Todo todo = todoRepository.findById(inputValues.getId()).map(this::changeStatus).map(this::save)
					.orElseThrow(() -> new NotFoundException("Todo id %s not found", inputValues.getId()));
			return new UpdateTodoUseCaseOutputValues(todo);

		} catch (Exception ex) {

		}
		return null;
	}

	private Todo save(Todo todo) {
		return todoRepository.persist(todo);
	}

	protected abstract Todo changeStatus(Todo todo);
}
