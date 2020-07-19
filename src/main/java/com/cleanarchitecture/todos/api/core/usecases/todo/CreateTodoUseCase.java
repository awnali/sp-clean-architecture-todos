package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.UseCaseOutputValues;

@Service
public class CreateTodoUseCase implements UseCase<CreateTodoUseCase.InputValues, CreateTodoUseCase.OuputValues> {

	private TodoRepository todoRepository;

	public CreateTodoUseCase(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public CreateTodoUseCase.OuputValues execute(InputValues inputValues) throws Exception {
		
		Optional<Todo> todo = todoRepository.findByName(inputValues.getName());
		
		Todo newTodo = null;

		if (todo.isPresent()) { // todo already exists with the same name from this user
			throw new Exception("This todo already exists");
		}
		else {
			try {
				newTodo = Todo.makeTodo(inputValues.getName());
				newTodo = this.save(newTodo);
				return new CreateTodoUseCase.OuputValues(newTodo);
			}
			catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
	}
	
	private Todo save(Todo todo) {
		return todoRepository.persist(todo);
	}
	
	
	public static class InputValues implements UseCaseInputValues {
		
		public String name;
		public String userId;
		
		public InputValues(String name, String userId){
			this.name = name;
			this.userId = userId;
		}

		public String getName() {
			return name;
		}


		public String getUserId() {
			return userId;
		}
		
	}
	
	public class OuputValues extends UseCaseOutputValues<Todo> {
		public Todo createdTodo;
		public OuputValues(Todo createdTodo) {
			super();
			this.createdTodo = createdTodo;
			this.setOutPutObject(createdTodo);
		}
		@Override
		public void setOutPutObject(Todo todo) {
			this.outputObject = todo;
		}
		
	}
}
