
package com.cleanarchitecture.todos.api.core.usecases.todo.io;

import java.util.List;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

public class GetAllPaginatedTodosUseCaseOuputValues extends UseCaseOutputValues<List<Todo>> {

	public GetAllPaginatedTodosUseCaseOuputValues(List<Todo> todos) {
		this.setOutPutObject(todos);
	}

	@Override
	protected void setOutPutObject(List<Todo> todos) {
		this.outputObject = todos;
	}

}
