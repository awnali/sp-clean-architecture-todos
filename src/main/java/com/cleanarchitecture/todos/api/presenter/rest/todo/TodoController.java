package com.cleanarchitecture.todos.api.presenter.rest.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cleanarchitecture.todos.api.common.ReturnApiResponse;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseExecutor;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.CreateTodoUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.DeleteTodoUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.EditTodoUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.GetAllPaginatedTodosUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.GetTodoByIdUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.MarkCompletedUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.MarkInProgressUseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.CreateTodoUseCaseOuputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetAllPaginatedTodosUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetAllPaginatedTodosUseCaseOuputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.GetTodoByIdUseCaseOuputValues;
import com.cleanarchitecture.todos.api.presenter.rest.requests.CreateTodoRequet;
import com.cleanarchitecture.todos.api.presenter.rest.requests.EditTodoRequest;
import com.cleanarchitecture.todos.api.presenter.rest.responses.ApiResponse;
import com.cleanarchitecture.todos.api.presenter.rest.responses.GetTodoResponse;
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

	@Autowired
	private GetTodoByIdUseCase getTodoByIdUseCase;

	@Autowired
	private GetAllPaginatedTodosUseCase getAllPaginatedTodosUseCase;

	@Autowired
	private MarkInProgressUseCase markInProgressUseCase;

	@Autowired
	private MarkCompletedUseCase markCompletedUseCase;

	@GetMapping("/")
	public ResponseEntity<ApiResponse<List<GetTodoResponse>>> getPaginatedTodos(
			@RequestParam(required = false, defaultValue = "0") Integer page) {

		return new UseCaseExecutor<List<GetTodoResponse>>().execute(this.getAllPaginatedTodosUseCase,
				GetAllPaginatedTodosInputMapper.map(page));

	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<GetTodoResponse>> getOne(@PathVariable Long id) {
		return new UseCaseExecutor<GetTodoResponse>().execute(this.getTodoByIdUseCase,
				GetTodoByIdInputMapper.map(id));
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<GetTodoResponse>> create(@RequestBody CreateTodoRequet createTodoRequet) {
		String userId = "awn.ale";
		
		return new UseCaseExecutor<GetTodoResponse>().execute(this.createTodoUseCase,
				CreateTodoInputMapper.map(createTodoRequet, userId));
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
		String userId = "awn.ale";
		
		return new UseCaseExecutor<Object>().execute(this.deleteTodoUseCase,
				GetTodoByIdInputMapper.map(id));
	}

	@PostMapping("/in-progress/{id}")
	public ResponseEntity<ApiResponse<GetTodoResponse>> markInProgress(@PathVariable Long id) {
		
		return new UseCaseExecutor<GetTodoResponse>().execute(this.markInProgressUseCase,
				GetTodoByIdInputMapper.map(id));
	}

	@PostMapping("/completed/{id}")
	public ResponseEntity<ApiResponse<GetTodoResponse>> markComplete(@PathVariable Long id) {
		
		return new UseCaseExecutor<GetTodoResponse>().execute(this.markCompletedUseCase,
				GetTodoByIdInputMapper.map(id));
	}

	@PostMapping("/edit/{todoId}")
	public TodoEditResponse edit(@PathVariable String todoId, @RequestBody EditTodoRequest editTodoRequest) {

		editTodoUseCase.execute(EditTodoInputMapper.map(editTodoRequest));
		System.out
				.println(todoId + ", name: " + editTodoRequest.getName() + ", status: " + editTodoRequest.getStatus());

		return null;
	}
}
