package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.beans.factory.annotation.Autowired;

import com.cleanarchitecture.todos.api.core.domain.NotFoundException;
import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.domain.enums.TodoStatus;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

public abstract class UpdateTodoMultipleAttributesUseCase implements
		UseCase<UpdateTodoMultipleAttributesUseCase.InputValues, UpdateTodoMultipleAttributesUseCase.OutputValues> {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public UpdateTodoMultipleAttributesUseCase.OutputValues execute(
			UpdateTodoMultipleAttributesUseCase.InputValues inputValues) throws Exception {
		try {
			Todo todo = todoRepository.findById(inputValues.getId()).map((t) -> update(t, inputValues)).map(this::save)
					.orElseThrow(() -> new NotFoundException("Todo id %s not found", inputValues.getId()));

			return new UpdateTodoMultipleAttributesUseCase.OutputValues(todo);

		} catch (Exception ex) {

		}
		return null;
	}

	private Todo save(Todo todo) {
		return todoRepository.persist(todo);
	}

	protected abstract Todo update(Todo todo, InputValues input);

	public static class InputValues implements UseCaseInputValues {
		Long id;
		String name;
		TodoStatus status;

		public InputValues(Long id, String name, TodoStatus status) {
			super();
			this.id = id;
			this.name = name;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public TodoStatus getStatus() {
			return status;
		}

	}

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
