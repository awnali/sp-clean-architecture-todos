package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

@Service
public class GetTodoByIdUseCase implements UseCase<GetTodoByIdUseCase.InputValues, GetTodoByIdUseCase.OuputValues> {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public GetTodoByIdUseCase.OuputValues execute(InputValues inputValues) throws Exception {

		Todo todo = todoRepository.findById(inputValues.getId()).orElse(null);

		if (todo == null) {
			throw new Exception("Todo not found");
		}

		return new GetTodoByIdUseCase.OuputValues(todo);
	}

	public static class InputValues implements UseCaseInputValues {
		public Long id;

		public InputValues(Long id) {
			super();
			this.id = id;
		}

		public Long getId() {
			return id;
		}

	}

	public class OuputValues extends UseCaseOutputValues<Todo> {

		public OuputValues(Todo todo){
			this.setOutPutObject(todo);
		}

		@Override
		protected void setOutPutObject(Todo todo) {
			this.outputObject = todo;
		}

	}
}
