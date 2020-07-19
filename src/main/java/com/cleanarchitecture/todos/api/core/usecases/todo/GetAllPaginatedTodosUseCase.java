package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

@Service
public class GetAllPaginatedTodosUseCase
		implements UseCase<GetAllPaginatedTodosUseCase.InputValues, GetAllPaginatedTodosUseCase.OuputValues> {

	@Autowired
	TodoRepository todoRepository;

	private final int pageSize = 5;

	@Override
	public GetAllPaginatedTodosUseCase.OuputValues execute(InputValues inputValues)
			throws Exception {
		try {
			List<Todo> todos = this.todoRepository.findAll(inputValues.getPageNumber(), pageSize);
			return new GetAllPaginatedTodosUseCase.OuputValues(todos);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	public static class InputValues implements UseCaseInputValues {
		private int pageNumber;

		public InputValues(int pageNumber) {
			super();
			this.pageNumber = pageNumber;
		}

		public int getPageNumber() {
			return pageNumber;
		}
	}
	
	public class OuputValues extends UseCaseOutputValues<List<Todo>> {

		public OuputValues(List<Todo> todos) {
			this.setOutPutObject(todos);
		}

		@Override
		protected void setOutPutObject(List<Todo> todos) {
			this.outputObject = todos;
		}

	}
}
