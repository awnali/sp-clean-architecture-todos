package com.cleanarchitecture.todos.api.presenter.rest.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleanarchitecture.todos.api.common.ReturnApiResponse;
import com.cleanarchitecture.todos.api.core.usecases.todo.CreateTodoUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.DeleteTodoUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.EditTodoUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.CreateTodoUseCaseOuputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.DeleteUseCaseOutputValues;
import com.cleanarchitecture.todos.api.presenter.rest.requests.CreateTodoRequet;
import com.cleanarchitecture.todos.api.presenter.rest.requests.EditTodoRequest;
import com.cleanarchitecture.todos.api.presenter.rest.responses.ApiResponse;
import com.cleanarchitecture.todos.api.presenter.rest.responses.CreateTodoResponse;
import com.cleanarchitecture.todos.api.presenter.rest.responses.TodoEditResponse;
import com.cleanarchitecture.todos.api.presenter.rest.todo.exceptions.MyExceptionHandler;

@RestController
@RequestMapping("/todos")
public class TodoController extends MyExceptionHandler {

	private static final long serialVersionUID = 8029147301944705494L;

	@Autowired
	private CreateTodoUseCase createTodoUseCase;

	@Autowired
	private DeleteTodoUseCase deleteTodoUseCase;

	@Autowired
	private EditTodoUseCase editTodoUseCase;

	@GetMapping("/")
	public String getAllTodos() {
		return "working";
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<CreateTodoResponse>> createTodo(@RequestBody CreateTodoRequet createTodoRequet) {
		String userId = "awn.ale";
		try {
			CreateTodoUseCaseOuputValues createTodoUseCaseOuputValues = this.createTodoUseCase
					.execute(CreateTodoInputMapper.map(createTodoRequet, userId));
			return new SuccessResponseMapper<CreateTodoResponse, CreateTodoUseCaseOuputValues>()
					.map(createTodoUseCaseOuputValues);
		} catch (Exception ex) {
			return ReturnApiResponse.error(ex.getMessage());
		}
	}

	@PostMapping("/delete/{todoId}")
	public ResponseEntity<ApiResponse<Object>> deleteTodo(@PathVariable Long todoId) {
		String userId = "awn.ale";
		try {

			DeleteUseCaseOutputValues deleteUseCaseOutputValues = this.deleteTodoUseCase
					.execute(DeleteTodoInputMapper.map(todoId, userId));
			return new SuccessResponseMapper<Object, DeleteUseCaseOutputValues>().map(deleteUseCaseOutputValues);
		} catch (Exception ex) {
			return ReturnApiResponse.error(ex.getMessage());
		}
	}

	@PostMapping("/edit/{todoId}")
	public TodoEditResponse EditTodo(@PathVariable String todoId, @RequestBody EditTodoRequest editTodoRequest) {

		editTodoUseCase.execute(EditTodoInputMapper.map(editTodoRequest));
		System.out
				.println(todoId + ", name: " + editTodoRequest.getName() + ", status: " + editTodoRequest.getStatus());

		return null;
	}
}
