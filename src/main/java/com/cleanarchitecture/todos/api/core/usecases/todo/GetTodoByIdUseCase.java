package com.cleanarchitecture.todos.api.core.usecases.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetTodoByIdUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetTodoByIdUseCaseOuputValues;

@Service
public class GetTodoByIdUseCase implements UseCase<GetTodoByIdUseCaseInputValues, GetTodoByIdUseCaseOuputValues> {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public GetTodoByIdUseCaseOuputValues execute(GetTodoByIdUseCaseInputValues inputValues) throws Exception {

		Todo todo = todoRepository.findById(inputValues.getId()).orElse(null);

		if (todo == null) {
			throw new Exception("Todo not found");
		}

		return new GetTodoByIdUseCaseOuputValues(todo);
	}
}
