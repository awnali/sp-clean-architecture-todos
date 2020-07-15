package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetAllPaginatedTodosUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetAllPaginatedTodosUseCaseOuputValues;

@Service
public class GetAllPaginatedTodosUseCase
		implements UseCase<GetAllPaginatedTodosUseCaseInputValues, GetAllPaginatedTodosUseCaseOuputValues> {

	@Autowired
	TodoRepository todoRepository;

	private final int pageSize = 5;

	@Override
	public GetAllPaginatedTodosUseCaseOuputValues execute(GetAllPaginatedTodosUseCaseInputValues inputValues)
			throws Exception {
		try {
			List<Todo> todos = this.todoRepository.findAll(inputValues.getPageNumber(), pageSize);
			return new GetAllPaginatedTodosUseCaseOuputValues(todos);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
}
