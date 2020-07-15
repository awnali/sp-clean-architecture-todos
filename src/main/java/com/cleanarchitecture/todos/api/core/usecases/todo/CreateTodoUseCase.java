package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.CreateTodoUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.CreateTodoUseCaseOuputValues;

@Service
public class CreateTodoUseCase implements UseCase<CreateTodoUseCaseInputValues, CreateTodoUseCaseOuputValues> {

	private TodoRepository todoRepository;

	public CreateTodoUseCase(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public CreateTodoUseCaseOuputValues execute(CreateTodoUseCaseInputValues inputValues) throws Exception {

		Optional<Todo> todo = todoRepository.findByName(inputValues.getName());
		
		Todo newTodo = null;

		if (todo.isPresent()) { // todo already exists with the same name from this user
			throw new Exception("This todo already exists");
		}
		else {
			try {
				newTodo = Todo.makeTodo(inputValues.getName());
				newTodo = this.save(newTodo);
				return new CreateTodoUseCaseOuputValues(newTodo);
			}
			catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
	}
	private Todo save(Todo todo) {
		return todoRepository.persist(todo);
	}

}
