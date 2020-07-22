package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.beans.factory.annotation.Autowired;
import com.cleanarchitecture.todos.api.core.domain.NotFoundException;
import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

public abstract class UpdateTodoAttributeUseCase
		implements UseCase<GetTodoByIdUseCase.InputValues, UpdateTodoAttributeUseCase.OutputValues> {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public UpdateTodoAttributeUseCase.OutputValues execute(GetTodoByIdUseCase.InputValues inputValues) throws Exception {
		try {
			Todo todo = todoRepository.findById(inputValues.getId()).map(this::update).map(this::save)
					.orElseThrow(() -> new NotFoundException("Todo id %s not found", inputValues.getId()));
			return new UpdateTodoAttributeUseCase.OutputValues(todo);

		} catch (Exception ex) {

		}
		return null;
	}

	private Todo save(Todo todo) {
		return todoRepository.persist(todo);
	}

	protected abstract Todo update(Todo todo);

	public class OutputValues extends UseCaseOutputValues<Todo> {

		public OutputValues(Todo todo) {
			this.setOutPutObject(todo);
		}

		@Override
		protected void setOutPutObject(Todo todo) {
			this.outputObject = todo;

		}

	}
}
