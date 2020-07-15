package com.cleanarchitecture.todos.api.core.usecases.todo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleanarchitecture.todos.api.core.domain.Todo;
import com.cleanarchitecture.todos.api.core.usecases.UseCase;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.DeleteUseCaseInputValues;
import com.cleanarchitecture.todos.api.core.usecases.todo.io.DeleteUseCaseOutputValues;

import javassist.NotFoundException;


@Service
public class DeleteTodoUseCase implements UseCase<DeleteUseCaseInputValues, DeleteUseCaseOutputValues>{

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public DeleteUseCaseOutputValues execute(DeleteUseCaseInputValues inputValues) throws Exception {
		Optional<Todo> todo =  todoRepository.findById(inputValues.todoId);
		
		if(todo.isPresent()) {
			try {
				todoRepository.deleteById(inputValues.todoId);
			}
			catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
		}
		else {
			throw new NotFoundException("Todo not found");
		}
		
		return null;
	}

}
